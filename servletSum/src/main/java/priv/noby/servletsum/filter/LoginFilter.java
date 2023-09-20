package priv.noby.servletsum.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Noby
 * @since 2022/10/7
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String[] urlArray = {"/index.jsp", "/css/", "/login.jsp", "/loginServlet", "/userServlet"};
        String requestUrl = request.getRequestURL().toString();
        for (String url : urlArray) {
            if (requestUrl.contains(url)) {
                filterChain.doFilter(request, servletResponse);
                return;
            }
        }

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(request, servletResponse);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
