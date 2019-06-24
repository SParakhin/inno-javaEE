<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>


<myTags:template>
    <jsp:attribute name="header">
        <h1>Menu page</h1>
    </jsp:attribute>
    <jsp:body>
        <ul>
            <li><a href="${pageContext.request.contextPath}/person/list">List students</a></li>
            <li><a href="${pageContext.request.contextPath}/person">New student</a></li>
        </ul>
        <form action="${pageContext.request.contextPath}/logout" method="GET">
            <button type="submit" class="btn btn-primary">Exit</button>
        </form>
    </jsp:body>
</myTags:template>


