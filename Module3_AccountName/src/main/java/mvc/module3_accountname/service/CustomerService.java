package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Customer;
import mvc.module3_accountname.model.Customer_type;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    void add(Customer customer);
    void delete(Customer customer);
    Customer findById(int id );
    void update(Customer customer);
    List<Customer> findAll();
    List<Customer> findByName(String nameCustomer);
}
