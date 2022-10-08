package note.servlet;

import com.alibaba.fastjson.JSON;
import note.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/JsonNoteServlet")
public class JsonNoteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ArrayList<Student> students = new ArrayList<>();

        Student student = new Student("noby", 20, "man");
        Student student2 = new Student("kace", 20, "man");
        Student student3 = new Student("july", 20, "man");

        Collections.addAll(students,student,student2,student3);
        //可直接将集合转换为字符串
        String jsonString = JSON.toJSONString(students);
        response.getWriter().write(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
