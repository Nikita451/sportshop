<%-- 
    Document   : com
    Created on : 14.04.2014, 23:45:05
    Author     : Никита
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/com.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xmlhttprequest.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xslt.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/begincom_1.js"></script>
    </head>
    <body>
        <h1>Приятного общения!</h1>
        <div id="da">
                
        </div>
        
        <div id="addmess">
            <h2>Ваше новое сообщение: </h2>
            <textarea cols="45" rows="8" id="mess_text" ></textarea>
            <button id="but_ok">Отправить</button>
        </div>
        <div id="messages">
            
        </div>
    </body>
</html>
