import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/Discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String Product_description  = request.getParameter("Product");
         double List_Price = Double.parseDouble(request.getParameter("Price"));
         double Discount_Percent = Double.parseDouble(request.getParameter("Percent"));

         double Discount_Amount = List_Price * Discount_Percent * 0.01;
         double Discount_Price = List_Price - Discount_Amount;

         request.setAttribute("description",Product_description);
         request.setAttribute("Price",List_Price);
         request.setAttribute("Percent",Discount_Percent);
         request.setAttribute("Discount",Discount_Amount);
         request.setAttribute("Discount_Price",Discount_Price);
         request.getRequestDispatcher("Discount.jsp").forward(request,response);



    }
}
