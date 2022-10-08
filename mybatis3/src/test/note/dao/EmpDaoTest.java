package note.dao;

import note.entity.Emp;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 手动映射
 *
 * 接口映射：mybatis为了方便调用SQL、传参提供了接口映射xml的编程方式，用一个接口与对应的xml进行映射，分为手动映射和自动映射
 * 自动映射：mybatis根据结果集的字段名自动得到对应的setter方法名，通过反射调用setter方法给属性赋值完成数据映射
 * 手动映射：指程序员通过配置的方式告诉mybatis哪个字段映射到哪个属性上，例如当字段名与属性名不一致时、自动映射无法完成数据映射时；
 * 注意事项：
 * 	1.接口名字最好与对应的mapper文件一致
 *  2.接口最好与mapper文件在同一包下
 *  3.mapper文件的namespace必须是对应接口的全名
 *  4.接口中的方法名与对应SQL的id要保持一致
 *  5.接口的返回值类型要与SQL的结果保持一致
 *  6.在解析mapper文件时用package标签引入，不要用mapper标签
 */
public class EmpDaoTest {
    SqlSession sqlSession = null;
    EmpDao empDao = null;

    @Before
    public void setUp() throws Exception {
        sqlSession = SqlSessionUtil.getSqlSession();
        empDao = sqlSession.getMapper(EmpDao.class);
    }

    @After
    public void tearDown() throws Exception {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void selectEmpByEid() {
        Emp emp = empDao.selectEmpById(2);
        System.out.println(emp);
    }
    @Test
    public void selectEmpByEid2() {
        Emp emp = empDao.selectEmpById2(2);
        System.out.println(emp);
    }

}