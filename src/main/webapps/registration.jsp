<%--
  Created by IntelliJ IDEA.
  User: igorv
  Date: 9/28/2018
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form action="/registration" method="post">
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="user-name-label">Name</label>
            <input name="name" type="text" class="form-control" id="user-name-label">
        </div>
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input name="email" type="email" class="form-control" id="inputEmail4" placeholder="Email">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Password</label>
            <input name="password" type="password" class="form-control" id="inputPassword4" placeholder="Password">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div>
</body>
</html>
