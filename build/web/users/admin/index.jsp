<%-- 
    Document   : index
    Created on : 07.04.2014, 21:30:50
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
        <h1>Добро пожаловать Артур Пирожков!</h1>
        <div>
        <p>
            <a href="addprognos.jsp">Добавить прогноз</a>
        </p>
        <p>
            <a href="orders.jsp">Посмотреть заказы</a>
        </p>
        <p>
            <a href="/Sport1/SaveSessionAdmin?messages.jsp">Управление сообщениями</a>
        </p>
        </div>
    </body>
</html>
