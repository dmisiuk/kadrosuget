package by.minsler.infokadr.dto;

import by.minsler.infokadr.dao.TrailerDao;
import by.minsler.infokadr.dvo.Trailer;

/**
 * User: dzmitry.misiuk
 * Date: 12/3/12
 * Time: 12:45 AM
 */
public class TrailerDto {

    public String key;

    public String name;

    public String shortName;

    public String description;

    public String url;

    public TrailerDto(String trKeyString) {
        Trailer trailer = new TrailerDao().readTrailer(trKeyString);
        this.key = trKeyString;
        this.name = trailer.name;
        this.shortName = trailer.shortName;
        this.description = trailer.description;
        this.url = trailer.url;
    }
}
