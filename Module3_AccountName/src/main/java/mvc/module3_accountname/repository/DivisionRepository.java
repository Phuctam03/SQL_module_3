package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Division;

import java.util.List;

public interface DivisionRepository {
    Division findByid(int id );
    List<Division> findALL();

}
