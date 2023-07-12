package web.repository;


import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDao {
    void save(User user);

    void updateUser(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);

}
