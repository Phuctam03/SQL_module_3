package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Division;
import mvc.module3_accountname.model.Rent_type;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Rent_TypeRepositoryImlp implements  Rent_TypeRepository{
    @Override
    public Rent_type findById(int id) {
        Rent_type rent_type = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID_RENT_TYPE);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name  = resultSet.getString("rent_type_name");
                double cost = resultSet.getDouble("rent_type_cost");
                rent_type = new Rent_type(id,name,cost);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rent_type;
    }

    @Override
    public List<Rent_type> findAll() {
        List<Rent_type>  Rent_Type = new ArrayList<>();
        Rent_type rent_type = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constants.FIND_ALL_RENT_TYPE);
            while (resultSet.next()) {
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                double cost = resultSet.getDouble("rent_type_cost");
                rent_type = new Rent_type(id,name,cost);
                 Rent_Type.add(rent_type);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Rent_Type;

    }
}
