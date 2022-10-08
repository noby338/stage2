package note.hidden;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过表单隐藏域在页面之间传递数据
 */
@WebServlet("/hiddenServlet")
public class HiddenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String newHtml = "<form action=\"/servlet/hiddenServlet2\" method=\"post\">\n" +
                "    问题1：<input type=\"input\" name=\"q1\">\n" +
                "    问题2：<input type=\"input\" name=\"q2\">\n" +
                "    <input type=\"submit\" value=\"下一页\">\n" +
                "</form>";
        writer.write(newHtml);
        writer.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
