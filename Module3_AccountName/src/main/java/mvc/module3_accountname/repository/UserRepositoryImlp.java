package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.User;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImlp implements UserRepository {
    @Override
    public User findbyName(String nameUser) {
        User user = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_NAME_USER);
        ) {
            statement.setString(1,nameUser);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String password = resultSet.getString("password");
                user = new User(nameUser,password);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        User user =  null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement =  connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constants.FIND_ALL_USER);
           while (resultSet.next()){
               String username = resultSet.getString("username");
               String password = resultSet.getString("password");
               user = new User(username,password);
               userList.add(user);
           }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;


    }

    @Override
    public User login(String users, String pass) {
        User user = null;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.LOGIN);
        ) {
            statement.setString(1,users);
            statement.setString(2,pass);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String user1 = resultSet.getString("username");
                String password = resultSet.getString("password");
                user = new User(user1,password);
                return user;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
