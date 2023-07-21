package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Customer;
import mvc.module3_accountname.repository.CustomerRepository;
import mvc.module3_accountname.repository.CustomerRepositoryImlp;
import mvc.module3_accountname.repository.Customer_TypeRepository;

import java.util.List;

public class CustomerServiceImlp implements  CustomerService{
    private CustomerRepository customerRepository = new CustomerRepositoryImlp();
    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);

    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByName(String nameCustomer) {
        return customerRepository.findByName(nameCustomer);
    }
}
