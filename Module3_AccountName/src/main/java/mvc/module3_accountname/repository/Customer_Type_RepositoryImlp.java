package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Customer_type;
import mvc.module3_accountname.model.Division;
import mvc.module3_accountname.model.Position;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer_Type_RepositoryImlp implements  Customer_TypeRepository{

    @Override
    public Customer_type findById(int id) {
        Customer_type customer_type  =null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =  connection.prepareStatement(Constants.FIND_BY_ID_CUSTOMER_TYPE);
                ){
             statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("customer_type_name");
                customer_type = new Customer_type(id,name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customer_type;
    }

    @Override
    public List<Customer_type> findAll() throws SQLException, ClassNotFoundException {
        List<Customer_type> customer_types = new ArrayList<>();
        Customer_type customer_type = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ){
            ResultSet resultSet = statement.executeQuery(Constants.FIND_ALL_CUSTOMER_TYPE);
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customer_type = new Customer_type(id,name);
                customer_types.add(customer_type);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customer_types;
    }
}
