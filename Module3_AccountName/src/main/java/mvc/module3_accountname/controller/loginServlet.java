package mvc.module3_accountname.controller;

import mvc.module3_accountname.model.User;
import mvc.module3_accountname.service.UseServiceImlp;
import mvc.module3_accountname.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    private UserService userService = new UseServiceImlp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        User user = userService.login(username,password);
        if( user == null){
            request.setAttribute("message","Wrong user or password");
            request.getRequestDispatcher("/view/login/login.jsp").forward(request,response);
        }else {
            response.sendRedirect("/view/home/home.jsp");
        }
    }
}
