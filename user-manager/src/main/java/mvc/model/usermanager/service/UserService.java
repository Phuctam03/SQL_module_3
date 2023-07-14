package mvc.model.usermanager.service;

import mvc.model.usermanager.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete (User user);
    User findById(int id );
    void update (User user);
    List<User> findALL();
    List<User> sort_by_name();
    User findByCountry(String country);
}
