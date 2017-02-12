<%-- 
    Document   : loginerror
    Created on : 07.04.2014, 21:36:42
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
        <div>
        <p>
            Неправильный пароль или имя пользователя!
        </p>
        <p>
            Я сделал ошибку при вводе, дайте пожалуйста <a href="/Sport1/users">ввести</a> данные еще раз!
        </p>
        </div>
    </body>
</html>
