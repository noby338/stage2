package priv.noby.servlet.httpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/RequestServletNote")
public class RequestServletNote extends HttpServlet {

    /**
     * 请求头的获取
     * 解决请求的中文乱码问题（tomcat8以后的get请求无中问乱码问题）
     * 获取请求参数的几种方式
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charSet=utf-8");
        request.setCharacterEncoding("utf-8");//解决请求中文乱码（该方法不能处理get请求乱码，因为设置的为请求体的乱码，get请求参数位于请求行中）
        /*
        * get请求乱码的原因：
            * 浏览器请求行中的请求参数为utf-8的url编码方式，tomcat8之前默认使用的iso-8859-1的解码方式，之后为utf-8
        * get解决方式：
            * 设置tomcat配置文件的默认解码方式
            * new String(username.getBytes("ISO_8859_1"), "utf-8") ()
        * post请求乱码的原因：
            * 浏览器请求体为utf-8的编码方式，tomcat默认使用的iso-8859-1的解码方式
        * post解决方式：
            * request.setCharacterEncoding("utf-8");
         */
        //获取请求头
        System.out.println("request.getHeader(\"user-agent\") = " + request.getHeader("user-agent"));//获取请求头
        System.out.println("request.getParameterValues(\"hobby\") = " + Arrays.toString(request.getParameterValues("hobby")));//获取一组参数
        Enumeration<String> parameterNames = request.getParameterNames();//获取所有参数名
        Map<String, String[]> parameterMap = request.getParameterMap();//获取所有参数的键值对


        String username = request.getParameter("username");
        System.out.println("username = " + username);
        PrintWriter writer = response.getWriter();
        writer.write("username:" + username);
    }

    /**
     * 获取请求行的各个参数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取请求行 http://localhost:8080/servlet/RequestServletNote?username=noby&password=123
//        System.out.println("request.getRequestURL() = " + request.getRequestURL());//http://localhost:8080/servlet/RequestServletNote （统一资源定位符）
//        System.out.println("request.getRequestURI() = " + request.getRequestURI());//servlet/RequestServletNote （统一资源标识符）
//        System.out.println("request.getScheme() = " + request.getScheme());//http
//        System.out.println("request.getServerName() = " + request.getServerName());//localhost （服务器id地址）
//        System.out.println("request.getServerPort() = " + request.getServerPort());//8080
//        System.out.println("request.getContextPath() = " + request.getContextPath());//servlet （项目名，上下文路径）
//        System.out.println("request.getServletPath() = " + request.getServletPath());//RequestServletNote （servlet路径）
//        System.out.println("request.getQueryString() = " + request.getQueryString());//username=noby&password=123 （请求参数）
//    }

    /**
     * 请求的转发
     * request域
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //page < request < session < application(ServletContext) 前四个为JavaWeb的四大域对象，后面三个为Servlet三大域对象
//        request.setAttribute("info","转发域属性信息");//域键值对中的值可以是不局限于String的任意类型，request域的生命周期为浏览器请求发起到浏览器接收到服务器响应
//        System.out.println("request.getAttribute(\"info\") = " + request.getAttribute("info"));//获取域属性
//        Enumeration<String> attributeNames = request.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            System.out.println("所有的属性名："+attributeNames.nextElement());
//        }
////        request.removeAttribute("info");//删除域属性
//        request.getRequestDispatcher("/dispatcher.jsp").forward(request,response);//转发的地址为浏览器地址，重定向地址为服务器地址
////        response.sendRedirect("/servlet/dispatcher.jsp");//转发域属性只可以在本次请求有效（转发不属于同一次请求）
//    }

    /**
     * 请求的包含
     * request域
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().write("requestServletNote");//页面的复用底层使用的就是请求的包含
//        //响应的后面不可以有转发和重定向，但是可以有包含
//        request.getRequestDispatcher("/IncludeServlet").include(request,response);//统一个页面可以同时有由多个servlet编辑
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
