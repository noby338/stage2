package priv.noby.ajax.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用异步方式测试注册时的用户名是否重复验证
 *
 * @author Noby
 * @since 2023/3/25 18:18
 */
@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        if ("noby".equals(username)) {
            response.getWriter().write("" + true);
        }else if("admin".equals(username)){
            String[] names = {"jack","rose","lucy","lily"};
            response.getWriter().write(JSON.toJSONString(names));
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}

