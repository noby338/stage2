package note.dao.impl;

import note.dao.StudentDao;
import note.dao.StudentDao2;
import note.entity.Student;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自动映射
 * <p>
 * 接口映射：mybatis为了方便调用SQL、传参提供了接口映射xml的编程方式，用一个接口与对应的xml进行映射，分为手动映射和自动映射
 * 自动映射：mybatis根据结果集的字段名自动得到对应的setter方法名，通过反射调用setter方法给属性赋值完成数据映射
 * 手动映射：指程序员通过配置的方式告诉mybatis哪个字段映射到哪个属性上，例如当字段名与属性名不一致时、自动映射无法完成数据映射时；
 * <p>
 * 注意事项：
 * 1.接口名字最好与对应的mapper文件一致
 * 2.接口最好与mapper文件在同一包下
 * 3.mapper文件的namespace必须是对应接口的全限定名
 * 4.接口中的方法名与对应SQL的id要保持一致
 * 5.接口的返回值类型要与SQL的结果保持一致
 * 6.在解析mapper文件时用package标签引入，不建议使用mapper标签
 */
public class StudentDaoTest2 {
    private SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    //通过动态代理自动生成StudentDao的实现类
    private StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

    /**
     * 显示动态代理的实现类
     */
    @Test
    public void showStudentDao() {
        System.out.println("studentDao = " + studentDao);
        //org.apache.ibatis.binding.MapperProxy@8646db9 是一个动态代理的类
    }


    /**
     * 添加且可返回id，第一种方法
     */
    @Test
    public void testInsertStudent() {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("1999-4-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student("kace", true, date);

        System.out.println("before:" + student);
        studentDao.insert(student);
        System.out.println("after:" + student);
        sqlSession.close();
    }

    /**
     * 添加且可返回id，第二种方法
     */
    @Test
    public void testInsertStudentResId() {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("1999-4-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student("noby", true, date);
        System.out.println("before:" + student);
        studentDao.insertResId(student);
        System.out.println("after:" + student);
        sqlSession.close();
    }

    /**
     * 删除可返回删除的数量
     */
    @Test
    public void testDeleteStudentById() {
        System.out.println("studentDao.deleteById(42) = " +
                studentDao.deleteById(42));
        sqlSession.close();
    }

    /**
     * 单个查询
     */
    @Test
    public void testSelectStudentById() {
        System.out.println("studentDao.selectById(3) = " +
                studentDao.selectById(3));
        sqlSession.close();
    }

    /**
     * 修改可返回修改的数量
     */
    @Test
    public void testUpdateStudent() {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("1999-4-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(studentDao.update(new Student(6, "kace", true, date)));
//        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 查询所有
     */
    @Test
    public void testSelectAllStudent() {
        System.out.println("studentDao.selectAll() = " +
                studentDao.selectAll());
        sqlSession.close();
    }


    /**
     * 使用Param注解传入多个参数
     */
    @Test
    public void testSelectStudentRangeBirthday() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateLow = null;
        Date dateHigh = null;
        try {
            dateLow = simpleDateFormat.parse("2022-1-29");
            dateHigh = simpleDateFormat.parse("2022-9-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("studentDao.selectRangeBirthday(dateLow,dateHigh) = " +
                studentDao.selectRangeBirthday(dateLow, dateHigh));
        sqlSession.close();
    }

    /**
     * 模糊查询
     */
    @Test
    public void testSelectStudentLikeName() {
        System.out.println("studentDao.selectLikeName(\"冬梅\") = " +
                studentDao.selectLikeName("冬梅")
        );
        sqlSession.close();
    }

    /**
     * 单个查询使用mybatis注解
     */
    @Test
    public void testSelectStudentById2() {
        StudentDao2 mapper = sqlSession.getMapper(StudentDao2.class);
        System.out.println("mapper.selectById(3) = " +
                mapper.selectById2(3));
        sqlSession.close();
    }
}