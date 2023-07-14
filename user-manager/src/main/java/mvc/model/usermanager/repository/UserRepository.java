package mvc.model.usermanager.repository;

import mvc.model.usermanager.model.User;

import java.util.List;

public interface UserRepository {
    void add(User user);
    void delete(User user);
    User findbyId(int id );
    User findbyCountry(String country);
    void update(User user);
    List<User> findAll();
    List<User> Sort();
}
