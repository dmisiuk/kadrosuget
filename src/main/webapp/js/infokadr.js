var films = [];

var setFilm = function (number) {

    if (number + 1 > films.length || number < 0) {
        return;
    }

    film = films[number];
    trailer = film.trailers[film.active];
    new_title = trailer.name.replace("***", "\"" + film.rusName + "\" ");


    new_url = "http://www.youtube.com/embed/" + trailer.url;

    descripton = trailer.description;
    $("#description").text(descripton);
    $("#title").text(new_title);
    if (film.trailers.length > 1) {
        lis = "";
        for (i = 0; i < film.trailers.length; i++) {
            lis = lis + "<li "
            if (i == film.active) {
                lis = lis + "class='disabled'";
            }
            lis = lis + " ><a href='/video/" + film.trailers[i].key + "'>" + film.trailers[i].shortName + "</a></li>";
        }

        $("#title").append(
            $('<div>').attr("class", "btn-group").append(
                $("<button>").attr("class", "btn  btn-primary btn-mini dropdown-toggle").
                    attr("style", "font-size: 12px;font-weight: bold;").append("ещё ").append(
                    $("<span>").attr("class", "caret")
                )
            ).append(
                $("<ul>").attr("class", "dropdown-menu").append(lis)
            )
        )


    }
    $("#film_url").attr("src", new_url);

    setNext(number);
    setPrevious(number);

    activeFilm = number;
    $('.dropdown-toggle').dropdown();
}


var setPrevious = function (number) {

    li = $("#previous li");
    for (i = 2; i < li.size(); i++) {
        $(li[i]).remove();
    }

    start = number + 1;
    end = number + 5;
    if (end > films.length) {
        end = films.length;
    }

    for (i = start; i < end; i++) {
        film_name = films[i].rusName;
        $('#previous').append(
            $('<li>').append(
                $('<a>').attr('href', 'javascript:set_film(' + i + ')').append(film_name)
            )
        );
    }

}

var setNext = function (number) {

    li = $("#next li");
    for (i = 2; i < li.size(); i++) {
        $(li[i]).remove();
    }

    start = number - 1;
    end = number - 5;
    if (end < 0) {
        end = -1;
    }

    for (i = start; i > end; i--) {
        film_name = films[i].rusName;
        $('#next').append(
            $('<li>').append(
                $('<a>').attr('href', 'javascript:set_film(' + i + ')').append(film_name)
            )
        );
    }

}

var next = function () {
    setFilm(activeFilm - 1);
}

var previous = function () {
    setFilm(activeFilm + 1);
}


$(document).ready(
    function () {
        setFilm(0);
        $('.dropdown-toggle').dropdown();
    }
)