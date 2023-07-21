package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.Education_Degree;

import java.util.List;

public interface Education_degree_Repository {
    Education_Degree findById(int id);
    List<Education_Degree> findALL();
}
