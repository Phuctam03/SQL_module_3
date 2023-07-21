package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Contract;
import mvc.module3_accountname.repository.ContractRepository;
import mvc.module3_accountname.repository.ContractRepositoryImlp;

import java.util.List;

public class ContractServiceImlp implements  ContractService{
    private ContractRepository contractRepository = new ContractRepositoryImlp();
    @Override
    public void add(Contract contract) {
        contractRepository.add(contract);
    }

    @Override
    public List<Contract> listAll() {
        return contractRepository.listAll();
    }
}
