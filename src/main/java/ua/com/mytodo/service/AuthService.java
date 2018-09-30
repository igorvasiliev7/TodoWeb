package ua.com.mytodo.service;

import ua.com.mytodo.model.User;

public interface AuthService {

    User login(String email, String password);
}
