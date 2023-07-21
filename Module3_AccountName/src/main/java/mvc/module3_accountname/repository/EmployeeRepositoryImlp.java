package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.*;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImlp implements  EmployeeRepository{
    private  PositionRepository positionRepository = new PositionRepositoryImlp();
    private  Education_degree_Repository education_degree_repository = new Education_Degree_RepositoryImlp();
    private  DivisionRepository divisionRepository = new DivisionRepositoryImlp();
    private  UserRepository  userRepository = new UserRepositoryImlp();
    @Override
    public void add(Employee employee) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.CREATE_EMPLOYEE);) {
            statement.setInt(1,employee.getEmployee_id());
            statement.setString(2,employee.getEmployee_name());
            statement.setString(3, String.valueOf(new Date(employee.getEmployee_birthday().getTime())));
            statement.setString(4,employee.getEmployee_id_card());
            statement.setDouble(5,employee.getEmployee_salary());
            statement.setString(6,employee.getEmployee_phone());
            statement.setString(7,employee.getEmployee_email());
            statement.setString(8,employee.getEmployee_address());
            statement.setInt(9,employee.getPosition_id().getPosition_id());
            statement.setInt(10,employee.getEducation_degree_id().getEducation_degree_id());
            statement.setInt(11,employee.getDivision_id().getDivision_id());
            statement.setString(12,employee.getUsername().getUsername());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(Employee employee) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE_BY_ID);) {
            statement.setInt(1,employee.getEmployee_id());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findbyId(int id) {
        Employee employee = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.FIND_BY_ID_EMPLOYEE);) {

            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                java.util.Date birth_day = new java.util.Date(resultSet.getDate("employee_birthday").getTime());
                String id_card = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email =  resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int Division1 = resultSet.getInt("division_id");
                String user_name = resultSet.getString("username");
                Position position = positionRepository.findbyId(position_id);
                Education_Degree education_degree = education_degree_repository.findById(education_degree_id);
                Division division = divisionRepository.findByid(Division1);
                User user = userRepository.findbyName(user_name);
                employee = new Employee(id,name,birth_day,id_card,salary,phone,email,address,position,education_degree,division,user);


            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  employee;
    }

    @Override
    public void update(Employee employee) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE);) {

            statement.setInt(12,employee.getEmployee_id());
            statement.setString(1,employee.getEmployee_name());
            statement.setString(2, String.valueOf(new Date(employee.getEmployee_birthday().getTime())));
            statement.setString(3,employee.getEmployee_id_card());
            statement.setDouble(4,employee.getEmployee_salary());
            statement.setString(5,employee.getEmployee_phone());
            statement.setString(6,employee.getEmployee_email());
            statement.setString(7,employee.getEmployee_address());
            statement.setInt(8,employee.getPosition_id().getPosition_id());
            statement.setInt(9,employee.getEducation_degree_id().getEducation_degree_id());
            statement.setInt(10,employee.getDivision_id().getDivision_id());
            statement.setString(11,employee.getUsername().getUsername());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findByName(String name) {
        Employee employee = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.SEARCH_BY_NAME_EMPLOYEE);) {

            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                java.util.Date birth_day = new java.util.Date(resultSet.getDate("employee_birthday").getTime());
                String id_card = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email =  resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int Division1 = resultSet.getInt("division_id");
                String user_name = resultSet.getString("username");
                Position position = positionRepository.findbyId(position_id);
                Education_Degree education_degree = education_degree_repository.findById(education_degree_id);
                Division division = divisionRepository.findByid(Division1);
                User user = userRepository.findbyName(user_name);
                employee = new Employee(id,name,birth_day,id_card,salary,phone,email,address,position,education_degree,division,user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_EMPLOYEE);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                java.util.Date birthday = new java.util.Date(resultSet.getDate("employee_birthday").getTime());
                String id_card = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String  employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int Division1 = resultSet.getInt("division_id");
                String user_name = resultSet.getString("username");
                Position position = positionRepository.findbyId(position_id);
                Education_Degree education_degree = education_degree_repository.findById(education_degree_id);
                Division division = divisionRepository.findByid(Division1);
                User user = userRepository.findbyName(user_name);
                employee = new Employee(id,name,birthday,id_card,salary,employee_phone,employee_email,employee_address,position,education_degree,division,user);
                employeeList.add(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return employeeList;
    }
}
