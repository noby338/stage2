package note.sessionTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * 服务器读取浏览器发送过来的cookie
 */
@WebServlet("/cookieNote2")
public class CookieNote2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charSet=UTF-8");
        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                writer.write(String.format("cookieNote2已获取cookie %s:%s", cookie.getName(), cookie.getValue()));

                if ("username".equals(cookie.getName())) {
                    String format = String.format("cookieNote2已获取cookie %s:%s", cookie.getName(), URLDecoder.decode(cookie.getValue()));
                    writer.write(format);
                    System.out.println(format);
                }

                if ("username".equals(cookie.getName())) {
                    cookie.setMaxAge(0);//删除该cookie
                    System.out.println("username cookie已删除");
                }
            }
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
