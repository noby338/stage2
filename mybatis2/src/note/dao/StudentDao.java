package note.dao;

import note.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 通过SQL动态语句if实现数据库的查找
     * @param student
     * @return
     */
    List<Student> selectStudentByIf(Student student);

    /**
     * 通过SQL动态语句where实现数据库的查找
     * @param student
     * @return
     */
    List<Student> selectStudentByWhere(Student student);

    /**
     * 通过SQL动态语句choose实现数据库的查找
     * @param student
     * @return
     */
    List<Student> selectStudentByChoose(Student student);

    /**
     * 通过SQL动态语句foreach实现数据库的查找
     * @param ints
     * @return
     */
    List<Student> selectStudentByArray(int[] ints);

    /**
     * 通过SQL语句的复用实现数据库的查找
     * @param id
     * @return
     */
    Student selectStudentByFragment(int id);

    /**
     * 通过SQL动态语句if实现数据库的修改
     * @param student
     * @return
     */
    boolean updateStudentByIf(Student student);
}
