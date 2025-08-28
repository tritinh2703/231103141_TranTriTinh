package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = userDao.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}