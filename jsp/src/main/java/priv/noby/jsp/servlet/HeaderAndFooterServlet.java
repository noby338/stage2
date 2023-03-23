package priv.noby.jsp.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HeaderAndFooterServlet")
public class HeaderAndFooterServlet extends BaseServlet {
    public String getFooter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("---------这是一个异步的复用页面footer----------");
        return null;
    }

    public String getHeader(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("info","---------这是一个同步的复用页面header----------");
        return "f:/header.jsp";
    }
}
