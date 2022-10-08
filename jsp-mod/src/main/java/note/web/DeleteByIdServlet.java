package note.web;

import note.pojo.Brand;
import note.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    public BrandService brandService = new BrandService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(request.getParameter("id")));
        brandService.delectById(brand);
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
