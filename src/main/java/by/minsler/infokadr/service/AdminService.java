package by.minsler.infokadr.service;

import by.minsler.infokadr.bean.Film;

import java.util.List;
import java.util.Map;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:48 AM
 */
public interface AdminService {

    Long createFilm(Map<String, String> map);

    List<Film> readAllFilms();
}
