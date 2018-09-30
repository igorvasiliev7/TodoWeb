package ua.com.mytodo.service.impl;

import ua.com.mytodo.dao.factory.DaoFactory;
import ua.com.mytodo.model.User;
import ua.com.mytodo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        DaoFactory.getUserDaoImpl().save(user);
    }

    @Override
    public List<User> findAll() {

        return DaoFactory.getUserDaoImpl().findAll();
    }

    @Override
    public void changeName(User user) {
    DaoFactory.getUserDaoImpl().changeName(user);
    }

    @Override
    public void delete(Long id) {
    DaoFactory.getUserDaoImpl().delete(id);
    }

    @Override
    public User findByEmail(String email) {
        return DaoFactory.getUserDaoImpl().findByEmail(email);
    }
}
