package note.web;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet.doPost");
        String username = request.getParameter("username");
        if ("noby".equals(username)) {
            response.getWriter().write("" + true);
        }else if("admin".equals(username)){
            String[] names = {"jack","rose","lucy","lily"};
            response.getWriter().write(JSON.toJSONString(names));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

