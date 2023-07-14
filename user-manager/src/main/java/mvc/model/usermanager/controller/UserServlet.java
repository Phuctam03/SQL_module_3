package mvc.model.usermanager.controller;

import mvc.model.usermanager.model.User;
import mvc.model.usermanager.service.UserService;
import mvc.model.usermanager.service.UserServiceImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImlp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
            case "update":
                showFormUpdate(request,response);
                break;
            case "sort":
                sortByName(request,response);
            default:
                listUser(request,response);
                break;
        }

    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.sort_by_name();
        request.setAttribute("users",userList);
        request.getRequestDispatcher("/view/user/sort.jsp").forward(request,response);
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id  = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/view/user/update.jsp").forward(request,response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/view/user/delete.jsp").forward(request,response);

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/user/create.jsp");
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> user = userService.findALL();
        request.setAttribute("users",user);
        request.getRequestDispatcher("/view/user/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                insertUser(request,response);
                break;
            case "update":
                updateUser(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "Search":
                searchUser(request,response);
                break;
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("Search").trim();
        User user = userService.findByCountry(country);
        request.setAttribute("userManagement",user);
        request.getRequestDispatcher("/view/user/search.jsp").forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        userService.delete(user);
        response.sendRedirect("/UserServlet");
//        listUser(request,response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = userService.findById(id);
        User user1 = new User(id,name,email,country);
        userService.update(user1);
        request.setAttribute("message","update success");
        request.getRequestDispatcher("/view/user/update.jsp").forward(request,response);


    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userService.add(user);
        response.sendRedirect("/UserServlet");
    }
}
