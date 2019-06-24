<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>List of students</h1>
    </jsp:attribute>
    <jsp:body>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Birthdate</th>
                <th>Email</th>
                <th>Telephone</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="person" items="${persons}">
                <tr>
                    <td scope="row">${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.birthDate}</td>
                    <td>${person.email}</td>
                    <td>${person.telephone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="/menu.jsp">Menu page</a>
    </jsp:body>
</myTags:template>