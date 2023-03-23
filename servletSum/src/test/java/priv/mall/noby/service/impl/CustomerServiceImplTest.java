package priv.mall.noby.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import priv.noby.servletsum.entity.Customer;
import priv.noby.servletsum.entity.Page;
import priv.noby.servletsum.service.CustomerService;
import priv.noby.servletsum.service.impl.CustomerServiceImpl;

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
    }

    @Test
    public void testDeleteByCid() {
        CustomerService customerService = new CustomerServiceImpl();
        customerService.deleteByCid(161);
    }
}