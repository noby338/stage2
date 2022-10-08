package note.sessionTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取服务内部的session
 */
@WebServlet("/sessionNote2")
public class SessionNote2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charSet=UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        //销毁session的方法
//        session.invalidate();
        //会话超时后销毁该session(单位为秒，配置文件中的session-config单位为分钟，0或负数为永久有效)
//        session.setMaxInactiveInterval(3);
        String format = String.format("已获取session %s:%s", "password", session.getAttribute("password"));
        System.out.println(format);
        writer.write(format);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
