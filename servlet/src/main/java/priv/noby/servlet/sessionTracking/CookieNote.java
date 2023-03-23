package priv.noby.servlet.sessionTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * 服务器向浏览器写入cookie
 */
@WebServlet("/cookieNote")
public class CookieNote extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charSet=UTF-8");
        /*
        作用：让服务器记住一些客户端的特定信息，响应用户的时候，向浏览器的cookie中写数据，当该浏览器在本次会话再次访问服务器时会携带该cookie数据
        生命周期：默认为当前会话有效（不是当前请求），即为浏览器关闭时结束
         */
        //cookie不能直接存储中文，需要用到url编码
        String value = "noby中文";
        String urlValue = URLEncoder.encode(value, "utf-8");
        Cookie cookie = new Cookie("username",urlValue);//Cookie的值只能为String，且不能直接存储中文
        cookie.setMaxAge(60*60);//设置cookie的有效时间，单位为秒，-1为默认值(关闭浏览器失效，负数都为关闭浏览器失效)，0为删除
        resp.addCookie(cookie);

        String format = String.format("cookieNote已创建 %s:%s", cookie.getName(), cookie.getValue());
        System.out.println(format);
        PrintWriter writer = resp.getWriter();
        writer.write(format);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
