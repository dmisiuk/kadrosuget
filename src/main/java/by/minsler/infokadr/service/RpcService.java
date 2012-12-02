package by.minsler.infokadr.service;

import by.minsler.infokadr.dto.FilmDto;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 3:48 AM
 */
public interface RpcService {

    FilmDto getFilmDto(String trailerKeyString);
}
