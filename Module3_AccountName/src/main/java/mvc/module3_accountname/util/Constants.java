package mvc.module3_accountname.util;

public class Constants {
    public static final String FIND_ALL_POSITION = "Select * from position ";
    public static final String FIND_BY_ID_POSITION = "Select * from position where " +
            "position_id = ?";

    public static final String FIND_ALL_DIVISION = "Select * from division ";
    public static final String FIND_BY_ID_DIVISION = "Select * from division  where " +
            " division_id = ? ";

    public static final String FIND_ALL_EDUCATION_DEGREE = "Select * from education_degree";
    public static final String FIND_BY_ID_EDUCATION_DEGREE = "Select * from education_degree" +
            " where education_degree_id =  ?";

    public static final String FIND_ALL_USER = "Select * from user";
    public static final String FIND_BY_NAME_USER = "Select * from user where username = ? ";

    public static final String FIND_ALL_EMPLOYEE = "Select * from employee ";
    public static final String FIND_BY_ID_EMPLOYEE = "Select * from employee " +
            "where employee_id = ?  ";
    public static final String CREATE_EMPLOYEE = "insert into " +
            " employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username)" +
            " values(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE = "update employee set  employee_name = ? , employee_birthday = ?, employee_id_card = ? , employee_salary = ?," +
            " employee_phone = ? ,employee_email = ? , employee_address = ?, position_id = ? , education_degree_id = ? , division_id = ? ,username = ? where employee_id = ? ";
    public static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id = ? ";
    public static final String SEARCH_BY_NAME_EMPLOYEE = "Select * from employee where  employee_name = ? ";

    public static final String FIND_BY_ID_CUSTOMER_TYPE = "Select * from customer_type where customer_type_id = ? ";
    public static final String FIND_ALL_CUSTOMER_TYPE = "Select * from customer_type ";

    public static final String FIND_BY_ID_CUSTOMER = "Select * from customer where customer_id =  ? ";
    public static final String FIND_All_CUSTOMER = "Select * from customer ";
    public static final String CREATE_CUSTOMER = "insert into customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)" +
            " values(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ? ,customer_name = ?,customer_birthday = ? ,customer_gender = ? ,customer_id_card = ? , customer_phone = ? ,customer_email = ? , customer_address= ? " +
            " where customer_id = ? ";
    public static final String DELETE_CUSTOMER = "delete from customer where customer_id = ? ";
    public static final String SEARCH_BY_NAME_CUSTOMER = "Select * from customer where customer_name like ? ";

    public static final String FIND_BY_ID_RENT_TYPE = "Select * from rent_type where rent_type_id = ?";
    public static final String FIND_ALL_RENT_TYPE = "Select * from rent_type ";

    public static final String FIND_BY_ID_SERVICE_TYPE = "Select * from service_type where service_type_id = ? ";
    public static final String FIND_ALL_SERVICE_TYPE = "Select * from service_type ";

    public static final String FIND_BY_ID_SERVICE = "Select * from service where service_id = ?";
    public static final String FIND_All_SERVICE = "Select * from service";
    public static final String CREATE_SERVICE = "insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)" +
            " values(?,?,?,?,?,?,?,?,?,?,?)";

    public static final String CREATE_CONTRACT = "insert into contract(contract_id,contract_start_day,contract_end_day,contract_deposit,contract_total_money,employee_id,customer_id,service_id)" +
            " values (?,?,?,?,?,?,?,?)";
    public static final String FIND_ALL_CONTRACT = "Select * from contract";

    public static final String LOGIN = "select * from user where username = ? and\n" +
            " password = ?";
}
