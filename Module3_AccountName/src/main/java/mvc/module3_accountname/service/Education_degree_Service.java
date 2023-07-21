package mvc.module3_accountname.service;

import mvc.module3_accountname.model.Education_Degree;

import java.util.List;

public interface Education_degree_Service {
    Education_Degree findById(int id);
    List<Education_Degree> findALL();
}
