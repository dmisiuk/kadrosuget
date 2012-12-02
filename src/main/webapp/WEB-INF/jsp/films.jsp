<%@ page import="by.minsler.infokadr.dvo.Film" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Инфокадр: Панель администратора: Вы администратор</title>
    <meta name="description" content="Трейлеры и кадросюжеты фильмов (кадры из фильмов и сюжеты к ним)."/>
    <meta name="keywords"
          content="инфокадр, трейлеры, трейлеры фильмов, новые трейлеры, трейлеры онлайн, кадросюжеты, кадры из фильмов, сюжеты фильмов"/>

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <script type="/text/javascript" src="js/all.io.js"></script>
    <%@ include file="/WEB-INF/_parts/rpcjs.jsp" %>
</head>
<body style="background-color: whiteSmoke">

<div class="container">
    <%@ include file="/WEB-INF/_parts/header.jsp" %>
    <br>

    <h1>Вы администратор</h1>
    <hr>
    <form action="films" method="post">
        Имя фильма на ангийском <input type="text" name="engName"><br>
        Имя фильма на русском <input type="text" name="rusName"><br>
        <input type="submit" value="Создать фильм">
    </form>
    <hr>
    <ul>
        <%
            List<Film> list = (List<Film>) request.getAttribute("list");
            for (Film film : list) {
        %>
        <li>
            <%=film.engName%> <br>
            <%=film.rusName%> <br>
            Создан: <%=film.added%>
            url: <a
                href="/films/<%=Key.create(Film.class,film.id).getString() %>">films/<%=Key.create(Film.class, film.id).getString() %>
        </a>
        </li>
        <%
            }
        %>
    </ul>
</div>

</body>
</html>