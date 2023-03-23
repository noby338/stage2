package priv.noby.servlet.sessionTracking;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 回应所有用户获取上下文对象的请求
 * 获取配置文件中的初始化参数
 * servletContext
 * servletConfig
 */
@WebServlet(value = "/servletContextNote2", initParams = {
        @WebInitParam(name = "ENCODING", value = "UTF-8")
})
public class ServletContextNote2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter writer = response.getWriter();
        ServletContext servletContext = this.getServletContext();//（上下文对象）来自GenericServlet对象，它是在服务器启动时就通过服务器自动创建，所有用户共享上下文对象
        ServletConfig servletConfig = this.getServletConfig();
        String infoFormat = String.format("获取到servletContext attribute %s:%s", "info", servletContext.getAttribute("info"));//来自servletContextServletNote设置的域属性
        System.out.println(infoFormat);
        writer.write(infoFormat + "\n");
        String info2Format = String.format("获取到servletContext initParameter %s:%s", "info2", servletContext.getInitParameter("info2"));//来自xml，所有的servlet均可访问
        System.out.println(info2Format);
        writer.write(info2Format + "\n");
        String EncodingFormat = String.format("获取到servletConfig initParameter %s:%s", "ENCODING", servletConfig.getInitParameter("ENCODING"));//来自本类注解，本servlet可访问
        System.out.println(EncodingFormat);
        writer.write(EncodingFormat);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }}
