package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Customer_type;

import java.sql.SQLException;
import java.util.List;

public interface Customer_TypeService {
    Customer_type findById(int id );

    List<Customer_type> findAll() throws SQLException, ClassNotFoundException;
}
