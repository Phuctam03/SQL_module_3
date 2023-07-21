package mvc.module3_accountname.service;

import mvc.module3_accountname.model.User;
import mvc.module3_accountname.repository.UserRepository;
import mvc.module3_accountname.repository.UserRepositoryImlp;

import java.util.List;

public class UseServiceImlp implements UserService{

    private UserRepository userRepository = new UserRepositoryImlp();
    @Override
    public User findbyName(String nameUser) {
        return userRepository.findbyName(nameUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User login(String users, String pass) {
        return  userRepository.login(users,pass);
    }
}
