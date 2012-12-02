package by.minsler.infokadr.dao;

import by.minsler.infokadr.dvo.Film;
import com.googlecode.objectify.Key;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:19 AM
 */
public class FilmDao {

    public String createFilm(Film film) {
        return ofy().save().entity(film).now().getString();
    }

    public String updateFilm(Film film) {
        return ofy().save().entity(film).now().getString();
    }

    public Film readFilm(String stringKey) {
        Key<Film> key = Key.create(stringKey);
        return this.readFilm(key);
    }

    public Film readFilm(Long id) {
        Key<Film> key = Key.create(Film.class, id);
        return this.readFilm(key);
    }

    public Film readFilm(Key<Film> key) {
        return ofy().load().key(key).get();
    }


    public List<Film> readAllFilms() {
        return ofy().load().type(Film.class).list();
    }
}
