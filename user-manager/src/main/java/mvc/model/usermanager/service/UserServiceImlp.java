package mvc.model.usermanager.service;

import mvc.model.usermanager.model.User;
import mvc.model.usermanager.repository.UserRepository;
import mvc.model.usermanager.repository.UserRepositoryImlp;

import java.util.List;

public class UserServiceImlp implements  UserService{
    private UserRepository userRepository = new UserRepositoryImlp();

    @Override
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
    @Override
    public User findById(int id) {
        return userRepository.findbyId(id);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);

    }

    @Override
    public List<User> findALL() {
        return userRepository.findAll();
    }

    @Override
    public List<User> sort_by_name() {

        return userRepository.Sort();
    }

    @Override
    public User findByCountry(String country) {

        return  userRepository.findbyCountry(country);
    }
}
