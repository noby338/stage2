package note.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/fileUploadAjaxServlet")
public class FileUploadAjaxServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        String author = "";
        String fileName = "";
        //1。创建DiskFileItemFactory工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2。配置一个临时存储文件
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        //3。创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        try {
            //4。解析请求，得到FileItem集合
            List<FileItem> items = upload.parseRequest(request);
            //遍历集合
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                //获取FileItem对象
                FileItem fileItem = iterator.next();
                //判断是普通表单元素，还是文件域
                if (fileItem.isFormField()) {
                    //是普通表单元素，获取值
                    String fieldName = fileItem.getFieldName();
                    if ("author".equals(fieldName)) {
                        //获取表单元素的值
                        author = fileItem.getString();
                    }
                } else {
                    //是文件，获取文件名称
                    fileName = fileItem.getName();
                    String filePath = null; //文件路径
                    //获取文件的绝对路径
                    filePath = getServletContext().getRealPath("uploads");
                    //创建文件对象
                    File file = new File(filePath + "/" + fileName);
                    //实现上传功能
                    fileItem.write(file);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.print("true");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
