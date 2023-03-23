package priv.noby.listener.servlet;

import priv.noby.listener.model.User;
import priv.noby.listener.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        ServletContext servletContext = this.getServletContext();//this表示当前servlet对象
        Map<String, User> map = (Map<String, User>) servletContext.getAttribute("map");
        String op = request.getParameter("op");
        if ("login".equals(op)) {
            User user = userService.login(request.getParameter("username"), request.getParameter("password"));
            if (user != null) {
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(180);//会话超时后销毁该session，单位为秒
                map.put(user.getUsername(), user);
                response.sendRedirect("/listener/login_list.jsp");
            } else {
                response.sendRedirect("/listener/login.html");
            }
        } else if ("out".equals(op)) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                map.remove(user.getUsername());
                session.invalidate();
                response.sendRedirect("/listener/login_list.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
