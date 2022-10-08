package note.dao;

import note.entity.Page;
import note.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentDao {
    int insert(Student student);
    int insertResId(Student student);
    int deleteById(int id);
    Student selectById(int id);
    int update(Student student);
    List<Student> selectAll();
    List<Student> selectRangeBirthday(@Param("dateLow") Date dateLow,@Param("dateHigh") Date dateHigh);
    List<Student> selectLikeName(String name);
    List<Student> selectByPage(Page page);
    List<Student> selectAllByPageHelper();
}
