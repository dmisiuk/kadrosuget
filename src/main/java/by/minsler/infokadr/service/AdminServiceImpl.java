package by.minsler.infokadr.service;

import by.minsler.infokadr.dao.FilmDao;
import by.minsler.infokadr.dao.TrailerDao;
import by.minsler.infokadr.dvo.Film;
import by.minsler.infokadr.dvo.Trailer;
import com.googlecode.objectify.Key;

import java.util.Date;
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
    public String createFilm(Film film) {
        film.added = new Date();
        return filmDao.createFilm(film);
    }

    @Override
    public String createTrailer(Map<String, Object> map) {
        String filmKeyString = (String) map.get("film");
        Key<Film> filmKey = Key.create(filmKeyString);

        Map<String, String> tm = (Map<String, String>) map.get("trailer");
        Trailer trailer = new Trailer();
        trailer.added = new Date();
        trailer.name = tm.get("name");
        trailer.shortName = tm.get("shortName");
        trailer.description = tm.get("description");
        trailer.url = tm.get("url");
        trailer.film = filmKey;

        String trailerKeyString = trailerDao.createTrailer(trailer);

        Film film = filmDao.readFilm(filmKeyString);
        film.addTrailer(trailerKeyString);
        filmDao.updateFilm(film);
        return trailerKeyString;
    }

    @Override
    public Film readFilm(String keyString) {
        Film film = filmDao.readFilm(keyString);
        return film;
    }

    @Override
    public Trailer readTrailer(String keyString) {
        Trailer trailer = trailerDao.readTrailer(keyString);
        trailer.film = null;
        return trailer;
    }

}