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

    private static final String INSERT_PROJ = "INSERT INTO projects (name) VALUES (?)";
    private static final String INSERT_USER = "INSERT INTO project_users ( project_id, user_id) VALUES (?,?)";
    private static final String SELECT_PROJECTS =
            "select p.id, p.name from project_users pu, projects p WHERE pu.user_id=? AND pu.project_id=p.id;";
    private static final String SELECT_FELLOWS =
            "select u.id, u.name_user from project_users pu, users u WHERE pu.user_id=? AND pu.project_id=u.id;";
    private static final String SELECT_ALL = "select * from todos;";

    @Override
    public void save(Todo todo) {

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
    public Todo changeName(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
