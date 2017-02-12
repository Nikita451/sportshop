<%-- 
    Document   : orders
    Created on : 19.04.2014, 1:02:22
    Author     : Никита
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ru.nikitainfo.ClientOrders"%>
<%@page import="ru.nikitainfo.OneClientOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ru.nikitainfo.WorkClientOrders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="orders" class="ru.nikitainfo.WorkClientOrders" scope="page" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
    </head>
    <body>
        <table width="100%">
            <tr>
                <th>Номер заказа</th>
                <th>Дата</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>email</th>
                <th>Прогноз(ы)</th>
            </tr>
        <c:forEach var="order" items="${pageScope.orders.orders}">
            <tr>
            <td><c:out value="${order.id_deal}" /></td>
            <td><c:out value="${order.dateBegin}" /></td>
            <td><c:out value="${order.sername}" /></td>
            <td><c:out value="${order.name}" /></td>
            <td><c:out value="${order.email}" /></td>
            <td>
                <table>
                    <tr>
                        <th>Событие</th>
                        <th>Коф</th>
                        <th>Прогноз</th>
                        <th>Цена</th>
                    </tr>
                    <c:forEach var="elem" items="${order.orders}">
                        <tr>
                            <td><c:out value="${elem.event}" /></td>
                            <td><c:out value="${elem.kef}" /></td>
                            <td><c:out value="${elem.prognos}" /></td>
                            <td><c:out value="${elem.price}" /></td>
                        </tr>
                    </c:forEach>
                    
                </table>
                
                
            </td>
            </tr>
        </c:forEach> 
        </table>
        </div>
    </body>
</html>
