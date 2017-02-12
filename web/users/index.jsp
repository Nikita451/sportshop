<%-- 
    Document   : index
    Created on : 07.04.2014, 21:30:24
    Author     : Никита
--%>

<%@page import="ru.nikitainfo.OnePrognos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ru.nikitainfo.Prognos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/mainuser.css" />
    </head>
    <body>
        
        <h1>Добро пожаловать в наш спортивно-аналитический центр</h1>
        <div>
        <p>
            <a href="/Sport1/SaveCookieServlet?index.jsp">В магазин спортивных прогнозов</a>
        </p>
        <p>
            <a href="/Sport1/SaveCookieServlet?com.jsp">В чат</a>
        </p>
        <p>
            <a href="/Sport1/SaveCookieServlet?stat.jsp">Тестирование закономерностей</a>
        </p>
        </div>
    </body>
</html>
