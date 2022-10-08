package note.sessionTracking;

import note.util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 生成随机验证图片和字符
 */
@WebServlet("/verifyCodeNote")
public class VerifyCodeNote extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        String text = verifyCode.getText();
        request.getSession().setAttribute("sessionCode", text);
        VerifyCode.output(image, response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
