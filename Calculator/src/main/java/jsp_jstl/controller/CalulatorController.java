package jsp_jstl.controller;

import jsp_jstl.model.Calculater;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "CalulatorController", value = "/Calulator-Controller")
public class CalulatorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperator = Float.parseFloat(request.getParameter("FirstOperand"));
        float SecondOperator = Float.parseFloat(request.getParameter("SecondOperand"));
        char operator = request.getParameter("operator").charAt(0);
        try {
            float result = Calculater.calculate(firstOperator, SecondOperator, operator);
            request.setAttribute("firstOperator", firstOperator);
            request.setAttribute("SecondOperator", SecondOperator);
            request.setAttribute("operator", operator);
            request.setAttribute("Result", result);
            request.getRequestDispatcher("/Calculator_jstl.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("Invalid",ex.getMessage());
            request.getRequestDispatcher("/Calculator_jstl.jsp").forward(request,response);
        }
    }
}
