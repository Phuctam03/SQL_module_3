package pratice.applicationproduct.controller;

import pratice.applicationproduct.model.Product;
import pratice.applicationproduct.service.ProductService;
import pratice.applicationproduct.service.ProductServiceImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/Products-Servlet")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImlp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                formCreateProduct(request,response);
                break;
            case "view":
                formView(request,response);
                break;
            case "delete":
                formDeleteProduct(request,response);
                break;
            case "update":
                formUpdateProduct(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }

    }

    private void formView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Product product =productService.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/product/view.jsp").forward(request,response);
    }

    private void formDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Product product =productService.findById(id);
        request.setAttribute("products",product);
        request.getRequestDispatcher("/product/delete.jsp").forward(request,response);
    }

    private void formUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("Product",product);
        request.getRequestDispatcher("/product/update.jsp").forward(request,response);

    }

    private void formCreateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/product/create.jsp");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product>  myProduct = productService.List();
        request.setAttribute("product",myProduct);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
             action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "update":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "Search":
                searchProduct(request,response);
                break;

        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("values").trim();
        Product product = productService.findByName(name);
        request.setAttribute("newProduct",product);
        request.getRequestDispatcher("/product/search.jsp").forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        productService.delete(id);
        response.sendRedirect("/Products-Servlet");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("name");
        double Price = Double.parseDouble(request.getParameter("price"));
        String describeProduct = request.getParameter("describeProduct");
        String manufacturers = request.getParameter("manufacturers");
        Product product = productService.findById(id);
        product.setNameProduct(nameProduct);
        product.setPrice(Price);
        product.setDescribeProduct(describeProduct);
        product.setManufacturers(manufacturers);
        request.setAttribute("Product",product);
        request.setAttribute("message","Product information was updated");
        request.getRequestDispatcher("/product/update.jsp").forward(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String describeProduct = request.getParameter("describeProduct");
        String manufacturers = request.getParameter("manufacturers");
        Product product = new Product(id,nameProduct,price,describeProduct,manufacturers);
        productService.add(product);
        response.sendRedirect("/Products-Servlet");
    }
}
