package note.dao;

import note.entity.Student;
import org.apache.ibatis.annotations.Select;

/**
 * mybatis的注解映射
 * @author Noby
 * @since 2022/10/1
 */
public interface StudentDao2 {
    @Select("select * from student where id = #{id}")
    Student selectById2(int id);
}
