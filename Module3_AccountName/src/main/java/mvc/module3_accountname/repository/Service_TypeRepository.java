package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Service_Type;

import java.util.List;

public interface Service_TypeRepository {
    Service_Type findById(int id );
    List<Service_Type> findAll();
}
