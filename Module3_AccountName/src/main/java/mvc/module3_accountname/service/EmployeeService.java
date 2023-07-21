package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Employee;

import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    void delete(Employee employee);
    Employee findbyId(int id );
    void update(Employee employee);
    Employee findByName(String name);
    List<Employee> findAll();
}
