package controller;

import model.Customer;
import model.Facility;
import service.IServiceService;
import service.impl.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceController", value = "/services")
public class ServiceController extends HttpServlet {
    IServiceService iServiceService = new ServiceService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                showCreateForm(request, response);
//                break;
            default:
                List<Facility> facilityList = this.iServiceService.findAll();
                request.setAttribute("facilityList", facilityList);
                request.getRequestDispatcher("/services/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
