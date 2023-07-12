package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserDao;

import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
@Component
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;

    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
    userDao.updateUser(user);
    }

    @Override
    public void removeUserById(Long id) {
        userDao.removeUserById(id);

    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}


