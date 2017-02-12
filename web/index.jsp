<%-- 
    Document   : index
    Created on : 07.04.2014, 21:28:57
    Author     : Никита
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="prognoses" class="ru.nikitainfo.Prognos" scope="page" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/buyprognos.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xmlhttprequest.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/basket.js"></script>
    </head>
    <body>
        <h1>Добро пожаловать в наш спортивно-аналитический центр</h1>
        <h2>Список наших прогнозов:</h2>
        
        <div id="basket">
        </div>
        <div > 
            <a style="color: yellow" href="/Sport1/users">В главное меню</a>
        </div>
        <div id="main">
        <table>
            <tr>
                <th>Событие</th>
                <th>Дата</th>
                <th>Цена</th>
                <th>Коэффициент</th>
                <th>...</th>
            </tr>
        <c:forEach var="prognos" items="${pageScope.prognoses.progs}">
            <tr id="${prognos.id}">
            <td><c:out value="${prognos.event}" /></td>
            <td><c:out value="${prognos.date_event}" /></td>
            <td><c:out value="${prognos.price}" /></td>
            <td><c:out value="${prognos.kef}" /></td>
            <td><a href="#${prognos.id}|${prognos.event}|${prognos.price}|${prognos.kef}">Купить</a></td>
            </tr>
        </c:forEach> 
        </table>
        </div>
        
    </body>
</html>
