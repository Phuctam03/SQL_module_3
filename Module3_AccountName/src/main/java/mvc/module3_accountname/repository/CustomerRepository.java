package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Customer;

import java.util.List;

public interface CustomerRepository {

    void add(Customer customer);
    void delete(Customer customer);
    Customer findById(int id );
    void update(Customer customer);
    List<Customer> findAll();
    List<Customer> findByName(String nameCustomer);

}
