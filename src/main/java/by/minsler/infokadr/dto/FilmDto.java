package by.minsler.infokadr.dto;

import by.minsler.infokadr.dvo.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 12/3/12
 * Time: 12:44 AM
 */
public class FilmDto {

    public String rusName;

    public int active;

    public List<TrailerDto> trailers;

    public FilmDto(Film film, String keyString) {
        this.rusName = film.rusName;

        trailers = new ArrayList<TrailerDto>();

        List<String> trKeyStringList = film.trailers;
        for (String trKeyString : trKeyStringList) {
            trailers.add(new TrailerDto(trKeyString));
        }

        active = film.trailers.indexOf(keyString);
    }
}
