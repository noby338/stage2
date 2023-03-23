package priv.noby.servletsum.servlet;

import priv.noby.servletsum.entity.User;
import priv.noby.servletsum.service.UserService;
import priv.noby.servletsum.service.impl.UserServiceImpl;
import priv.noby.servletsum.util.PasswordUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    public String login (HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(PasswordUtil.getMD5String(password));
        User userRes = userService.queryByUser(user);
        if (userRes != null) {
            session.setAttribute("user", userRes);
        } else {
            return "r:/login.jsp";
        }
        return "r:/index.jsp";
    }

    public String logout (HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "r:/index.jsp";
    }

}
