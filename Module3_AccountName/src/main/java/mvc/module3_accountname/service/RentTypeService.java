package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Rent_type;

import java.util.List;

public interface RentTypeService {
    Rent_type findById(int id );
    List<Rent_type> findAll();
}
