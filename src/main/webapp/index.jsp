<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 11.06.2019
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://bootswatch.com/3/united/bootstrap.min.css">
</head>
<body>

<div class="form">

    <h1>Вход в систему</h1>
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Войти">
    </form>
    <h4>Для первого входа admin/123</h4>
</div>
</body>
</html>
