<%@ page import="ua.com.mytodo.model.Todo" %>
<%@ page import="ua.com.mytodo.service.factory.ServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.com.mytodo.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Irina
  Date: 29.09.2018
  Time: 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo</title>
</head>
<body>

<%
    final Long userId = Long.valueOf(String.valueOf(session.getAttribute("userId")));

    List<Todo> todos = ServiceFactory.todoServiceImpl().todosByUserId(userId);
    for (Todo todo : todos) {
        System.out.println(todo.toString());
    }

%>

<h1 align="center">Todos</h1>

<div align="center" class="container">
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
            for (Todo elem : todos) {
        %>
        <tr>
            <td> <%= elem.getId()%> </td>
            <td><%= elem.getName()%></td>
            <td><%= elem.getStatus()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>


</body>
</html>
