package mvc.module3_accountname.repository;

import mvc.module3_accountname.model.User;

import java.util.List;

public interface UserRepository {
    User findbyName(String nameUser);
    List<User>  findAll();

    User login(String users,String pass);

}
