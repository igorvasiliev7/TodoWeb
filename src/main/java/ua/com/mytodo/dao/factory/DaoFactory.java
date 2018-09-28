package ua.com.mytodo.dao.factory;

import ua.com.mytodo.dao.TodoDao;
import ua.com.mytodo.dao.UserDao;
import ua.com.mytodo.dao.impl.TodoDaoImpl;
import ua.com.mytodo.dao.impl.UserDaoImpl;

public class DaoFactory {

   public static UserDao getUserDaoImpl(){
        return new UserDaoImpl();
    }
   public static TodoDao getTodoDaoImpl(){
        return new TodoDaoImpl();
    }
}
