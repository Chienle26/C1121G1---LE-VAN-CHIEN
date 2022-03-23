package controller;

import model.Customer;
import model.CustomerDTO;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerController", value = "/customers")
public class CustomerController extends HttpServlet {
    ICustomerService iCustomerService = new CustomerService();
    ICustomerTypeService iCustomerTypeService = new CustomerTypeService();

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
                deleteCustomer(request, response);
                break;
            default:
                List<CustomerDTO> customerList = this.iCustomerService.findAllDTO();
                request.setAttribute("customerList", customerList);
                request.getRequestDispatcher("/customers/list.jsp").forward(request, response);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("deleteByModal"));
        iCustomerService.deleteCustomer(id);
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = iCustomerService.findCustomerById(id);
        List<CustomerType> customerTypeList = this.iCustomerTypeService.findAll();
        try {
            request.setAttribute("customerTypeList",customerTypeList);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/customers/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = this.iCustomerTypeService.findAll();
        try {
            request.setAttribute("customerTypeList",customerTypeList);
            request.getRequestDispatcher("/customers/create.jsp").forward(request, response);
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
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Customer> customerList = iCustomerService.searchByName(name);
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("/customers/search.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String address = request.getParameter("address");
        Integer customerTypeCode = Integer.valueOf(request.getParameter("customerTypeCode"));
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String IDNumber = request.getParameter("IDNumber");
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        String name = request.getParameter("name");
        String customerCode = request.getParameter("customerCode");
        Customer customer = new Customer(name, dateOfBirth, IDNumber, phoneNumber, email, address, customerCode, customerTypeCode, gender);

        Map<String,String> map = iCustomerService.editCustomerRegex(customer);

        List<CustomerType> customerTypeList = this.iCustomerTypeService.findAll();

        request.setAttribute("customerTypeList",customerTypeList);

        if (map.isEmpty()){
            request.setAttribute("message","Chỉnh sửa thành công!");
        } else {
            request.setAttribute("map",map);
            request.setAttribute("customer",customer);
        }
        try {
            request.getRequestDispatcher("/customers/edit.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
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
        String name = request.getParameter("name");
        String customerCode = request.getParameter("customerCode");
        Customer customer = new Customer(name, dateOfBirth, IDNumber, phoneNumber, email, address, customerCode, customerTypeCode, gender);

        Map<String,String> map = iCustomerService.createCustomerRegex(customer);

        List<CustomerType> customerTypeList = this.iCustomerTypeService.findAll();

        request.setAttribute("customerTypeList",customerTypeList);

        if (map.isEmpty()){
            request.setAttribute("message","Thêm mới thành công!");
        } else {
            request.setAttribute("map",map);
        }
        try {
            request.getRequestDispatcher("/customers/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
