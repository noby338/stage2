package note.dao.impl;

import note.dao.StudentDao;
import note.entity.Page;
import note.entity.Student;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * 自己定义的实现类，mybatis的常规用法是使用动态代理(该类由mybatis自动生成)
 * @author Noby
 * @since 2022/9/26
 */
public class StudentDaoImpl implements StudentDao {
    private SqlSession sqlSession = SqlSessionUtil.getSqlSession();

    @Override
    public int insert(Student student) {
        return 0;
    }

    @Override
    public int insertResId(Student student) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public Student selectById(int id) {
        Object o = sqlSession.selectOne("selectById", id);
        Student student = (Student) o;
        System.out.println("使用的是自定义的实现类实现查询");
        sqlSession.close();
        return student;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public List<Student> selectAll() {
        return null;
    }

    @Override
    public List<Student> selectRangeBirthday(Date dateLow, Date dateHigh) {
        return null;
    }

    @Override
    public List<Student> selectLikeName(String name) {
        return null;
    }

    @Override
    public List<Student> selectByPage(Page page) {
        return null;
    }

    @Override
    public List<Student> selectAllByPageHelper() {
        return null;
    }
}

