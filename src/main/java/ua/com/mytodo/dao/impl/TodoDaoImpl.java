package ua.com.mytodo.dao.impl;

import ua.com.mytodo.dao.TodoDao;
import ua.com.mytodo.datasource.DatabaseSource;
import ua.com.mytodo.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    private static final String INSERT_TODO = "INSERT INTO todos ( name) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM todos;";
    private static final String UPDATE_TODO = "UPDATE todos SET name=? WHERE id=?;";
    private static final String DELETE_TODO = "DELETE FROM todos WHERE id=?;";

    @Override
    public void save(Todo todo) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODO)) {
            preparedStatement.setString(1, todo.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> todos = new LinkedList<>();
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getLong("id"));
                todo.setName(resultSet.getString("name"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    @Override
    public void changeName(Todo todo) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TODO)) {
           preparedStatement.setString(1, todo.getName());
           preparedStatement.setLong(2, todo.getId());
           preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TODO)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
