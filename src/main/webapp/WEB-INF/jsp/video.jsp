<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Инфокадр: трейлеры фильмов 2012-2013 и кадросюжеты | новые трейлеры онлайн | кадры из фильмов</title>
    <meta name="description" content="Трейлеры и кадросюжеты фильмов (кадры из фильмов и сюжеты к ним)."/>
    <meta name="keywords"
          content="инфокадр, трейлеры, трейлеры фильмов, новые трейлеры, трейлеры онлайн, кадросюжеты, кадры из фильмов, сюжеты фильмов"/>

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="/bootstrap/css/responsive-video.css" rel="stylesheet">
    <script src="/js/jquery.min.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap-transition.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap-dropdown.js" type="text/javascript"></script>
    <script src="/js/infokadr.js" type="text/javascript"></script>


    <script type="text/javascript">
        var activeFilm = 0;

        var film1 = <%=(String)request.getAttribute("film")%>;

        films = [film1];
    </script>

    <link href="/css/infokadr.css" rel="stylesheet">
    <script src="/js/all.io.js" type="text/javascript"></script>
    <script src="/js/rpc.js" type="text/javascript"></script>

</head>
<body style="background-color: whiteSmoke">

<div class="container">
    <br>

    <div class="row">
        <div class="span6">
            <ul class="nav nav-pills">
                <li><a href="/" style="font-weight: bold;">infokadr</a></li>
                <li><a href="#">трейлеры</a></li>
                <li><a href="#">кадросюжеты</a></li>
            </ul>
        </div>
        <div style="text-align: right" class="span6">
            <div class="control-group">
                <div class="controls">
                    <div class="input-prepend">
                    <span class="add-on">
                        <i class="icon-search"></i>
                    </span>
                        <input type="search" class="span3" placeholder="поиск по названию фильма" name="search"
                               id="search"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="span2">

        </div>
        <div id="title" class="span6">

            <a href="#"><span class="label label-info" style="background-color: #08C;">ещё трейлер</span></a>
        </div>

        <div class="span2" style="text-align: right">
            <button class="btn btn-mini btn-primary" style="font-size: 12px;font-weight: bold;">кадросюжет</button>
        </div>
        <div class="span2">

        </div>
    </div>
    <br>

    <div class="row" style="font-size: 14px">
        <div class="span2">
            <ul id="previous" class="nav nav-list">
                <!--<li class="previous">-->
                <!--<a href="#">&larr;</a>-->
                <!--</li>-->
                <li><a href="javascript:previous()"><img src="/image/vlevo.png"></a></li>
                <li class="nav-header">Предыдущие трейлеры:</li>

            </ul>
        </div>
        <div class="span8">
            <div class="flex-video widescreen">
                <iframe id="film_url" src="" frameborder="0" allowfullscreen></iframe>
            </div>
        </div>
        <div class="span2">
            <ul id="next" class="nav nav-list">
                <!--<li class="previous">-->
                <!--<a href="#">&rarr;</a>-->
                <!--</li>-->
                <li><a href="javascript:next()"><img src="/image/vpravo.png"></a></li>
                <li class="nav-header">Следующие трейлеры:</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="span2">
            <a style="color: #737373; ; text-decoration: no-underline;" href="mailto:kino@dol.by">kino@dol.by</a>
        </div>
        <div id="description" class="span8"></div>
        <div class="span2">

        </div>
    </div>


</div>

</body>
</html>