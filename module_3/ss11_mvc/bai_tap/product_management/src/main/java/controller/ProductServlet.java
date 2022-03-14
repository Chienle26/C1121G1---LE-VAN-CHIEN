package controller;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {"", "/list", "/product"})
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                Integer id = Integer.valueOf(request.getParameter("id"));
                Product product = this.productService.findById(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
            case "create":
                request.getRequestDispatcher("CreateProduct.jsp").forward(request, response);
                break;
            case "delete":
                Integer id1 = Integer.valueOf(request.getParameter("id"));
                Product product1 = this.productService.findById(id1);
                request.setAttribute("product", product1);
                request.getRequestDispatcher("DeleteProduct.jsp").forward(request, response);
                break;
            case "view":
                Integer id2 = Integer.valueOf(request.getParameter("id"));
                Product product2 = this.productService.findById(id2);
                request.setAttribute("product", product2);
                request.getRequestDispatcher("ViewProduct.jsp").forward(request, response);
                break;
            default:
                List<Product> products = this.productService.findAll();
                request.setAttribute("productListServlet", products);
                request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        RequestDispatcher dispatcher;
        switch (action) {
            case "update":
                Integer id = Integer.valueOf(request.getParameter("id"));
                String name = request.getParameter("name");
                Double price = Double.valueOf(request.getParameter("price"));
                String description = request.getParameter("description");
                String producer = request.getParameter("producer");
                this.productService.update(id, name, price, description, producer);
//                dispatcher = request.getRequestDispatcher("");
                response.sendRedirect("/product");
//                try {
//                    dispatcher.forward(request, response);
//                } catch (ServletException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                break;
            case "create":
                Integer id1 = (int) (Math.random() * 1000);
                String name1 = request.getParameter("name");
                Double price1 = Double.valueOf(request.getParameter("price"));
                String description1 = request.getParameter("description");
                String producer1 = request.getParameter("producer");
                this.productService.save(id1, name1, price1, description1, producer1);
                response.sendRedirect("/list");
                break;
            case "search":
                String name2 = request.getParameter("search");
                List<Product> productList = this.productService.search(name2);
                request.setAttribute("products", productList);
                request.getRequestDispatcher("SearchProduct.jsp").forward(request, response);
                break;
            case "delete":
                Integer id2 = Integer.valueOf(request.getParameter("id"));
                this.productService.remove(id2);
                response.sendRedirect("/list");
                break;
        }
    }
}
