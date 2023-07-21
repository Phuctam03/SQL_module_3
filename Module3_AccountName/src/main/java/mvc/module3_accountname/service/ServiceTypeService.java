package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Service_Type;

import java.util.List;

public interface ServiceTypeService {
    Service_Type findById(int id );
    List<Service_Type> findAll();
}
