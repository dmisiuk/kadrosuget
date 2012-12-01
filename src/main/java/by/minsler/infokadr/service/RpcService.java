package by.minsler.infokadr.service;

import by.minsler.infokadr.bean.FilmDto;
import by.minsler.infokadr.bean.Trailer;

import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:48 AM
 */
public interface RpcService {

    List<FilmDto> getTenFilmsBefore(int id);

    List<FilmDto> getTenFilmsAfter(int id);

    Trailer readTrailer(String key);
}
