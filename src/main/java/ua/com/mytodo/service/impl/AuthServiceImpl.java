package ua.com.mytodo.service.impl;

import ua.com.mytodo.model.User;
import ua.com.mytodo.service.AuthService;
import ua.com.mytodo.service.UserService;
import ua.com.mytodo.service.factory.ServiceFactory;

public class AuthServiceImpl implements AuthService {

    @Override
    public User login(String email, String password) {
        UserService userService = ServiceFactory.userServiceImpl();
        final User user = userService.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
