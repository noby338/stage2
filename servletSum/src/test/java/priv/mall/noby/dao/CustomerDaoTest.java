package priv.mall.noby.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import priv.noby.servletsum.dao.CustomerDao;
import priv.noby.servletsum.entity.Customer;
import priv.noby.servletsum.util.MybatisUtil;

import java.util.Random;

public class CustomerDaoTest {
    static SqlSession sqlSession = null;
    static CustomerDao mapper = null;

    @Before
    public void setUp() throws Exception {
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(CustomerDao.class);
    }

    @After
    public void tearDown() throws Exception {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertCustomer() {
        Random random = new Random();
        String[] description = {"java程序员", "python程序员", "c程序员", "c++程序员", "c#程序员", "go程序员"};
        String[] emails = {"@gmail.com", "@qq.com", "@163.com"};
        for (int i = 1; i <= 50; i++) {
            Customer customer = new Customer();
            customer.setCname("cus" + i);
            customer.setBirthday("200" + random.nextInt(10) + "-" + (random.nextInt(12) + 1) + "-" + (random.nextInt(28) + 1));
            customer.setCellphone((random.nextInt(900000) + 100000) + "");
            customer.setProfession(description[random.nextInt(6)]);
            customer.setEmail((random.nextInt(900000) + 100000) + emails[random.nextInt(3)]);
            customer.setGender(random.nextInt(2) == 1 ? "男" : "女");
            mapper.insertCustomer(customer);
        }
        sqlSession.commit();
    }

    @Test
    public void testSelectById() {
        Customer customer = mapper.selectById(1);
    }
}