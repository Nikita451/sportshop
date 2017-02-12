
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xmlhttprequest.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xslt.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/stat.js"></script>
    </head>
    <body>
        <form method="POST" action="BinomServlet">
            <h1 id="res"></h1>
            
            <h2>Тестирование закономерностей</h2>
            <div > 
            <a style="color: yellow" href="/Sport1/users">В главное меню</a>
            </div>
            <div id="form">
            <table>
                <tr>
                    <td>Число успешных ставок: &nbsp;</td>
                    <td>
                        <input type="text" name="my_k" id="my_k" />
                    </td>
                </tr>
                <tr>
                    <td>Общее число ставок: &nbsp;</td>
                    <td>
                        <input type="text" name="my_n" id="my_n" />
                    </td>
                </tr>
                <tr>
                    <td>Коэффициент в БК: &nbsp;</td>
                    <td>
                        <input type="text" name="my_p" id="my_p" />
                    </td>
                </tr>
                <tr>
                    <td>Процент комиссии букмекера: &nbsp;</td>
                    <td>
                        <input type="text" name="my_com" id="my_com" />
                    </td>
                </tr>
                
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" value="Отправить" id="sub" />
                    </td>
                </tr>
            </table>
        </form>
</div>
    </body>
</html>
