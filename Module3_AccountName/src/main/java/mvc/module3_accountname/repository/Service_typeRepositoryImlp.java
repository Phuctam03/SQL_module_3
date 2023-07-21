package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Rent_type;
import mvc.module3_accountname.model.Service;
import mvc.module3_accountname.model.Service_Type;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service_typeRepositoryImlp implements  Service_TypeRepository{
    @Override
    public Service_Type findById(int id) {
        Service_Type service_type = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID_SERVICE_TYPE);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name  = resultSet.getString("service_type_name");
                service_type = new Service_Type(id,name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return service_type;
    }

    @Override
    public List<Service_Type> findAll() {
        List<Service_Type>  service_types = new ArrayList<>();
        Service_Type service_type = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constants.FIND_ALL_SERVICE_TYPE);
            while (resultSet.next()) {
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                service_type = new Service_Type(id,name);
                service_types.add(service_type);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return service_types;
    }
}
