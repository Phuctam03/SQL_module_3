package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Division;

import java.util.List;

public interface DivisionService {
    Division findByid(int id );
    List<Division> findALL();
}
