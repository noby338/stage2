package priv.noby.servletsum.service;

import priv.noby.servletsum.entity.Customer;
import priv.noby.servletsum.entity.Page;

import java.util.List;

public interface CustomerService {

    List<Customer> selectAllCustomer();
    Page<Customer> selectByPage(Page page);
    Page<Customer> selectByFilter(Customer customer,Page<Customer> page);
    void deleteByCid(int cid);
}
