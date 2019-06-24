<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Login page</h1>
    </jsp:attribute>
    <jsp:body>
        <form action="${pageContext.request.contextPath}/login" method="POST">
            <div class="form-horizontal">
                <label for="login">Login</label>
                <input name="login" type="text" class="form-control" id="login"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input name="password" type="password" class="form-control" id="password"/>
            </div>
            <button type="submit" class="btn btn-primary">Войти</button>
        </form>
        <h4>Для первого входа admin/123</h4>
    </jsp:body>
</myTags:template>
