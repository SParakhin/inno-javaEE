<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>Students</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/person/list">List students</a></li>
    <li><a href="${pageContext.request.contextPath}/person">New student</a></li>
    <br/>
</ul>
<form action="${pageContext.request.contextPath}/logout" method="GET">
    <input class="button" type="submit" value="Выход">
</form>

</body>
</html>
