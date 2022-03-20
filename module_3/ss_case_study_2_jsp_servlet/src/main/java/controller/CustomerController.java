package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/customers")
public class CustomerController extends HttpServlet {
    ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                List<Customer> customerList = this.iCustomerService.findAll();
                request.setAttribute("customerList", customerList);
                request.getRequestDispatcher("/customers/list.jsp").forward(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/customers/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
            createCustomer(request,response);
            break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String address = request.getParameter("address");
        Integer customerTypeCode = Integer.valueOf(request.getParameter("customerTypeCode"));
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String IDNumber = request.getParameter("IDNumber");
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        String name =request.getParameter("name");
        String customerCode = request.getParameter("customerCode");
        Customer customer = new Customer(customerCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, customerTypeCode, address);
        this.iCustomerService.createCustomer(customer);
        try {
            request.getRequestDispatcher("/customers/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
