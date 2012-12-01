<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Инфокадр: Панель администратора: Вы не имеете прав</title>
    <meta name="description" content="Трейлеры и кадросюжеты фильмов (кадры из фильмов и сюжеты к ним)."/>
    <meta name="keywords"
          content="инфокадр, трейлеры, трейлеры фильмов, новые трейлеры, трейлеры онлайн, кадросюжеты, кадры из фильмов, сюжеты фильмов"/>

    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>
<body style="background-color: whiteSmoke">

<div class="container">
    <%@ include file="/WEB-INF/_parts/header.jsp" %>
    <br>

    <h1>У вас нет прав администратора</h1>
    <%=request.getAttribute("email")%> <a href="<%= request.getAttribute("logoutUrl")%>">logout</a>
</div>

</body>
</html>