package mvc.module3_accountname.controller;

import mvc.module3_accountname.model.Contract;
import mvc.module3_accountname.model.Customer;
import mvc.module3_accountname.model.Employee;
import mvc.module3_accountname.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "contract", value = "/ContractServlet")
public class ContractServlet extends HttpServlet {

    private ContractService contractService = new ContractServiceImlp();
    private EmployeeService employeeService = new EmployeeServiceimlp();
    private CustomerService customerService = new CustomerServiceImlp();
    private Service service = new ServiceImlp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createFormContract(req, resp);
                break;
            default:
                listContract(req, resp);
                break;
        }

    }

    private void createFormContract(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAll();
        List<Customer> customers = customerService.findAll();
        List<mvc.module3_accountname.model.Service> services = service.findAll();
        req.setAttribute("employee", employees);
        req.setAttribute("customer", customers);
        req.setAttribute("service", services);
        req.getRequestDispatcher("/view/contract/create.jsp").forward(req, resp);
    }

    private void listContract(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contract> contractList = contractService.listAll();
        req.setAttribute("contracts", contractList);
        req.getRequestDispatcher("/view/contract/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertContract(req,resp);
                break;
            default:
                listContract(req, resp);
                break;
        }

    }

    private void insertContract(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String date1 = req.getParameter("date1");
        String date2 = req.getParameter("date2");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date start_date = null;
        try {
            start_date = format.parse(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date end_date = null;
        try {
            end_date= format.parse(date2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        double deposit = Double.parseDouble(req.getParameter("deposit"));
        double total = Double.parseDouble(req.getParameter("total"));
        int employee_id = Integer.parseInt(req.getParameter("employeeId"));
        int customer_id = Integer.parseInt(req.getParameter("customerId"));
        int service_id = Integer.parseInt(req.getParameter("serviceId"));
        Employee employee = employeeService.findbyId(employee_id);
        Customer customer = customerService.findById(customer_id);
        mvc.module3_accountname.model.Service service1 = service.findByid(service_id);
        Contract contract = new Contract(id,start_date,end_date,deposit,total,employee,customer,service1);
        contractService.add(contract);
        resp.sendRedirect("/ContractServlet");
    }
}
