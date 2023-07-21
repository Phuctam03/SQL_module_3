package mvc.module3_accountname.controller;


import mvc.module3_accountname.model.*;
import mvc.module3_accountname.service.*;

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

@WebServlet(name = "employee", value = "/employeeServlet")

public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceimlp();
    private PositionService positionService = new PositionServiceimlp();
    private DivisionService divisionService = new DivisionServiceImlp();
    private Education_degree_Service education_degree_service = new Education_degree_Serviceimlp();
    private UserService userService = new UseServiceImlp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "delete":
                deleteEmployee(req,resp);
                break;
            case "update":
                showFormUpdate(req, resp);
                break;
            default:
                listEmployee(req, resp);
                break;
        }
    }
    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeService.findbyId(id);
        List<Position> positions = positionService.findALL();
        List<Education_Degree> education_degrees = education_degree_service.findALL();
        List<Division> divisionList = divisionService.findALL();
        List<User> userList = userService.findAll();
        req.setAttribute("position", positions);
        req.setAttribute("education", education_degrees);
        req.setAttribute("division", divisionList);
        req.setAttribute("user", userList);
        req.setAttribute("employees",employee);
        req.getRequestDispatcher("/view/employee/update.jsp").forward(req,resp);
    }
    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Position> positions = positionService.findALL();
        List<Education_Degree> education_degrees = education_degree_service.findALL();
        List<Division> divisionList = divisionService.findALL();
        List<User> userList = userService.findAll();
        req.setAttribute("position", positions);
        req.setAttribute("education", education_degrees);
        req.setAttribute("division", divisionList);
        req.setAttribute("user", userList);
        req.getRequestDispatcher("/view/employee/create.jsp").forward(req, resp);
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAll();
        req.setAttribute("employeelist", employees);
        req.getRequestDispatcher("/view/employee/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertEmployee(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    updateEmployee(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Search":
                searchEmployee(req,resp);
                break;
            default:
                listEmployee(req, resp);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =req.getParameter("values").trim();
        Employee employee = employeeService.findByName(name);
        req.setAttribute("employees",employee);
        req.getRequestDispatcher("/view/employee/search.jsp").forward(req,resp);
    }
    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee =employeeService.findbyId(id);
        employeeService.delete(employee);
        resp.sendRedirect("/employeeServlet");
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String id_card = req.getParameter("id_card");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int positionId = Integer.parseInt(req.getParameter("positionId"));
        int education_id = Integer.parseInt(req.getParameter("educationId"));
        int division_id = Integer.parseInt(req.getParameter("divisionId"));
        String username = req.getParameter("username");
        Position position = positionService.findbyId(positionId);
        Education_Degree education_degree = education_degree_service.findById(education_id);
        Division division = divisionService.findByid(division_id);
        User user = userService.findbyName(username);
        Employee employee1 = employeeService.findbyId(id);
        Employee employee = new Employee(id,name,birthday,id_card,salary,phone,email,address,position,education_degree,division,user);
        employeeService.update(employee);
        req.setAttribute("message","update success");
        req.getRequestDispatcher("/view/employee/update.jsp").forward(req,resp);


    }

    private void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String date = req.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String id_card = req.getParameter("id_card");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int positionId = Integer.parseInt(req.getParameter("positionId"));
        int education_id = Integer.parseInt(req.getParameter("educationId"));
        int division_id = Integer.parseInt(req.getParameter("divisionId"));
        String username = req.getParameter("username");
        Position position = positionService.findbyId(positionId);
        Education_Degree education_degree = education_degree_service.findById(education_id);
        Division division = divisionService.findByid(division_id);
        User user = userService.findbyName(username);
        Employee employee = new Employee(id, name, birthday, id_card, salary, phone, email, address, position, education_degree, division, user);
        employeeService.add(employee);
        resp.sendRedirect("/employeeServlet");
    }
}
