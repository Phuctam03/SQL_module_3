package mvc.module3_accountname.service;

import mvc.module3_accountname.model.User;

import java.util.List;

public interface UserService {
    User findbyName(String nameUser);
    List<User> findAll();
    User login(String users,String pass);

}
