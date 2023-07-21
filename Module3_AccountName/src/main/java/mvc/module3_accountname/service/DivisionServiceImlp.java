package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Division;
import mvc.module3_accountname.repository.DivisionRepository;
import mvc.module3_accountname.repository.DivisionRepositoryImlp;

import java.util.List;

public class DivisionServiceImlp implements  DivisionService{

    private DivisionRepository divisionRepository = new DivisionRepositoryImlp();
    @Override
    public Division findByid(int id) {
        return  divisionRepository.findByid(id);
    }
    @Override
    public List<Division> findALL() {
        return  divisionRepository.findALL();
    }
}
