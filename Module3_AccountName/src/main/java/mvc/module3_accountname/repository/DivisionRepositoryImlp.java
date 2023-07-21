package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Division;
import mvc.module3_accountname.model.Education_Degree;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImlp implements  DivisionRepository{
    @Override
    public Division findByid(int id) {
        Division division = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID_DIVISION);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String division_name = resultSet.getString("division_name");
                division = new Division(id,division_name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return division;
    }

    @Override
    public List<Division> findALL() {
        List<Division>  divisionList = new ArrayList<>();
        Division division = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constants.FIND_ALL_DIVISION);
            while (resultSet.next()) {
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");
                division = new Division(id,name);
                divisionList.add(division);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divisionList;

    }
}
