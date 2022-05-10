
<%@ page import="java.util.List" %>
<%@ page import="app.database.Person" %>
<%@ page import="app.model.Model" %>
<%@ page import="app.entities.User" %>
<%@ page import="static java.lang.System.out" %>
<%@ page import="static java.lang.System.out" %>
<%@ page import="static java.lang.System.*" %>
<%@ page import="java.io.IOException" %>
<%--
  Created by IntelliJ IDEA.
  User: Alfa
  Date: 28.04.2022
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Быки и коровы</h1>
</div>

<div class="w3-container w3-padding">

    <%
        Model model = Model.getInstance();

        if (model.getUsers() == null) {
            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"

                +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                "   <h5>Вам не удастся зайти, пользователей нет!</h5>\n" +
                "</div>");
        }

        Object error = request.getAttribute("error");

        if (error != null && (Boolean) error) {

            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"

                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Ошибка авторизации</h5>\n" +
                    "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Вход</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Логин:
                <input type="text" name="name" class="w3-input  w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Пароль:
                <input type="password" name="pass" class="w3-input  w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Войти</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Вернуться в меню</button>
</div>
</body>
</html>