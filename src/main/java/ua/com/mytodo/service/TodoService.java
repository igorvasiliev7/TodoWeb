package ua.com.mytodo.service;

import ua.com.mytodo.model.Todo;

import java.util.List;

public interface TodoService extends CrudService<Todo, Long>{
    List<Todo> todosByUserId(Long id);
}
