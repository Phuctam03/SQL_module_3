package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Customer_type;
import mvc.module3_accountname.repository.Customer_TypeRepository;
import mvc.module3_accountname.repository.Customer_Type_RepositoryImlp;

import java.sql.SQLException;
import java.util.List;

public class Customer_TypeServiceImlp implements  Customer_TypeService{
    private Customer_TypeRepository customer_typeRepository =new Customer_Type_RepositoryImlp();
    @Override
    public Customer_type findById(int id) {
        return customer_typeRepository.findById(id);
    }

    @Override
    public List<Customer_type> findAll() throws SQLException, ClassNotFoundException {
        return customer_typeRepository.findAll();
    }
}
