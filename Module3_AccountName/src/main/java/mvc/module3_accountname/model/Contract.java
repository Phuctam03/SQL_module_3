package mvc.module3_accountname.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract {
    private int contract_id;
    private Date contract_start_day;
    private Date contract_end_day;
    private double contract_deposit;
    private double contract_total_money;
    private Employee employee_id;
    private Customer customer_id;
    private Service service_id;


    public Contract() {
    }

    public Contract(int contract_id, Date contract_start_day, Date contract_end_day, double contract_deposit, double contract_total_money, Employee employee_id, Customer customer_id, Service service_id) {
        this.contract_id = contract_id;
        this.contract_start_day = contract_start_day;
        this.contract_end_day = contract_end_day;
        this.contract_deposit = contract_deposit;
        this.contract_total_money = contract_total_money;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public Date getContract_start_day() {
        return contract_start_day;
    }

    public void setContract_start_day(Date contract_start_day) {
        this.contract_start_day = contract_start_day;
    }

    public Date getContract_end_day() {
        return contract_end_day;
    }

    public void setContract_end_day(Date contract_end_day) {
        this.contract_end_day = contract_end_day;
    }

    public double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public double getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(double contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Service getService_id() {
        return service_id;
    }

    public void setService_id(Service service_id) {
        this.service_id = service_id;
    }


    public String getStartDateFormat() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.contract_start_day);
    }
    public String getEndDateFormat() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.contract_end_day);
    }
}
