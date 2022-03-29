package controller;

import DTO.TheMuonSachDTO;
import model.HocSinh;
import model.Sach;
import model.TheMuonSach;
import service.ITheMuonSachService;
import service.impl.TheMuonSachService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "heMuonSachController", value = "/themuonsach")
public class TheMuonSachController extends HttpServlet {
    ITheMuonSachService iTheMuonSachService = new TheMuonSachService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "theMuonSach":
//                listTheMuonSach(request, response);
            case "create":
                showCreateForm(request, response);
                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "delete":
//                deleteSanPham(request, response);
//                break;
            default:
                listSach(request,response);
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<HocSinh> hocSinhList = this.iTheMuonSachService.findAllHocSinh();
        List<Sach> sachList = iTheMuonSachService.findAllSach();
        try {
            request.setAttribute("hocSinhList",hocSinhList);
            request.setAttribute("sachList",sachList);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listSach(HttpServletRequest request, HttpServletResponse response) {
        List<Sach> sachList = this.iTheMuonSachService.findAllSach();
        request.setAttribute("sachList", sachList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
//        List<TheMuonSachDTO> theMuonSachDTOList = this.iTheMuonSachService.findAllDTO();
//        request.setAttribute("theMuonSachDTOList", theMuonSachDTOList);
//        try {
//            request.getRequestDispatcher("list.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
                createTheMuonSach(request, response);
                break;
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

    private void createTheMuonSach(HttpServletRequest request, HttpServletResponse response) {
        String maMuonSach= request.getParameter("maMuonSach");
        String maSach= request.getParameter("maSach");
        String maHocSinh= request.getParameter("maHocSinh");
        Boolean trangThai= Boolean.valueOf(request.getParameter("trangThai"));
        String ngayMuon= request.getParameter("ngayMuon");
        String ngayTra= request.getParameter("ngayTra");
        TheMuonSach theMuonSach = new TheMuonSach(maMuonSach,maSach,maHocSinh,trangThai,ngayMuon,ngayTra);

        this.iTheMuonSachService.createTheMuonSach(theMuonSach);

//        Map<String,String> map = iCustomerService.createCustomerRegex(customer);

//        List<DanhMuc> danhMucList = this.iDanhMucService.findAll();
//        List<MauSac> mauSacList = this.iMauSacService.findAll();
//
//        request.setAttribute("danhMucList",danhMucList);
//        request.setAttribute("mauSacList",mauSacList);

//        if (map.isEmpty()){
//            request.setAttribute("message","Thêm mới thành công!");
//        } else {
//            request.setAttribute("map",map);
//        }
        try {
            response.sendRedirect("/themuonsach");
//            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
