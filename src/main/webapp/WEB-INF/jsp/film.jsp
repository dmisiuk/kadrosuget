<%@ page import="by.minsler.infokadr.bean.Film" %>
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
    <% Film film = (Film) request.getAttribute("film");%>
    <%=film.engName%> <br>
    <%=film.rusName%> <br>
    Создан: <%=film.added%>
    url: <a href="/films/<%=film.id %>">films/<%=film.id %>
</div>

</body>
</html>