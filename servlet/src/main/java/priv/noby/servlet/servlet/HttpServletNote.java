package priv.noby.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet和Servlet的继承关系
 * 通过注解配置Servlet的访问路径
 */
@WebServlet(urlPatterns = "/httpServletNote",//tomcat访问路径
        initParams = {@WebInitParam(name = "username", value = "noby"), @WebInitParam(name = "password", value = "123")},//servlet初始化参数
        loadOnStartup = 0)
/*
name属性可随意
ServletConfig初始化对象的参数
loadOnStartup
（1）负整数:第一次访问时创建Servlet对象
（2）0或正整数:服务器启动时创建Servlet对象，数字越小优先级越高

@WebServlet的使用注意：
    @WebServlet的value属性名等同于 urlPatterns 属性名，等同于直接书写属性值
    @WebServlet(urlPatterns = {"/urlPattern1","/urlPattern2"})//一个servlet可以配置多个urlPattern
    @WebServlet(urlPatterns = "/user/select")//精确匹配
    @WebServlet(urlPatterns = "/user/*")//目录匹配(*表示任何内容)
    @WebServlet("*.do")//扩展名匹配
    @WebServlet("/*")//任意匹配
    @WebServlet("/")//任意匹配

    不推荐"/"的方法使用任意匹配，其会覆盖tomcat的DefaultServlet
    tomcat的DefaultServlet用于获取静态资源
    优先级：
    精确目录>目录路径>扩展名路径>/*>/

注解使用注意：
    1、当注解的属性名为value时，可以省略value=的书写方式，直接写属性值；
    2、当注解中的属性不唯一时，不能省略value=的书写；
    3、使用某一注解，该注解的所有属性必须赋值（WebServlet注解没有全部赋值因为除urlPattern以外的所有属性都已通过default赋初值）
    4、注解的属性可以是注解
    5、注解的属性可以是数组，当数组的长度为一时，可以省略{}的书写
 */
public class HttpServletNote extends HttpServlet {
    /**
     * Servlet接口中的方法
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    /**
     * HttpServlet重写的方法，并将ServletRequest和ServletResponse向下转型，
     * 同时，可以判断请求参数的类型，根据类型调用post()或get()方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        //调用的为ServletConfig类的getInitParameter()，getServletContext()。他们都是来自GenericServlet的重写，
        System.out.println("this.getInitParameter(\"username\") = " + this.getInitParameter("username"));
        System.out.println("getInitParameter(\"password\") = " + getInitParameter("password"));
        System.out.println("getServletContext().getInitParameter(\"info2\") = " + getServletContext().getInitParameter("info2"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HttpServletNote.doPost");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HttpServletNote.doGet");
//        this.doPost(request, response);
    }
}
