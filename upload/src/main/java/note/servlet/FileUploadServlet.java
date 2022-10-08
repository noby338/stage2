package note.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
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
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        response.getWriter().println("<h1>文件上传成功，上传者：" + author + ",文件名：" + fileName + "</h1>");



//        response.setContentType("text/html;charset=UTF-8");
////1. 创建DiskFileItemFactory对象，为创建解析器做准备。
//        DiskFileItemFactory factory = new DiskFileItemFactory();
////2. 创建ServletFileUpload解析器，
//        ServletFileUpload upload = new ServletFileUpload(factory);
////设置编码
//        upload.setHeaderEncoding("UTF-8");
////调用parseRequest()方法，将request对象，解析为List<FileItem>
////获取upload真实路径
//        String realPath = getServletContext().getRealPath("/upload");
////优化【文件不存在时自动创建】问题
//        File fPath = new File(realPath);
//        if(fPath.exists()==false){
//            fPath.mkdir();
//        }
////设置文件上传上限最大为：100kb
//        upload.setFileSizeMax(102400);
//        try {
//            List<FileItem> fileItems = upload.parseRequest(request);
//            for (FileItem fileItem : fileItems) {
//                //3. 调用FileItem中isFormField()，查找文件参数
//                if(fileItem.isFormField() == false){
//                    String fName = fileItem.getName();
//                    String uuid = UUID.randomUUID().toString().replace("-", "");
//                    //文件参数，4. 调用FileItem中writer()方法，实现文件上传
//                    File file = new File(realPath+File.separator+uuid+fName);
//                    fileItem.write(file);
//                }else{
//                    //普通参数
//                }
//            }
//            response.getWriter().write("文件上传成功！");
//        } catch (FileUploadBase.FileSizeLimitExceededException e) {
//            response.getWriter().write("文件最大为100kb!");
//            e.printStackTrace();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
