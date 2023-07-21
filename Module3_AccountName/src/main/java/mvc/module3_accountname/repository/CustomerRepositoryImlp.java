package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.*;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImlp implements  CustomerRepository{
    private  Customer_TypeRepository customer_typeRepository = new Customer_Type_RepositoryImlp();
    @Override
    public void add(Customer customer) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.CREATE_CUSTOMER);) {
            statement.setInt(1,customer.getCustomer_id());
            statement.setInt(2,customer.getCustomer_type_id().getCustomer_type_id());
            statement.setString(3,customer.getCustomer_name());
            statement.setDate(4,new Date(customer.getCustomer_birthday().getTime()));
            statement.setBoolean(5,customer.getCustomer_gender());
            statement.setString(6,customer.getCustomer_id_card());
            statement.setString(7,customer.getCustomer_phone());
            statement.setString(8,customer.getCustomer_email());
            statement.setString(9,customer.getCustomer_address());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Customer customer) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.DELETE_CUSTOMER);) {
            statement.setInt(1,customer.getCustomer_id());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID_CUSTOMER);) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_type_id = resultSet.getInt("customer_type_id");
                Customer_type customer_type = customer_typeRepository.findById(customer_type_id);
                String name = resultSet.getString("customer_name");
                java.util.Date birth_day = new java.util.Date(resultSet.getDate("customer_birthday").getTime());
                Boolean gender = resultSet.getBoolean("customer_gender");
                String id_card = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email =  resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id,customer_type,name,birth_day,gender,id_card,phone,email,address);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  customer;
    }

    @Override
    public void update(Customer customer) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_CUSTOMER);) {
            statement.setInt(9,customer.getCustomer_id());
            statement.setInt(1,customer.getCustomer_type_id().getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setDate(3,new Date(customer.getCustomer_birthday().getTime()));
            statement.setBoolean(4,customer.getCustomer_gender());
            statement.setString(5,customer.getCustomer_id_card());
            statement.setString(6,customer.getCustomer_phone());
            statement.setString(7,customer.getCustomer_email());
            statement.setString(8,customer.getCustomer_address());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer  = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.FIND_All_CUSTOMER);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int customer_type = resultSet.getInt("customer_type_id");
                Customer_type customer_type1 = customer_typeRepository.findById(customer_type);
                String name = resultSet.getString("customer_name");
                java.util.Date birthday = new java.util.Date(resultSet.getDate("customer_birthday").getTime());
                Boolean gender = resultSet.getBoolean("customer_gender");
                String id_card = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String  address = resultSet.getString("customer_address");
                customer = new Customer(id,customer_type1,name,birthday,gender,id_card,phone,email,address);
                customerList.add(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return customerList;

    }

    @Override
    public List<Customer> findByName(String nameCustomer) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.SEARCH_BY_NAME_CUSTOMER);) {
            statement.setString(1,nameCustomer + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                Customer_type customer_type = customer_typeRepository.findById(customer_type_id);
                java.util.Date birth_day = new java.util.Date(resultSet.getDate("customer_birthday").getTime());
                Boolean gender = resultSet.getBoolean("customer_gender");
                String id_card = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email =  resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id,customer_type,name,birth_day,gender,id_card,phone,email,address);
                customerList.add(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  customerList;

    }
}
