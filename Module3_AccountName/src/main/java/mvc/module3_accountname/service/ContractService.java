package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Contract;

import java.util.List;

public interface ContractService {
    void add(Contract contract);
    List<Contract> listAll();
}
