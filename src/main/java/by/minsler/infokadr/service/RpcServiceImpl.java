package by.minsler.infokadr.service;

import by.minsler.infokadr.dao.FilmDao;
import by.minsler.infokadr.dao.TrailerDao;
import by.minsler.infokadr.dto.FilmDto;
import by.minsler.infokadr.dvo.Film;
import by.minsler.infokadr.dvo.Trailer;
import com.googlecode.objectify.Key;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:51 AM
 */
public class RpcServiceImpl implements RpcService {

    private FilmDao filmDao = new FilmDao();
    private TrailerDao trailerDao = new TrailerDao();

    @Override
    public FilmDto getFilmDto(String trailerKeyString) {
        Key<Trailer> trailerKey = Key.create(trailerKeyString);
        Key<Film> filmKey = trailerKey.getParent();
        Film film = filmDao.readFilm(filmKey);

        FilmDto fdto = new FilmDto(film, trailerKeyString);
        return fdto;
    }
}