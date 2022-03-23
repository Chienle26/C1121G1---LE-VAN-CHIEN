package controller;

import model.SanPhamDTO;
import service.ISanPhamService;
import service.impl.SanPhamService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamController", value = "/sanPham")
public class SanPhamController extends HttpServlet {
    ISanPhamService iSanPhamService = new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                showCreateForm(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;
            default:
                List<SanPhamDTO> sanPhamList = this.iSanPhamService.findAllDTO();
                request.setAttribute("sanPhamList", sanPhamList);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
