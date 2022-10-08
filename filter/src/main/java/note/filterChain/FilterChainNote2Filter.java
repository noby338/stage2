package note.filterChain;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Noby
 * @since 2022/10/6
 */
@WebFilter({"/filter_chain.jsp"})
public class FilterChainNote2Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterChainNoteFilter2 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterChainNoteFilter2 doFilter 执行前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterChainNoteFilter2 doFilter 执行后");
    }

    @Override
    public void destroy() {

    }
}
