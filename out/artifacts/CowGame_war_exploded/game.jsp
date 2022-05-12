<%@ page import="app.gameplay.Gameplay" %><%--
  Created by IntelliJ IDEA.
  User: Alfa
  Date: 17.04.2022
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Игра</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
    <body>
        <div class="w3-container w3-center w3-green">
            <h2>Игра</h2>
        </div>
        <div>
            <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Введите свой вариант:
                <input type="text" name="value" class="w3-input  w3-border w3-round-large" style="width: 30%"><br />
            </label>

            <button type="submit" class="w3-btn w3-blue w3-round-large w3-margin-bottom">Ввести</button>
                <label1>Введите "0", если хотите перезагрузить игру</label1>
            </form>
            <label>
                <%

                    if (request.getAttribute("value") != null) {
                        out.println("<h2>" + request.getAttribute("value")  +"</h2>");
                    }
                %>
            </label>
            <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
                <button class="w3-btn w3-round-large" onclick="location.href='/'">Вернуться в меню</button>
            </div>
        </div>
    </body>
</html>
