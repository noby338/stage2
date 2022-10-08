package priv.mall.noby.dao;

import org.apache.ibatis.annotations.Param;
import priv.mall.noby.entity.Customer;
import priv.mall.noby.entity.Page;

import java.util.List;

public interface CustomerDao {
    void insertCustomer(Customer customer);
    Customer selectById(int id);
    List<Customer> selectByPage(Page<Customer> page);
    int selectCount();
    int selectCountByFilter(Customer customer);
    List<Customer> selectAllCustomer();
    List<Customer> selectByFilter(@Param("customer") Customer customer,@Param("page") Page<Customer> page);
    void deleteByCid(int cid);
}
