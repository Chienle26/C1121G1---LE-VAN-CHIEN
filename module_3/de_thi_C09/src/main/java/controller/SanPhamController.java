package controller;

import model.DanhMuc;
import model.MauSac;
import model.SanPham;
import model.SanPhamDTO;
import service.IDanhMucService;
import service.IMauSacService;
import service.ISanPhamService;
import service.impl.DanhMucService;
import service.impl.MauSacService;
import service.impl.SanPhamService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SanPhamController", value = {"/sanPham",""})
public class SanPhamController extends HttpServlet {
    ISanPhamService iSanPhamService = new SanPhamService();
    IDanhMucService iDanhMucService = new DanhMucService();
    IMauSacService iMauSacService = new MauSacService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteSanPham(request, response);
                break;
            default:
                List<SanPhamDTO> sanPhamList = this.iSanPhamService.findAllDTO();
                request.setAttribute("sanPhamList", sanPhamList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        Integer idSanPham = Integer.valueOf(request.getParameter("id"));
        SanPham sanPham = iSanPhamService.findSanPhamById(idSanPham);
        List<DanhMuc> danhMucList = this.iDanhMucService.findAll();
        List<MauSac> mauSacList = this.iMauSacService.findAll();
        try {
            request.setAttribute("danhMucList",danhMucList);
            request.setAttribute("mauSacList",mauSacList);
            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("deleteByModal"));
        iSanPhamService.deleteSanPham(id);
        try {
            response.sendRedirect("/sanPham");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<DanhMuc> danhMucList = this.iDanhMucService.findAll();
        List<MauSac> mauSacList = this.iMauSacService.findAll();
        try {
            request.setAttribute("danhMucList",danhMucList);
            request.setAttribute("mauSacList",mauSacList);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
            case "create":
                createSanPham(request, response);
                break;
            case "edit":
                editSanPham(request, response);
                break;
            case "searchTheoTen":
                searchTheoTen(request, response);
                break;
            case "searchTheoGia":
                searchTheoGia(request,response);
                break;
            case "searchTheoDanhMuc":
                searchTheoDanhMuc(request,response);
                break;
            case "searchTheoMau":
                searchTheoMau(request,response);
                break;
        }
    }

    private void editSanPham(HttpServletRequest request, HttpServletResponse response) {
        Integer idSanPham= Integer.valueOf(request.getParameter("idSanPham"));
        String tenSanPham= request.getParameter("tenSanPham");
        Double gia= Double.valueOf(request.getParameter("gia"));
        Integer soLuong= Integer.valueOf(request.getParameter("soLuong"));
        Integer idMauSac= Integer.valueOf(request.getParameter("idMauSac"));
        String moTa= request.getParameter("moTa");
        Integer idDanhMuc= Integer.valueOf(request.getParameter("idDanhMuc"));
        SanPham sanPham = new SanPham(idSanPham,tenSanPham,gia,soLuong,idMauSac,moTa,idDanhMuc);

        iSanPhamService.editSanPham(sanPham);
//        Map<String,String> map = iCustomerService.editCustomerRegex(customer);

        List<DanhMuc> danhMucList = this.iDanhMucService.findAll();
        List<MauSac> mauSacList = this.iMauSacService.findAll();

        request.setAttribute("danhMucList",danhMucList);
        request.setAttribute("mauSacList",mauSacList);

//        if (map.isEmpty()){
//            request.setAttribute("message","Chỉnh sửa thành công!");
//        } else {
//            request.setAttribute("map",map);
//            request.setAttribute("customer",customer);
//        }
        try {
//            request.getRequestDispatcher("edit.jsp").forward(request, response);
            response.sendRedirect("/sanPham");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchTheoMau(HttpServletRequest request, HttpServletResponse response) {
        String mauSac = request.getParameter("searchTheoMau");
        List<SanPhamDTO> sanPhamList = iSanPhamService.searchTheoMau(mauSac);
        request.setAttribute("sanPhamList",sanPhamList);
        try {
            request.getRequestDispatcher("search.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchTheoDanhMuc(HttpServletRequest request, HttpServletResponse response) {
        String danhMuc = request.getParameter("searchTheoDanhMuc");
        List<SanPhamDTO> sanPhamList = iSanPhamService.searchTheoDanhMuc(danhMuc);
        request.setAttribute("sanPhamList",sanPhamList);
        try {
            request.getRequestDispatcher("search.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchTheoGia(HttpServletRequest request, HttpServletResponse response) {
        Double gia = Double.valueOf(request.getParameter("searchTheoGia"));
        List<SanPhamDTO> sanPhamList = iSanPhamService.searchTheoGia(gia);
        request.setAttribute("sanPhamList",sanPhamList);
        try {
            request.getRequestDispatcher("search.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchTheoTen(HttpServletRequest request, HttpServletResponse response) {
        String tenSanPham = request.getParameter("searchTheoTen");
        List<SanPhamDTO> sanPhamList = iSanPhamService.searchTheoTen(tenSanPham);
        request.setAttribute("sanPhamList",sanPhamList);
        try {
            request.getRequestDispatcher("search.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createSanPham(HttpServletRequest request, HttpServletResponse response) {
         Integer idSanPham= Integer.valueOf(request.getParameter("idSanPham"));
         String tenSanPham= request.getParameter("tenSanPham");
         Double gia= Double.valueOf(request.getParameter("gia"));
         Integer soLuong= Integer.valueOf(request.getParameter("soLuong"));
         Integer idMauSac= Integer.valueOf(request.getParameter("idMauSac"));
         String moTa= request.getParameter("moTa");
         Integer idDanhMuc= Integer.valueOf(request.getParameter("idDanhMuc"));
         SanPham sanPham = new SanPham(idSanPham,tenSanPham,gia,soLuong,idMauSac,moTa,idDanhMuc);

         this.iSanPhamService.createSanPham(sanPham);

//        Map<String,String> map = iCustomerService.createCustomerRegex(customer);

        List<DanhMuc> danhMucList = this.iDanhMucService.findAll();
        List<MauSac> mauSacList = this.iMauSacService.findAll();

        request.setAttribute("danhMucList",danhMucList);
        request.setAttribute("mauSacList",mauSacList);

//        if (map.isEmpty()){
//            request.setAttribute("message","Thêm mới thành công!");
//        } else {
//            request.setAttribute("map",map);
//        }
        try {
            response.sendRedirect("/sanPham");
//            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
