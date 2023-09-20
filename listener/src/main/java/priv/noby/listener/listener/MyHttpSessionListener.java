package priv.noby.listener.listener;

import priv.noby.listener.model.User;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

/**
 * 通过监听器监听session的状态，当session移除时，同时移除ServletContext中的该用户
 * 
 * @author Noby
 * @since 2023/3/25 19:20
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
