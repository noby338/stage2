package priv.noby.listener.listener;

import priv.noby.listener.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

/**
 * ServletContext初始化设置一个ServletContext属性用于存储所有登陆的用户
 *
 * @author Noby
 * @since 2023/3/25 19:20
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    /**
     * 当服务器启动时执行
     *
     * @param servletContextEvent
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HashMap<String, User> map = new HashMap<>();
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("map", map);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
