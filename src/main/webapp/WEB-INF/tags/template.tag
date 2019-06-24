<%@tag description="Main layout" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@attribute name="header" fragment="true" required="false" %>
<html>
<head>
    <link rel="stylesheet" href="/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <jsp:invoke fragment="header"/>
    <jsp:doBody/>
</div>
</body>
</html>