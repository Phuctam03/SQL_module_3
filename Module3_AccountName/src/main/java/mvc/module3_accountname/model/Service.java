package mvc.module3_accountname.model;

public class Service {
    private  int service_id;
    private  String  service_name;
    private  int service_area;
    private  double service_cost;
    private  int service_max_people;
    private  Rent_type rent_type_id;
    private  Service_Type service_type_id;
    private  String standard_room;
    private  String description_other_convenience;
    private  double pool_area;
    private  int number_of_floors;

    public Service(){}

    public Service(int service_id, String service_name, int service_area, double service_cost, int service_max_people, Rent_type rent_type_id, Service_Type service_type_id, String standard_room, String description_other_convenience, double pool_area, int number_of_floors) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
    }

    public int getService_id() {
        return service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public int getService_area() {
        return service_area;
    }

    public double getService_cost() {
        return service_cost;
    }

    public int getService_max_people() {
        return service_max_people;
    }

    public Rent_type getRent_type_id() {
        return rent_type_id;
    }

    public Service_Type getService_type_id() {
        return service_type_id;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public double getPool_area() {
        return pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }
}
