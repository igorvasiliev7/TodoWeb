package ua.com.mytodo.dao;

import java.util.List;

public interface CrudDao<T, ID> {

    void save(T t);

    List<T> findAll();

    void changeName(T t);

    void delete(ID id);

    default T findByID(ID id) {
        return null;
    }
}
