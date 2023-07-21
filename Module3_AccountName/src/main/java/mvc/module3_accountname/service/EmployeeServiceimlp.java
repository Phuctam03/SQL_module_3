package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Employee;
import mvc.module3_accountname.repository.EmployeeRepository;
import mvc.module3_accountname.repository.EmployeeRepositoryImlp;

import java.util.List;

public class EmployeeServiceimlp implements  EmployeeService{

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImlp();
    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Employee findbyId(int id) {
        return  employeeRepository.findbyId(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
