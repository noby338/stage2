package note.url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过url实现页面的跳转
 */
@WebServlet("/urlServlet")
public class UrlServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String page = request.getParameter("page");
        if (page == null) {
            page = "1";
        }

        writer.write("<p>这是第" + page + "页</p>");
        writer.write("<a href='/servlet/urlServlet?page=1'>1</a>");
        writer.write("<a href='/servlet/urlServlet?page=2'>2</a>");
        writer.write("<a href='/servlet/urlServlet?page=3'>3</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
