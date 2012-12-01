package by.minsler.infokadr.dao;

import by.minsler.infokadr.bean.Trailer;
import com.googlecode.objectify.Key;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:19 AM
 */
public class TrailerDao {

    public Key createTrailer(Trailer trailer) {
        Key<Trailer> res = ofy().save().entity(trailer).now();
        return res;
    }

    public void deleteTrailer(Key<Trailer> key) {
        ofy().delete().key(key).now();
    }

    public Trailer readTrailer(String keyString) {
        Key<Trailer> key = Key.create(keyString);
        Trailer tr = ofy().load().key(key).get();
        tr.film = null;
        return tr;
    }

    public Key updateTrailer(Trailer trailer) {
        Key<Trailer> res = ofy().save().entity(trailer).now();
        return res;
    }

    public List<Trailer> readAllTrailers() {
        return ofy().load().type(Trailer.class).list();
    }

    public Trailer readTrailer(int lid) {
        return ofy().load().type(Trailer.class).id(lid).get();
    }
}
