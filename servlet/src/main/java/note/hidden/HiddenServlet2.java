package note.hidden;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hiddenServlet2")
public class HiddenServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<form action=\"/servlet/hiddenServlet3\" method=\"post\">\n");
        writer.write("    <input type=\"hidden\" name=\"q1\" value=\"" + request.getParameter("q1") + "\">\n");
        writer.write("    <input type=\"hidden\" name=\"q2\" value=\"" + request.getParameter("q2") + "\">\n");
        writer.write("    问题3：<input type=\"input\" name=\"q3\">\n");
        writer.write("    问题4：<input type=\"input\" name=\"q4\">\n");
        writer.write("    <input type=\"submit\" value=\"提交\">\n");
        writer.write("</form>\n");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
