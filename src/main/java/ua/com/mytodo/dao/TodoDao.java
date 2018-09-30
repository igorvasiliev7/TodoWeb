package ua.com.mytodo.dao;

import ua.com.mytodo.model.Todo;

import java.util.List;

public interface TodoDao extends CrudDao<Todo, Long> {
    
   List<Todo> todosByUserId(Long id);
}
