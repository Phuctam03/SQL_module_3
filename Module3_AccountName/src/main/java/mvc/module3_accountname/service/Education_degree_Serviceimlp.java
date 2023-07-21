package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Education_Degree;
import mvc.module3_accountname.repository.Education_Degree_RepositoryImlp;
import mvc.module3_accountname.repository.Education_degree_Repository;

import java.util.List;

public class Education_degree_Serviceimlp implements  Education_degree_Service{
    private Education_degree_Repository education_degree_repository = new Education_Degree_RepositoryImlp();
    @Override
    public Education_Degree findById(int id) {
        return education_degree_repository.findById(id);
    }

    @Override
    public List<Education_Degree> findALL() {
        return education_degree_repository.findALL();
    }
}
