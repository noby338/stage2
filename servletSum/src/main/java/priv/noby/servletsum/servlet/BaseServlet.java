package priv.noby.servletsum.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应乱码
        response.setContentType("text/html;charset=UTF-8");
        //post请求乱码
        request.setCharacterEncoding("UTF-8");
        //获取method参数，这个参数决定调用哪个方法
        String methodName = request.getParameter("method");
        Method method;

        try {
            //在当前Servlet中查找指定的方法
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("不存在方法：" + methodName, e);
        }

        try {
            //调用方法，返回字符串
            String result = (String) method.invoke(this, request, response);
            if (result != null && !result.trim().isEmpty()) {
                //获取:下标位置
                int index = result.indexOf(":");
                if (index == -1) {
                    //没有，默认就是转发
                    request.getRequestDispatcher(result).forward(request, response);
                } else {
                    //start就是:前面的单词
                    String start = result.substring(0, index);
                    //path就是:后面的路径
                    String path = result.substring(index + 1);
                    if (start.equals("f")) {
                        // f:开头就转发
                        request.getRequestDispatcher(path).forward(request, response);
                    } else if (start.equals("r")) {
                        // r:开头就重定向
                        response.sendRedirect(request.getContextPath() + path);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

