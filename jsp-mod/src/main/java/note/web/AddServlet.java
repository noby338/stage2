package note.web;

import note.pojo.Brand;
import note.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brand brand = new Brand();
        request.setCharacterEncoding("utf-8");
        brand.setBrandName(request.getParameter("brandName"));
        brand.setCompanyName(request.getParameter("companyName"));
        brand.setOrdered(Integer.parseInt(request.getParameter("ordered")));
        brand.setDescription(request.getParameter("description"));
        brand.setStatus(Integer.parseInt(request.getParameter("status")));
        brandService.add(brand);
//        boolean insert = brandService.insert(brand);
//        System.out.println(insert);
        request.getRequestDispatcher("selectAllServlet").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
