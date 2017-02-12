<%-- 
    Document   : com
    Created on : 14.04.2014, 23:45:05
    Author     : Никита
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xmlhttprequest.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/begincom.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <div id="da">
                
        </div>
        
        <div id="addmess">
            <h2>Ваше новое сообщение: </h2>
            <textarea cols="15" rows="10" id="mess_text" ></textarea>
            <button id="but_ok">Отправить</button>
        </div>
    </body>
</html>
