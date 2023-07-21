package mvc.module3_accountname.controller;

import mvc.module3_accountname.model.Rent_type;
import mvc.module3_accountname.model.Service_Type;
import mvc.module3_accountname.repository.Service_TypeRepository;
import mvc.module3_accountname.repository.Service_typeRepositoryImlp;
import mvc.module3_accountname.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "service", value = "/ServiceServlet")
public class ServiceServlet extends HttpServlet {
    private RentTypeService rentTypeService = new RentTypeServiceImlp();
    private ServiceTypeService serviceTypeService = new ServiceTypeServiceImlp();
    private Service service = new ServiceImlp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createFormService(req, resp);
                break;
            default:
                listService(req, resp);
                break;
        }

    }

    private void createFormService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rent_type> rent_types = rentTypeService.findAll();
        List<Service_Type> service_types = serviceTypeService.findAll();
        req.setAttribute("rent_type", rent_types);
        req.setAttribute("service_type", service_types);
        req.getRequestDispatcher("/view/service/create.jsp").forward(req, resp);

    }

    private void listService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<mvc.module3_accountname.model.Service> serviceList = service.findAll();
        req.setAttribute("service", serviceList);
        req.getRequestDispatcher("/view/service/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(req, resp);
                break;
            default:
                listService(req, resp);
                break;

        }

    }

    private void createService(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int service_area = Integer.parseInt(req.getParameter("service_area"));
        double cost = Double.parseDouble(req.getParameter("cost"));
        int service_max_people = Integer.parseInt(req.getParameter("people"));
        int rent_type_id = Integer.parseInt(req.getParameter("rent_type_id"));
        Rent_type rent_type = rentTypeService.findById(rent_type_id);
        int service_type_id = Integer.parseInt(req.getParameter("service_type_id"));
        Service_Type service_type = serviceTypeService.findById(service_type_id);
        String room = req.getParameter("room");
        String convenience = req.getParameter("convenience");
        double pool_area = Double.parseDouble(req.getParameter("pool_area"));
        int number_people = Integer.parseInt(req.getParameter("number_of_floors"));

        mvc.module3_accountname.model.Service service1
                = new mvc.module3_accountname.model.Service(id, name, service_area, cost, service_max_people, rent_type, service_type, room, convenience, pool_area, number_people);
        service.add(service1);
        resp.sendRedirect("/ServiceServlet");

    }
}
