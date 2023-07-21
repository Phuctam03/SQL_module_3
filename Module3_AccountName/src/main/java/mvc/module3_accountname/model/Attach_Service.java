package mvc.module3_accountname.model;

public class Attach_Service {
    private int attach_service;
    private String attach_service_name;
    private Double attach_service_cost;
    private int attach_service_unit;
    private String attach_service_status;


    public Attach_Service() {
    }

    public Attach_Service(int attach_service, String attach_service_name, Double attach_service_cost, int attach_service_unit, String attach_service_status) {
        this.attach_service = attach_service;
        this.attach_service_name = attach_service_name;
        this.attach_service_cost = attach_service_cost;
        this.attach_service_unit = attach_service_unit;
        this.attach_service_status = attach_service_status;
    }

    public int getAttach_service() {
        return attach_service;
    }

    public void setAttach_service(int attach_service) {
        this.attach_service = attach_service;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }

    public Double getAttach_service_cost() {
        return attach_service_cost;
    }

    public void setAttach_service_cost(Double attach_service_cost) {
        this.attach_service_cost = attach_service_cost;
    }

    public int getAttach_service_unit() {
        return attach_service_unit;
    }

    public void setAttach_service_unit(int attach_service_unit) {
        this.attach_service_unit = attach_service_unit;
    }

    public String getAttach_service_status() {
        return attach_service_status;
    }

    public void setAttach_service_status(String attach_service_status) {
        this.attach_service_status = attach_service_status;
    }
}
