
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход в спортивный центр</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
    </head>
    <body>
        <div id="form">
        <form method="POST" action="j_security_check">
            <table>
                <tr>
                    <td>Логин: &nbsp;</td>
                    <td>
                        <input type="text" name="j_username" />
                    </td>
                </tr>
                <tr>
                    <td>Пароль: &nbsp;</td>
                    <td>
                        <input type="password" name="j_password" />
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" value="Отправить" />
                    </td>
                </tr>
            </table>
        </form>
            </div>
    </body>
</html>
