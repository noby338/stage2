package note.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import note.dao.StudentDao;
import note.entity.Page;
import note.entity.Student;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 不使用接口映射
 *
 * mybatis查询数据封装对象的原理：
 * 1.通过namespace.id  找到SQL语句进行执行
 * 2.得到ResultSet对象，然后通过反射的方式得到字段对应setter方法的名字、参数的类型
 * 3.通过resultType属性指定的类型得到该类的字节码对象，然后创建对象
 * 4.通过得到setter方法的名字、参数的类型找到对应的setter方法，调用给对应的属性赋值
 * 5.如果有多个对象，以list的方式返回
 *
 *
 */
public class StudentDaoTest {
    private SqlSession sqlSession = SqlSessionUtil.getSqlSession();

    /**
     * 查询一个
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateLow = null;
        Date dateHigh = null;
        try {
            dateLow = simpleDateFormat.parse("2022-1-29");
            dateHigh = simpleDateFormat.parse("2022-9-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        HashMap<String, Object> map = new HashMap<>();
        map.put("dateLow",dateLow);
        map.put("dateHigh",dateHigh);
        //返回的为多个对象时用selectList
        Object o = sqlSession.selectList("note.dao.StudentDao.selectRangeBirthday", map);
        List<Student> students = (List<Student>) o;
        System.out.println("students = " + students);
        sqlSession.close();

    }

    /**
     * 利用实体类传入多个参数
     * 使用自己的类实现分页查询
     */
    @Test
    public void testSelectRangeBirthdayByEntity() {
        Page page = new Page();
        page.setPageNum(1);
        page.setPageSize(4);
        Object object = sqlSession.selectList("note.dao.StudentDao.selectByPage", page);
        List<Student> studentList = (List<Student>) object;
        page.setData(studentList);
        System.out.println("page = " + page);
        sqlSession.close();

    }

    /**
     * 使用pageHelper分页查询
     */
    @Test
    public void testSelectAllByPageHelper() {
        PageInfo<Student> pageInfo;
        PageHelper.startPage(1, 4);
        Object object = sqlSession.selectList("note.dao.StudentDao.selectAllByPageHelper");
        List<Student> studentList = (List<Student>) object;
        pageInfo = new PageInfo<Student>(studentList);
        System.out.println("pageInfo = " + pageInfo);
        sqlSession.close();

    }
}