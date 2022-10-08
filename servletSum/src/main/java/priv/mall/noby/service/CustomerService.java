package priv.mall.noby.service;

import priv.mall.noby.entity.Customer;
import priv.mall.noby.entity.Page;

import java.util.List;

public interface CustomerService {

    List<Customer> selectAllCustomer();
    Page<Customer> selectByPage(Page page);
    Page<Customer> selectByFilter(Customer customer,Page<Customer> page);
    void deleteByCid(int cid);
}
