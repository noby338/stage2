package priv.mall.noby.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import priv.mall.noby.entity.Customer;
import priv.mall.noby.entity.Page;
import priv.mall.noby.service.CustomerService;

public class CustomerServiceImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSelectByPage() {
        CustomerService customerService = new CustomerServiceImpl();
        Page<Customer> page = new Page<>();
        page.setPageSize(10);
        page.setPageIndex(1);
        Page<Customer> customerPage = customerService.selectByPage(page);
        System.out.println(customerPage);
    }

    @Test
    public void testDeleteByCid() {
        CustomerService customerService = new CustomerServiceImpl();
        customerService.deleteByCid(161);
    }
}