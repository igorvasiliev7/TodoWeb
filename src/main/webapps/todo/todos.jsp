<%@ page import="ua.com.mytodo.model.Todo" %>
<%@ page import="ua.com.mytodo.service.factory.ServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.com.mytodo.model.User" %>
<%@ page import="ua.com.mytodo.dto.TodoDTO" %><%--
  Created by IntelliJ IDEA.
  User: Irina
  Date: 29.09.2018
  Time: 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="../error.jsp" language="java" %>
<html>
<head>
    <title>Todo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>

<%
    final Long userId = Long.valueOf(String.valueOf(session.getAttribute("userId")));
    List<TodoDTO> todos = ServiceFactory.todoServiceImpl().findByUserId(userId);
%>

<h1 align="center">Todos</h1>


<div align="center" class="container">
    <div align="right">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Add
        </button>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (TodoDTO elem : todos) {
        %>
        <tr>
            <td> <%= elem.getId()%> </td>
            <td><%= elem.getName()%></td>
            <td><%= elem.getStatus()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add todo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/save" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <select name="status" class="form-control">
                                <option value="1">OK</option>
                                <option value="2">FINE</option>
                                <option value="3">CRITICAL</option>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->

</body>
</html>
