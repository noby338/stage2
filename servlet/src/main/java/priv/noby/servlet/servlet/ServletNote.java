package priv.noby.servlet.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 通过配置web.xml实现servlet的访问
 * servlet的生命周期
 * ServletConfig类
 * 本类通过web.xml配置
 */
//@WebServlet(name = "servletNote",
//        urlPatterns = {"/servletNote"},
//        initParams = {
//                @WebInitParam(name = "ENCODING", value = "UTF-8")
//        },
//        loadOnStartup = -1
//)
/*
name属性可随意
ServletConfig初始化对象的参数
loadOnStartup
（1）负整数:第一次访问时创建Servlet对象
（2）0或正整数:服务器启动时创建Servlet对象，数字越小优先级越高
 */
public class ServletNote implements Servlet {
    private ServletConfig servletConfig = null;//该对象保存的即为<servlet>标签内的信息

    /**
     * 只在servlet第一次访问的时候调用一次
     *
     * @param servletConfig
     */
    @Override
    public void init(ServletConfig servletConfig) {
        /*
        tomcat在执行init方法之前，读取web.xml中的配置文件，并将配置文件信息封装为ServletConfig对象，传入到init方法中
         */
        this.servletConfig = servletConfig;
        System.out.println("init执行");
        System.out.println("servletConfig.getInitParameter(\"ENCODING\") = " + servletConfig.getInitParameter("ENCODING"));
    }

    /**
     * 返回servlet配置对象
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * 提供服务的方法
     * 每一次servlet被访问时调用该方法
     *
     * @param servletRequest
     * @param servletResponse
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println(servletConfig.getInitParameter("ENCODING"));//通过servletConfig对象获取web.xml文件中的配置参数
        System.out.println("service执行");
    }

    /**
     * 返回servlet信息
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 服务器关闭和servlet对象被销毁时调用该方法
     * 只调用一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy执行");
    }
}
