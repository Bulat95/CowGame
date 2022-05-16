<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %>
<%@ page import="app.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Пользователи</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
            <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Быки и коровы</h1>
        </div>
            <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-light-blue">
            <h2>Пользователи</h2>
        </div>
                <%
            // Проверка есть ли пользователи. Если есть, то вывод их на экран
            Model model = Model.getInstance(); // инициализирую массив пользователей

            if (model != null && model.getUsers() != null) {
                for (User user : model.getUsers()) {
                    out.println("<ul class=\"w3-ul\">");
                    int result = 0;
                    if (user.getNumberOfGames() != 0){
                        result = Model.getInstance().writeAndGetResult();
                    }
                    out.println("<li class=\"w3-hover-sand\">" + user.getName() + " (" + result + ")" + "</li>");
                    out.println("</ul>");
                }
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Пользователей нет - будь первым!</h5>\n" +
                    "</div>");
        %>
            </div>
        </div>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'">Вернуться в меню</button>
        </div>
    </body>
</html>