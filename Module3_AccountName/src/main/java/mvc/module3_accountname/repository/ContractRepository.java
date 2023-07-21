package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Contract;

import java.util.List;

public interface ContractRepository {
    void add(Contract contract);
    List<Contract> listAll();

}
