package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Rent_type;

import java.util.List;

public interface Rent_TypeRepository {
      Rent_type findById(int id );
      List<Rent_type> findAll();

}
