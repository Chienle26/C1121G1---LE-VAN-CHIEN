package controller;

import model.Contract;
import model.Employee;
import service.IContractService;
import service.impl.ContractService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractController", value = "/contracts")
public class ContractController extends HttpServlet {
    IContractService iContractService = new ContractService();
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
                List<Contract> contractList = this.iContractService.findAll();
                request.setAttribute("contractList", contractList);
                request.getRequestDispatcher("/contracts/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
