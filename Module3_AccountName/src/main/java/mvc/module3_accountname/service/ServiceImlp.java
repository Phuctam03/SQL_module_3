package mvc.module3_accountname.service;

import mvc.module3_accountname.repository.ServiceRepository;
import mvc.module3_accountname.repository.ServiceRepositoryImlp;

import java.util.List;

public class ServiceImlp implements Service{
    private ServiceRepository serviceRepository = new ServiceRepositoryImlp();
    @Override
    public void add(mvc.module3_accountname.model.Service service) {
        serviceRepository.add(service);

    }

    @Override
    public List<mvc.module3_accountname.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public mvc.module3_accountname.model.Service findByid(int id) {
        return serviceRepository.findById(id);
    }
}
