package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Service_Type;
import mvc.module3_accountname.repository.Service_TypeRepository;
import mvc.module3_accountname.repository.Service_typeRepositoryImlp;

import java.util.List;

public class ServiceTypeServiceImlp implements  ServiceTypeService{
    private Service_TypeRepository service_typeRepository = new Service_typeRepositoryImlp();
    @Override
    public Service_Type findById(int id) {
        return  service_typeRepository.findById(id);
    }

    @Override
    public List<Service_Type> findAll() {
        return service_typeRepository.findAll();
    }
}
