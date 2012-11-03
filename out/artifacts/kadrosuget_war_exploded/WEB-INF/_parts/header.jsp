<%@ page contentType="text/html;charset=UTF-8"%>
<header>
    <div id="logo">
        <a href="/">Кадросюжет</a>
    </div>
    <div id="search">
        <form action="/ks" method="get">
            <input type="text" size="40"  name="name" value="введите текст для поиска">
            <input type="submit"  value="поиск">
        </form>
    </div>
</header>