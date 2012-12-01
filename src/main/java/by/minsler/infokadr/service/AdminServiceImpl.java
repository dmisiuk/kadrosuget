package by.minsler.infokadr.service;

import by.minsler.infokadr.bean.Film;
import by.minsler.infokadr.dao.FilmDao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:51 AM
 */
public class AdminServiceImpl implements AdminService {

    private FilmDao dao = new FilmDao();

    @Override
    public Long createFilm(Map<String, String> map) {
        Film film = new Film();
        film.engName = map.get("engName");
        film.rusName = map.get("rusName");
        film.added = new Date();
        return dao.createFilm(film).getId();
    }

    @Override
    public List<Film> readAllFilms() {
        return dao.readAllFilms();
    }
}