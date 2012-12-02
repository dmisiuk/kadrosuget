package by.minsler.infokadr.dao;

import by.minsler.infokadr.dvo.Trailer;
import com.googlecode.objectify.Key;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:19 AM
 */
public class TrailerDao {

    public String createTrailer(Trailer trailer) {
        return ofy().save().entity(trailer).now().getString();
    }

    public String updateTrailer(Trailer trailer) {
        return ofy().save().entity(trailer).now().getString();
    }

    public Trailer readTrailer(String keyString) {
        Key<Trailer> key = Key.create(keyString);
        return ofy().load().key(key).get();
    }
}