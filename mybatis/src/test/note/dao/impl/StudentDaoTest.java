package note.dao.impl;

import note.dao.StudentDao;
import note.entity.Student;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * 不使用接口映射
 *
 * mybatis查询数据封装对象的原理：
 * 1.通过namespace.id  找到SQL语句进行执行
 * 2.得到ResultSet对象，获得sql记录和字段
 * 3.通过resultType属性指定的类型得到该类的字节码对象，然后通过反射的方式得到字段对应setter方法的名字、参数的类型
 * 4.创建对象
 * 5.如果为单个对象，返回对象。如果有多个对象，以list的方式返回
 *
 *
 */
public class StudentDaoTest {
    private SqlSession sqlSession = SqlSessionUtil.getSqlSession();

    /**
     * 这种 MyBatis 的操作方式称为基于语句（Statement）的操作，是 MyBatis 中最基础、最原始的操作方式。它不需要 Mapper 接口
     * 查询一个
     * 该方法不依赖StudentDao接口中的方法，即使不存在该接口也能执行
     */
    @Test
    public void testSelectOne() {
        //返回的为一个对象时用selectOne
        Object o = sqlSession.selectOne("note.dao.StudentDao.selectById", 1);//已配置<package name="note.dao"/>可简写为selectById
        Student student = (Student) o;
        System.out.println("student = " + student);
        sqlSession.close();
    }

    /**
     * mybatis的接口手动代理
     * 利用StudentDao的实体类查询一个(用户自己实现该接口，后期的常规用法是mybatis通过动态代理自动实现该实现类)
     */
    @Test
    public void testSelectOne2() {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.selectById(1);
        System.out.println("student = " + student);
        sqlSession.close();
    }


    /**
     * 利用map集合传入多个参数
     */
    @Test
    public void testSelectRangeBirthdayByMap() {
        LocalDate dateLow = LocalDate.of(1999, 1, 1);
        LocalDate dateHigh = LocalDate.of(2004, 9, 1);

        HashMap<String, Object> map = new HashMap<>();
        map.put("dateLow",dateLow.toString());
        map.put("dateHigh",dateHigh.toString());
        //返回的为多个对象时用selectList
        Object o = sqlSession.selectList("note.dao.StudentDao.selectRangeBirthday", map);
        List<Student> students = (List<Student>) o;
        System.out.println("students = " + students);
        sqlSession.close();

    }


}