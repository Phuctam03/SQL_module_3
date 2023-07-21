package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.*;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImlp implements  ServiceRepository{

    private  Rent_TypeRepository rent_typeRepository = new Rent_TypeRepositoryImlp();
    private Service_TypeRepository service_type = new Service_typeRepositoryImlp();
    @Override
    public void add(Service service) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.CREATE_SERVICE);) {
            statement.setInt(1,service.getService_id());
            statement.setString(2,service.getService_name());
            statement.setInt(3, service.getService_area());
            statement.setDouble(4,service.getService_cost());
            statement.setInt(5,service.getService_max_people());
            statement.setInt(6,service.getRent_type_id().getRent_type_id());
            statement.setInt(7,service.getService_type_id().getService_type_id());
            statement.setString(8,service.getStandard_room());
            statement.setString(9,service.getDescription_other_convenience());
            statement.setInt(10,service.getService_area());
            statement.setInt(11,service.getNumber_of_floors());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        Service service = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.FIND_All_SERVICE);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                Rent_type rent_type = rent_typeRepository.findById(rent_type_id);
                int service_type_id = resultSet.getInt("service_type_id");
                Service_Type serviceType = service_type.findById(service_type_id);
                String standard_room = resultSet.getString("standard_room");
                String convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_floors = resultSet.getInt("number_of_floors");
                service = new Service(id,name,area,cost,max_people,rent_type,serviceType,standard_room,convenience,pool_area,number_floors);
                serviceList.add(service);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return serviceList;
    }

    @Override
    public Service findById(int id) {
        Service service = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID_SERVICE);) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                Rent_type rent_type =  rent_typeRepository.findById(rent_type_id);
                int  service_type_id = resultSet.getInt("service_type_id");
                Service_Type serviceType = service_type.findById(service_type_id);
                String room = resultSet.getString("standard_room");
                String convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                service = new Service(id,name,area,cost,max_people,rent_type,serviceType,room,convenience,pool_area,number_of_floors);

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  service;
    }
}
