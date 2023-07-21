package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.*;
import mvc.module3_accountname.util.Constants;
import mvc.module3_accountname.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImlp implements ContractRepository {
    private  EmployeeRepository employeeRepository = new EmployeeRepositoryImlp();
    private  CustomerRepository customerRepository = new CustomerRepositoryImlp();
    private  ServiceRepository serviceRepository = new ServiceRepositoryImlp();
    @Override
    public void add(Contract contract) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.CREATE_CONTRACT);) {
            statement.setInt(1, contract.getContract_id());
            statement.setDate(2, new Date(contract.getContract_start_day().getTime()));
            statement.setDate(3, new Date(contract.getContract_end_day().getTime()));
            statement.setDouble(4, contract.getContract_deposit());
            statement.setDouble(5, contract.getContract_total_money());
            statement.setInt(6, contract.getEmployee_id().getEmployee_id());
            statement.setInt(7, contract.getCustomer_id().getCustomer_id());
            statement.setInt(8, contract.getService_id().getService_id());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Contract> listAll() {
        List<Contract> contractList = new ArrayList<>();
        Contract contract = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_CONTRACT);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                java.util.Date start_date = new java.util.Date(resultSet.getDate("contract_start_day").getTime());
                java.util.Date end_date = new java.util.Date(resultSet.getDate("contract_end_day").getTime());
                double deposit = resultSet.getDouble("contract_deposit");
                double total_money = resultSet.getDouble("contract_total_money");
                int employee_Id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");
                Employee employee = employeeRepository.findbyId(employee_Id);
                Customer customer = customerRepository.findById(customer_id);
                Service service = serviceRepository.findById(service_id);
                contract = new Contract(id,start_date,end_date,deposit,total_money,employee,customer,service);
                contractList.add(contract);


            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return contractList;
    }
}
