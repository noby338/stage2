package priv.noby.jspmod.web;

import priv.noby.jspmod.pojo.Brand;
import priv.noby.jspmod.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    public BrandService brandService= new BrandService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brand brand = brandService.selectById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/updateBrand.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
