package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Service;

import java.util.List;

public interface ServiceRepository {
    void add(Service service);
    List<Service> findAll();

    Service findById(int id );

}
