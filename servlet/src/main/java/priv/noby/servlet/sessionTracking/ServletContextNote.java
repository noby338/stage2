package priv.noby.servlet.sessionTracking;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 写入上下文对象信息
 */
@WebServlet("/servletContextNote")
public class ServletContextNote extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter writer = response.getWriter();
        ServletContext servletContext = this.getServletContext();//（上下文对象）来自GenericServlet对象，它是在服务器启动时就通过服务器自动创建，所有用户共享上下文对象
        servletContext.setAttribute("info","servletContextValue");
        String infoFormat = String.format("已写入 servletContext %s:%s", "info", "servletContextValue");
        System.out.println(infoFormat);
        writer.write(infoFormat);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
