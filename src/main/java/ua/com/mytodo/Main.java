package ua.com.mytodo;

import ua.com.mytodo.service.factory.ServiceFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println(ServiceFactory.todoServiceImpl().todosByUserId(1L));
        System.out.println(ServiceFactory.todoServiceImpl().findAll());
    }
}
