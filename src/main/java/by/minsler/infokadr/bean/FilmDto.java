package by.minsler.infokadr.bean;

import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 4:04 PM
 */
public class FilmDto extends Film {

    public List<Trailer> trailers;
    public int activeTrailer;

    public FilmDto() {
    }

    public FilmDto(Film film) {
        this.rusName = film.rusName;
        this.engName = film.engName;
        this.added = film.added;
        this.id = film.id;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public int getActiveTrailer() {
        return activeTrailer;
    }

    public void setActiveTrailer(int activeTrailer) {
        this.activeTrailer = activeTrailer;
    }
}
