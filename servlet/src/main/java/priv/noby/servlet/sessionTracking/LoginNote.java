package priv.noby.servlet.sessionTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 利用cookie记住用户名
 * 利用session传递验证码
 * 利用验证码工具类生成验证码
 */
@WebServlet("/loginNote")
public class LoginNote extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userCode = request.getParameter("userCode");

        //利用cookie记住用户名
        Cookie usernameCookie = new Cookie("username", username);
        response.addCookie(usernameCookie);

        //利用session传递验证信息，该session是VerifyCodeServletNote在生成验证图片后写入
        String sessionCode = session.getAttribute("sessionCode").toString();

        if ("noby".equals(username)) {
            if ("123".equals(password)) {
                if (userCode.equalsIgnoreCase(sessionCode)) {
                    response.getWriter().write("欢迎：" + username);
                } else {
                    response.getWriter().write("验证码错误");
                }
            } else {
                response.getWriter().write("密码错误");
            }
        } else {
            response.getWriter().write("该用户未注册");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
