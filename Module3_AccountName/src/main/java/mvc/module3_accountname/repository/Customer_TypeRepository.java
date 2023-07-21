package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Customer_type;

import java.sql.SQLException;
import java.util.List;

public interface Customer_TypeRepository {

    Customer_type findById(int id );

    List<Customer_type> findAll() throws SQLException, ClassNotFoundException;


}
