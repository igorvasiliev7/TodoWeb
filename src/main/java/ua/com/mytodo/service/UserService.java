package ua.com.mytodo.service;

import ua.com.mytodo.model.User;

public interface UserService extends CrudService<User, Long> {

    User findByEmail(String email);
}
