package by.minsler.infokadr.dao;

import by.minsler.infokadr.bean.Film;
import com.googlecode.objectify.Key;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:19 AM
 */
public class FilmDao {

    public Key createFilm(Film film) {
        Key<Film> res = ofy().save().entity(film).now();
        return res;
    }

    public void deleteFilm(Key<Film> key) {
        ofy().delete().key(key).now();
    }

    public Film readFilm(Key<Film> key) {
        return ofy().load().key(key).get();
    }

    public Key updateFilm(Film film) {
        Key<Film> res = ofy().save().entity(film).now();
        return res;
    }

    public List<Film> readAllFilms() {
        return ofy().load().type(Film.class).list();
    }

    public Film readFilm(int lid) {
        return ofy().load().type(Film.class).id(lid).get();
    }
}
