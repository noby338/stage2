package priv.mall.noby.service.impl;

import org.apache.ibatis.session.SqlSession;
import priv.mall.noby.dao.CustomerDao;
import priv.mall.noby.entity.Customer;
import priv.mall.noby.entity.Page;
import priv.mall.noby.service.CustomerService;
import priv.mall.noby.util.MybatisUtil;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{


    @Override
    public List<Customer> selectAllCustomer() {
        SqlSession sqlSession  = null;
        CustomerDao mapper = null;
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(CustomerDao.class);
        List<Customer> customers = mapper.selectAllCustomer();
        if (sqlSession != null) {
            sqlSession.close();
        }
        return customers;
    }

    @Override
    public Page<Customer> selectByPage(Page page) {
        SqlSession sqlSession = null;
        CustomerDao mapper = null;
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(CustomerDao.class);
        Page<Customer> customerPage = new Page<>();
        customerPage.setList(mapper.selectByPage(page));
        customerPage.setPageIndex(page.getPageIndex());
        customerPage.setPageSize(page.getPageSize());
        customerPage.setRecordTotal(mapper.selectCount());
        return customerPage;
    }


    @Override
    public Page<Customer> selectByFilter(Customer customer,Page<Customer> page) {
        SqlSession sqlSession = null;
        CustomerDao mapper = null;
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(CustomerDao.class);
        Page<Customer> customerPage = new Page<>();
        customerPage.setList(mapper.selectByFilter(customer,page));
        customerPage.setPageIndex(page.getPageIndex());
        customerPage.setPageSize(page.getPageSize());
        customerPage.setRecordTotal(mapper.selectCountByFilter(customer));
        customerPage.setStartAndEnd();
        if (sqlSession != null) {
            sqlSession.close();
        }
        return customerPage;
    }

    @Override
    public void deleteByCid(int cid) {
        SqlSession sqlSession = null;
        CustomerDao mapper = null;
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(CustomerDao.class);
        mapper.deleteByCid(cid);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
