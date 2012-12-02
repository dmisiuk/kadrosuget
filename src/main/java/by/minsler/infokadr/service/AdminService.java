package by.minsler.infokadr.service;

import by.minsler.infokadr.dvo.Film;
import by.minsler.infokadr.dvo.Trailer;

import java.util.Map;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:48 AM
 */
public interface AdminService {

    String createFilm(Film film);

    String createTrailer(Map<String, Object> map);

    Film readFilm(String keyString);

    Trailer readTrailer(String keyString);
}
