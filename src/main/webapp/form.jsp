<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Adding a new student</h1>
    </jsp:attribute>
    <jsp:body>
        <form method="post" action="${pageContext.request.contextPath}/person" autocomplete="on">
            <div class="form-group">
                <label for="name">Name</label>
                <input name="name" type="text" class="form-control" id="name"/>
            </div>
            <div class="form-group">
                <label for="birth">Birth</label>
                <input name="birth" type="text" class="form-control" id="birth"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input name="email" type="text" class="form-control" id="email"/>
            </div>
            <div class="form-group">
                <label for="telephone">Telephone</label>
                <input name="telephone" type="text" class="form-control" id="telephone"/>
            </div>
            <div class="form-group">
                <label for="login">Login</label>
                <input name="login" type="text" class="form-control" id="login"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input name="password" type="password" class="form-control" id="password"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </jsp:body>
</myTags:template>