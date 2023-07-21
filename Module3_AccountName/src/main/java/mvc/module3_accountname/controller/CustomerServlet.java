package mvc.module3_accountname.controller;

import mvc.module3_accountname.model.Customer;
import mvc.module3_accountname.model.Customer_type;
import mvc.module3_accountname.service.CustomerService;
import mvc.module3_accountname.service.CustomerServiceImlp;
import mvc.module3_accountname.service.Customer_TypeService;
import mvc.module3_accountname.service.Customer_TypeServiceImlp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Customer", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private Customer_TypeService customer_typeService = new Customer_TypeServiceImlp();
    private CustomerService customerService = new CustomerServiceImlp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createFormCustomer(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                deleteCustomer(req, resp);
                break;
            case "update":
                try {
                    updateFormCustomer(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                listCustomer(req, resp);
                break;

        }

    }

    private void updateFormCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        List<Customer_type> customer_types = customer_typeService.findAll();
        req.setAttribute("customers", customer);
        req.setAttribute("customer_types", customer_types);
        req.getRequestDispatcher("/view/customer/update.jsp").forward(req, resp);
    }

    private void createFormCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Customer_type> customer_types = customer_typeService.findAll();
        req.setAttribute("customer_type", customer_types);
        req.getRequestDispatcher("/view/customer/create.jsp").forward(req, resp);
    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        req.setAttribute("CustomerList", customers);
        req.getRequestDispatcher("/view/customer/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(req, resp);
                break;
            case "update":
                updateCustomer(req, resp);
                break;
            case "search":
                searchCustomer(req, resp);
                break;
            default:
                listCustomer(req, resp);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("values").trim();
        List<Customer> customer = customerService.findByName(name);
        req.setAttribute("CustomerList", customer);
        req.getRequestDispatcher("/view/customer/list.jsp").forward(req, resp);
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        customerService.delete(customer);
        resp.sendRedirect("/CustomerServlet");
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        int customer_type_id = Integer.parseInt(req.getParameter("customerTypeId"));
        Customer_type customer_type = customer_typeService.findById(customer_type_id);
        String name = req.getParameter("name");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String checkergender = req.getParameter("gender");
        boolean gender = true;
        if (checkergender.equals("Female")) {
            gender = false;
        }
        String id_card = req.getParameter("IdCard");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer1 = new Customer(id, customer_type, name, birthday, gender, id_card, phone, email, address);
        customerService.update(customer1);
        req.setAttribute("message", "update Success");
        req.getRequestDispatcher("/view/customer/update.jsp").forward(req, resp);

    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int customer_type_id = Integer.parseInt(req.getParameter("customerTypeId"));
        Customer_type customer_type = customer_typeService.findById(customer_type_id);
        String name = req.getParameter("name");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date birthday = null;
        try {
            birthday = format.parse(date);
        } catch (ParseException e) {
            throw  new RuntimeException();
        }
        String checkergender = req.getParameter("gender");
        boolean gender = true;
        if (checkergender.equals("female")) {
            gender = false;
        }
        String id_card = req.getParameter("IdCard");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = new Customer(id, customer_type, name, birthday, gender, id_card, phone, email, address);
        customerService.add(customer);
        resp.sendRedirect("/CustomerServlet");


    }
}

