import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discountPercent = Float.parseFloat(request.getParameter("discount"));

        float discount = price * discountPercent / 100;
        float money = price - discount;


        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product: " + description + "</h1>");
        writer.println("<h1>Price: " + price + "</h1>");
        writer.println("<h1>Discount Percent: " + discountPercent + "%" + "</h1>");
        writer.println("<h1>Price Discount: " + discount + "</h1>");
        writer.println("<h1>Price after discount: " + money + "</h1>");
        writer.println("</html>");
    }
}
