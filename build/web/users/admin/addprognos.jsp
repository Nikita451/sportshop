
<%@page import="ru.nikitainfo.*"%>
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
        <form method="POST" action="/Sport1/AddPrognosServlet">
            <table>
                <tr>
                    <td>Тип прогноза: &nbsp;</td>
                    <td>
                        <select name="type">
                            <option value="1">Ординар</option>
                            <option value="2">Экспресс</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Событие(я): &nbsp;</td>
                    <td>
                        <textarea name="event" cols="20" rows="5"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>Прогноз: &nbsp;</td>
                    <td>
                        <input type="text" name="prognos" />
                    </td>
                </tr>
                <tr>
                    <td>Цена: &nbsp;</td>
                    <td>
                        <input type="text" name="price" />
                    </td>
                </tr>
                <tr>
                    <td>Время: &nbsp;</td>
                    <td>
                        <input type="text" name="time" />
                    </td>
                </tr>
                <tr>
                    <td>Коэффициент: &nbsp;</td>
                    <td>
                        <input type="text" name="kof" />
                    </td>
                </tr>
                <tr>
                    <td>Фото 1: &nbsp;</td>
                    <td>
                        <input type="text" name="foto1" />
                    </td>
                </tr>
                <tr>
                    <td>Фото 2: &nbsp;</td>
                    <td>
                        <input type="text" name="foto2" />
                    </td>
                </tr>
                <tr>
                    <td>Фото 3: &nbsp;</td>
                    <td>
                        <input type="text" name="foto3" />
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
