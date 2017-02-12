
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
    </head>
    <body>
        <div id="form">
        <form method="POST" action="RegistrationServlet">
            <table>
                <tr>
                    <td>Имя: &nbsp;</td>
                    <td>
                        <input type="text" name="name" />
                    </td>
                </tr>
                <tr>
                    <td>Фамилия: &nbsp;</td>
                    <td>
                        <input type="text" name="sername" />
                    </td>
                </tr>
                <tr>
                    <td>Email: &nbsp;</td>
                    <td>
                        <input type="text" name="login" />
                    </td>
                </tr>
                <tr>
                    <td>Пароль: &nbsp;</td>
                    <td>
                        <input type="password" name="password" />
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
