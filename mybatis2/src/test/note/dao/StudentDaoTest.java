package note.dao;

import note.entity.Student;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 动态sql的使用
 */
public class StudentDaoTest {
    private SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    private StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
    /**
     * 通过if动态SQL实现数据库的查找
     */
    @Test
    public void selectStudentByIf() {
        Student student = new Student();
        student.setName("冬梅");
        List<Student> students = studentDao.selectStudentByIf(student);
        System.out.println("students = " + students);
        sqlSession.close();
    }

    /**
     * 通过where,if动态SQL实现数据库的查找
     */
    @Test
    public void selectStudentByWhere() {
        Student student = new Student();
        student.setName("冬梅");
        List<Student> students = studentDao.selectStudentByWhere(student);
        System.out.println("students = " + students);
        sqlSession.close();
    }

    /**
     * 通过Choose动态SQL实现数据库的查找
     */
    @Test
    public void selectStudentByChoose() {
        Student student = new Student();
        student.setName("张");
        List<Student> students = studentDao.selectStudentByChoose(student);
        System.out.println("students = " + students);
        sqlSession.close();
    }
    /**
     * 通过foreach动态SQL实现数据库的查找
     */
    @Test
    public void selectStudentByArray() {
        List<Student> students = studentDao.selectStudentByArray(new int[]{1, 3, 5});
        System.out.println(students);
    }
    /**
     * 通过sql复用动态SQL实现数据库的查找
     */
    @Test
    public void selectStudentByFragment() {
        Student student = studentDao.selectStudentByFragment(1);
        System.out.println(student);
    }

    /**
     * 通过if动态SQL实现数据库的修改
     */
    @Test
    public void updateStudentByIf() {
        Student student = new Student();
        student.setId(1);
        student.setName("noby1");
        boolean b = studentDao.updateStudentByIf(student);
        System.out.println(b);
        sqlSession.close();
    }

}