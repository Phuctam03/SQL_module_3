package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Education_Degree;
import mvc.module3_accountname.model.Position;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Education_Degree_RepositoryImlp  implements  Education_degree_Repository{
    @Override
    public Education_Degree findById(int id) {
         Education_Degree education_degree = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID_EDUCATION_DEGREE);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String education_degree_name = resultSet.getString("education_degree_name");
                education_degree = new Education_Degree(id,education_degree_name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return education_degree;
    }

    @Override
    public List<Education_Degree> findALL() {
        List<Education_Degree> education_degrees = new ArrayList<>();
        Education_Degree education_degree = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constants.FIND_ALL_EDUCATION_DEGREE);
            while (resultSet.next()) {
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                education_degree = new Education_Degree(id,name);
                education_degrees.add(education_degree);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return education_degrees;

    }
}
