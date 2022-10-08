package note.httpServlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
响应头设置
响应码设置
响应编码设置
响应内容设置（字符，字节）
重定向
 */
@WebServlet("/ResponseServletNote")
public class ResponseServletNote extends HttpServlet {

    /**
     * 发送响应
     * 响应字符
     * 设置响应的编码方式1，通过调用response的setContentType()方法
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");//响应的数据为html,浏览器解码方式为utf-8
//        /* 等同于该代码块
//        response.setHeader("content-type", "text/html");//设置相应的内容类型
//        response.setCharacterEncoding("utf-8");//设置内容的浏览器解码方式
//        */
//        request.setCharacterEncoding("utf-8");//设置服务器响应文字的编码方式为utf-8
//        PrintWriter writer = response.getWriter();//响应的数据为字符
//        writer.write("write()方法执行1");
//    }

    /**
     * 发送响应
     * 设置自定义响应头
     * 设置响应的编码方式2，通过设置响应头
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("username","noby");//设置响应头，用户自定义响应头，浏览器可接收该信息
//        response.setHeader("Content-Type","text/html;charset=utf-8");//http协议响应头，该方法等同于response.setContentType("text/html;charset=utf-8")
//        response.setCharacterEncoding("utf-8");//设置服务器响应的编码方式为utf-8（该语句在上行语句书写后可以省略）
//        PrintWriter writer = response.getWriter();
//        writer.write("write()方法执行2");
//    }

    /**
     * 发送图片字节响应
     * 通过commons-io实现流的对拷
     * 通过上下文对象获取输入流
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        InputStream fileInputStream=this.getServletContext().getResourceAsStream("/img/joker.jpg");
//        ServletOutputStream outputStream = response.getOutputStream();
//        System.out.println(this.getServletContext());
//        IOUtils.copy(fileInputStream,outputStream);//利用外部工具实现流的对拷(输入流，输出流)
//        fileInputStream.close();
//    }

    /**
     * 发送pdf字节响应
     * 通过commons-io实现流的对拷
     * 通过上下文对象获取输入流
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Application/pdf;charset=uft-8");//可省略改行
        ServletContext servletContext = this.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/serverStartup.pdf");
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);//利用commons-io实现流的对拷(输入流，输出流)
        inputStream.close();
    }


    /**
     * 重定向方法1，调用重定向方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("/servlet/redirect.html");
//    }

    /**
     * 设置响应码
     * 重定向方法2，设置响应码和响应头
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //200 正常响应，404 未找到资源文件，405 请求方式错误，500 java代码异常，302 重定向
//        response.setStatus(302);
//        response.setHeader("location","/servlet/redirect.html");
////        response.sendError(404,"人为设置资源未找到");
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
