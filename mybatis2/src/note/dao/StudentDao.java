package note.dao;

import note.entity.Page;
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

    /**
     * 自定义实现分页查询
     * bind标签的使用
     * @param page
     * @return
     */
    List<Student> selectByPage(Page page);

    /**
     * 通过实体引用转义字符
     * @return
     */
    List<Student> selectStudentByLt();

    /**
     * 通过Cdata区转义字符
     * @return
     */
    List<Student> selectStudentByCdata();
}
