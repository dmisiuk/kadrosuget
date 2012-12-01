package by.minsler.infokadr.service;

import by.minsler.infokadr.bean.Film;
import by.minsler.infokadr.bean.Trailer;
import by.minsler.infokadr.dao.FilmDao;
import by.minsler.infokadr.dao.TrailerDao;
import com.google.appengine.api.datastore.Link;
import com.googlecode.objectify.Key;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:51 AM
 */
public class AdminServiceImpl implements AdminService {

    private FilmDao filmDao = new FilmDao();
    private TrailerDao trailerDao = new TrailerDao();

    @Override
    public String createFilm(Map<String, String> map) {
        Film film = new Film();
        film.engName = map.get("engName");
        film.rusName = map.get("rusName");
        film.added = new Date();
        return filmDao.createFilm(film).getString();
    }

    @Override
    public List<Film> readAllFilms() {
        return filmDao.readAllFilms();
    }

    @Override
    public String createTrailerWithParent(Map<String, Object> map) {
        String filmKeyString = (String) map.get("filmId");
        Map<String, String> tm = (Map<String, String>) map.get("trailer");
        Trailer trailer = new Trailer();
        trailer.added = new Date();
        trailer.shortName = tm.get("shortName");
        trailer.description = tm.get("description");
        trailer.youtubeUrl = new Link(tm.get("youtubeUrl"));

        trailer.film = Key.create(filmKeyString);
        Key<Film> k = Key.create(filmKeyString);

        return trailerDao.createTrailer(trailer).getString();
    }

    @Override
    public String createTrailer(Map<String, String> tm) {

        Trailer trailer = new Trailer();
        trailer.added = new Date();
        trailer.shortName = tm.get("shortName");
        trailer.description = tm.get("description");
        trailer.youtubeUrl = new Link(tm.get("youtubeUrl"));

        return trailerDao.createTrailer(trailer).getString();
    }

}