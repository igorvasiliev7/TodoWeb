package ua.com.mytodo.service.impl;

import ua.com.mytodo.dao.factory.DaoFactory;
import ua.com.mytodo.model.Todo;
import ua.com.mytodo.service.TodoService;

import java.util.List;

public class TodoServiceImpl implements TodoService {
    @Override
    public void save(Todo todo) {
        DaoFactory.getTodoDaoImpl().save(todo);
    }

    @Override
    public List<Todo> findAll() {

        return DaoFactory.getTodoDaoImpl().findAll();
    }

    @Override
    public void changeName(Todo todo) {
        DaoFactory.getTodoDaoImpl().changeName(todo);
    }

    @Override
    public void delete(Long id) {
        DaoFactory.getTodoDaoImpl().delete(id);
    }
}
