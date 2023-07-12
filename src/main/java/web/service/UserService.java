package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void updateUser(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);
}
