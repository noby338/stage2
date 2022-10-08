package priv.mall.noby.servlet;

import com.alibaba.fastjson.JSON;
import priv.mall.noby.entity.Customer;
import priv.mall.noby.entity.Page;
import priv.mall.noby.service.impl.CustomerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerServlet")
public class CustomerServlet extends BaseServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    //region 异步请求
    public String selectByFilterAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int cid = request.getParameter("cid") == "" || request.getParameter("cid") == null ? 0 : Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        String profession = request.getParameter("profession");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        Customer customer = new Customer();

        customer.setCid(cid);
        customer.setCname(cname);
        customer.setProfession(profession);
        customer.setEmail(email);
        customer.setGender(gender);

        Page<Customer> page = new Page<>();
        if (request.getParameter("pageIndex") == null) {
            page.setPageIndex(1);
        } else {
            page.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
        }
        page.setPageSize(6);
        Page<Customer> customerPage = customerService.selectByFilter(customer, page);
        String jsonString = JSON.toJSONString(customerPage);
        response.getWriter().write(jsonString);
        return null;
    }

    public String deleteCustomerAjax(HttpServletRequest request, HttpServletResponse response) {
        int cid = Integer.parseInt(request.getParameter("delCid"));
        customerService.deleteByCid(cid);
        return null;
    }
    //endregion 异步请求

    //region 同步请求
    public String deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int cid = Integer.parseInt(request.getParameter("delCid"));
        customerService.deleteByCid(cid);
        request.removeAttribute("delCid");
        return "f:/customerServlet?method=selectByFilter";
    }
    public String selectAll(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.selectAllCustomer();
        request.setAttribute("customers", customers);
        return "f:/selectAll.jsp";
    }

    public String selectByFilter(HttpServletRequest request, HttpServletResponse response){
        int cid = request.getParameter("cid") == "" || request.getParameter("cid") == null ? 0 : Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        String profession = request.getParameter("profession");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        Customer customer = new Customer();
        customer.setCid(cid);
        customer.setCname(cname);
        customer.setProfession(profession);
        customer.setEmail(email);
        customer.setGender(gender);

        request.setAttribute("customer",customer);

        Page<Customer> page = new Page<>();
        if (request.getParameter("pageIndex") == null) {
            page.setPageIndex(1);
        } else {
            page.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
        }
        page.setPageSize(6);
        Page<Customer> customerPage = customerService.selectByFilter(customer, page);
        request.setAttribute("customerPage", customerPage);
        return "/selectByFilter.jsp";
    }

    public String selectByPage(HttpServletRequest request, HttpServletResponse response) {
        Page<Customer> page = new Page<>();
        if (request.getParameter("pageIndex") == null) {
            page.setPageIndex(1);
        } else {
            page.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
        }
        page.setPageSize(6);
        Page<Customer> customerPage = customerService.selectByPage(page);

        request.setAttribute("customerPage", customerPage);
        return "/selectByPage.jsp";
    }
    //endregion 同步请求
}
