package ua.com.mytodo.service.factory;

import ua.com.mytodo.service.AuthService;
import ua.com.mytodo.service.TodoService;
import ua.com.mytodo.service.UserService;
import ua.com.mytodo.service.impl.AuthServiceImpl;
import ua.com.mytodo.service.impl.TodoServiceImpl;
import ua.com.mytodo.service.impl.UserServiceImpl;

public class ServiceFactory {

    public static TodoService todoServiceImpl(){
        return new TodoServiceImpl();
    }
    public static UserService userServiceImpl(){
        return new UserServiceImpl();
    }
    public static AuthService authServiceImpl(){
        return new AuthServiceImpl();
    }
}
