package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
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
//                deleteSanPham(request, response);
//                break;
            default:
//                listSanPham(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                createSanPham(request, response);
//                break;
//            case "edit":
//                editSanPham(request, response);
//                break;
//            case "searchTheoTen":
//                searchTheoTen(request, response);
//                break;
//            case "searchTheoGia":
//                searchTheoGia(request,response);
//                break;
//            case "searchTheoDanhMuc":
//                searchTheoDanhMuc(request,response);
//                break;
//            case "searchTheoMau":
//                searchTheoMau(request,response);
//                break;
        }
    }
}
