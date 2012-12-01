package by.minsler.infokadr.service;

import by.minsler.infokadr.bean.Film;
import by.minsler.infokadr.bean.FilmDto;
import by.minsler.infokadr.bean.Trailer;
import by.minsler.infokadr.dao.FilmDao;
import by.minsler.infokadr.dao.TrailerDao;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:51 AM
 */
public class RpcServiceImpl implements RpcService {

    private FilmDao filmDao = new FilmDao();
    private TrailerDao trailerDao = new TrailerDao();

    @Override
    public List<FilmDto> getTenFilmsBefore(int id) {
        Trailer trailer = trailerDao.readTrailer(id);
        System.out.println(trailer);
        Film film = filmDao.readFilm(trailer.film);
        System.out.println(film);
        FilmDto fdto = new FilmDto(film);
        fdto.trailers = new ArrayList<Trailer>();
        fdto.trailers.add(trailer);
        fdto.activeTrailer = 0;
        System.out.println(fdto);
        List<FilmDto> list = new ArrayList<FilmDto>();
        list.add(fdto);
        return list;
    }

    @Override
    public List<FilmDto> getTenFilmsAfter(int id) {
        return null;
    }

    @Override
    public Trailer readTrailer(String key) {
        return trailerDao.readTrailer(key);
    }
}