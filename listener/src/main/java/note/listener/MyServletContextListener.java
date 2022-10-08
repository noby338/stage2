package note.listener;

import note.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

/**
 * 通过监听器记录已登录的用户
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    /**
     * 当服务器启动时执行
     * @param servletContextEvent
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HashMap<String, User> map = new HashMap<>();
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("map",map);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
