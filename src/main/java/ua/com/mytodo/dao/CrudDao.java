package ua.com.mytodo.dao;

import java.util.List;

public interface CrudDao<T,ID> {
    void save(T t);
    List<T> findAll();
    T changeName(ID id);
    void delete(ID id);
}
