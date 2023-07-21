package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Rent_type;
import mvc.module3_accountname.repository.Rent_TypeRepository;
import mvc.module3_accountname.repository.Rent_TypeRepositoryImlp;

import java.util.List;

public class RentTypeServiceImlp implements  RentTypeService{
    private Rent_TypeRepository rent_typeRepository = new Rent_TypeRepositoryImlp();

    @Override
    public Rent_type findById(int id) {
        return  rent_typeRepository.findById(id);
    }

    @Override
    public List<Rent_type> findAll() {
        return rent_typeRepository.findAll();
    }
}
