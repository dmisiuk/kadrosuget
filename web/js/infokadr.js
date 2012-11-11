var films = [];
var active_film = 0;

var hobbit = {
    "film_name":"Хоббит: Нежданное путешествие",
    "active": 0,
    "trs":[
        {
            "name":"Трейлер к фильму ***",
            "short_name":"трейлер #1",
            "url": "H9hbSvQrdnI",
            "description": "История приключений Бильбо Бэггинса. Однажды к нему в гости приехал его друг волшебник Гэндальф, а вместе с ним 13 гномов. В результате он оказывается участником похода под предводительством Торина Дубощита. Гномы отправляются к Одинокой Горе, чтобы сразиться с ужасным драконом Смогом. Им придётся пройти через Дикие Земли, кишащие орками и гоблинами. В одном из туннелей троллей Бильбо встретит странное существо по имени Голлум, которое изменит не только жизнь самого хоббита, но и судьбу Средиземья."
        }
    ]
}

var film0 = {
    "film_name":"Сумерки. Сага. Рассвет: Часть 2",
    "active": 0,
    "trs":[
        {
            "name":"Русский трейлер к фильму ***",
            "short_name":"трайлер #1",
            "url": "t4y0EuHL7dc",
            "description": "Русский трейлер к фильму сага"
        },
        {
            "name":"Русский трейлер к фмльму ***",
            "short_name":"трейлер #2",
            "url": "KdOe4cZsIm0",
            "description": "Русский трейлер к фильму сага #2"
        }
    ]
}

var film1 = {
    "film_name":"Шерлок Холмс2: Игра Теней",
    "active": 0,
    "trs":[
        {
            "name":"Трейлер к фильму ***",
            "short_name":"трейлер #1",
            "url": "AwV9L9M4n3I",
            "description": "Русский трейлер к фильму игра"
        },
        {
            "name":"Tизер фильма ***",
            "short_name":"тизер #1",
            "url": "iUU4Sl89LLY",
            "description": "Русский трейлер к фильму игра2"
        }
    ]
}

var film2 = {
    "film_name":"Агент 007: Координаты Скайфолл",
    "active": 0,
    "trs":[
        {
            "name":"Трейлер к фильму ***",
            "short_name":"трейлер #1",
            "url": "B3hXEMB2Y24",
            "description": "Русский трейлер к фильму агент"
        }
    ]
}

films = [hobbit,film0,film1,film2];

var current_film = 0;


var set_film = function(number){

    if(number + 1 > films.length || number < 0){
        return;
    }

    film = films[number];
    trailer = film.trs[film.active];
    new_title = trailer.name.replace("***", "\""+film.film_name+"\" ");


    new_url = "http://www.youtube.com/embed/" + trailer.url;

    descripton = trailer.description;
    $("#description").text(descripton);
    $("#title").text(new_title);
    if(film.trs.length > 1){
        lis ="";
        for(i = 0; i < film.trs.length; i++){
            lis = lis + "<li "
            if( i == film.active){
                lis = lis + "class='disabled'";
            }
            lis = lis +" ><a href='#'>"+ film.trs[i].short_name +"</a></li>";
        }

        $("#title").append(
            $('<div>').attr("class", "btn-group").append(
                $("<button>").attr("class","btn  btn-primary btn-mini dropdown-toggle").
                    attr("style", "font-size: 12px;font-weight: bold;").append("ещё ").append(
                    $("<span>").attr("class", "caret")
                )
            ).append(
                $("<ul>").attr("class", "dropdown-menu").append(lis)
            )
        )


    }
    $("#film_url").attr("src", new_url);

    set_next(number);
    set_previous(number);

    active_film = number;
    $('.dropdown-toggle').dropdown();
}


var set_previous = function(number){

    li = $("#previous li");
    for(i =2; i< li.size();i++){
        $(li[i]).remove();
    }

    start = number + 1;
    end = number + 5;
    if ( end > films.length ){
        end = films.length;
    }

    for( i = start; i < end; i++){
        film_name = films[i].film_name;
        $('#previous').append(
            $('<li>').append(
                $('<a>').attr('href','javascript:set_film('+i+')').append(film_name)
            )
        );
    }

}

var set_next = function(number){

    li = $("#next li");
    for(i =2; i< li.size();i++){
        $(li[i]).remove();
    }

    start = number  - 1;
    end = number - 5;
    if ( end < 0 ){
        end = -1;
    }

    for( i = start; i > end; i--){
        film_name = films[i].film_name;
        $('#next').append(
            $('<li>').append(
                $('<a>').attr('href','javascript:set_film('+i+')').append(film_name)
            )
        );
    }

}

var next = function(){
    set_film(active_film - 1);
}

var previous = function(){
    set_film(active_film + 1);
}



$(document).ready(
    function(){
        set_film(0);
        $('.dropdown-toggle').dropdown();
    }
)




