package priv.noby.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//需要过滤的资源（可以拦截servlet和其他资源文件）
/*
 * /a.jsp"表示拦截某一特定文件
 * /filterdir/*"表示拦截该路径下的所有资源(其子目录下的资源也可以拦截)
 * /dServlet"拦截某一特定servlet
 * /*.html"拦截所有html文件
 * /*拦截所有资源
 *
 */
@WebFilter(filterName = "FilterNoteFilter",value = {"/a.jsp","/filterdir/*","/dServlet","*.html"})
public class FilterNoteFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        //在初始化容器的使用已经执行
        System.out.println("FilterInit");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        /*
        执行顺序：
        放行前一般处理request数据...
        访问a.jsp资源...
        放行后一般处理response数据...
        访问完资源之后还会回到filter执行chain.doFilter()后面的语句
         */
        System.out.println("放行前一般处理request数据...");
        chain.doFilter(request, response);//放行（没有该语句则不能访问到资源）
        System.out.println("放行后一般处理response数据...");
    }
}
