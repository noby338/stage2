package priv.noby.listener.listener;

import priv.noby.listener.model.User;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

/**
 * 通过监听器移除移除已登录的用户
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    /**
     * 当session被销毁时执行
     * @param httpSessionEvent
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        User user = (User)session.getAttribute("user");
        ServletContext servletContext = session.getServletContext();
        HashMap<String,User> map = (HashMap<String,User>)servletContext.getAttribute("map");
        if (user != null) {
            map.remove(user.getUsername());
        }
    }
}
