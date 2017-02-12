<%-- 
    Document   : welcome
    Created on : 12.04.2014, 3:04:37
    Author     : Никита
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/mainuser.css" />
    </head>
    <body>
        <h1>Добро пожаловать, дорогой друг!</h1>
        <div>
        <p>
            <a href="registration.jsp">Регистрация</a>
        </p>
        <p>
            <a href="users">Войти</a>
        </p>
        </div>
    </body>
</html>
