package controller;

import DTO.ProductDTO;
import model.Category;
import model.Color;
import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();

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
//             showCreateForm(request, response);
//                break;
            case "new":
                showNew(request, response);
                break;
            case "search":
                searchProductByName(request, response);
                break;
            case "delete":
//                showDeleteModal(request, response);
                break;
            default:
                listCustomers(request, response);
        }
    }

    private void showNew(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productDTOList = productService.getAllProDuct();
        List<Category> categoryList = productService.getAllCategory();
        List<Color> colorList = productService.getAllColor();

        request.setAttribute("colorList", colorList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("productDTOList", productDTOList);
        try {
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        List<ProductDTO> productDTOList = productService.findProductByName(nameSearch);
        List<Category> categoryList = productService.getAllCategory();
        List<Color> colorList = productService.getAllColor();
        request.setAttribute("searchName", nameSearch);
        request.setAttribute("colorList", colorList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("productDTOList", productDTOList);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productDTOList = productService.getAllProDuct();
        List<Category> categoryList = productService.getAllCategory();
        List<Color> colorList = productService.getAllColor();
        request.setAttribute("colorList", colorList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("productDTOList", productDTOList);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("idEditModal"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        Integer color = Integer.valueOf(request.getParameter("color"));
        Integer categoryId = Integer.valueOf(request.getParameter("category_id"));
        Product product = new Product(id, name, price, quantity, color, categoryId);
        if (productService.editProduct(product)) {
            this.listCustomers(request, response);
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("idModalDelete"));
        if (productService.deleteProduct(id)) {
            this.listCustomers(request, response);
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        Integer color = Integer.valueOf(request.getParameter("color"));
        Integer category = Integer.valueOf(request.getParameter("category_id"));
        Product product = new Product(name, price, quantity, color, category);
        productService.addNewProduct(product);

        this.listCustomers(request, response);
    }
}
