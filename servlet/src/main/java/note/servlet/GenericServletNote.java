package note.servlet;

import javax.servlet.*;

/**
 * GenericServlet类与Servlet类的继承关系
 */
public class GenericServletNote extends GenericServlet {
    /*
    GenericServlet类中除了service()方法，其他方法均已重写


    Tomcat源码
    初始化调用
        init(ServletConfig config)
        class GenericServlet(){
            init(ServletConfig config){
                //通用的代码都已经执行了
                //保存config到成员变量
                init()
            }
            init(){
                //空方法,给你自定义扩展
            }
        }
        class GenericServletNote extends GenericServlet(){
            init(){
                //重写
            }
        }
     */

    /**
     * servlet类的init()方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * GenericServlet类中重写的init()方法，并将ServletConfig对象赋值，用以getServletConfig()直接调用
     * 使用重写用该方法
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {

    }
}
