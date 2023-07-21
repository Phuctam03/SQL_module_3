package mvc.module3_accountname.service;

import java.util.List;

public interface Service {
    void add(mvc.module3_accountname.model.Service service);
    List<mvc.module3_accountname.model.Service> findAll();

    mvc.module3_accountname.model.Service findByid(int id );
}
