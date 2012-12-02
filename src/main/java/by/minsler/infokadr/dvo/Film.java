package by.minsler.infokadr.dvo;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 11/4/12
 * Time: 9:37 PM
 */
@Entity
@Cache
public class Film {

    @Id
    public Long id;

    public String engName;

    public String rusName;

    @Index
    public Date added;

    public List<String> trailers;

    public Film() {
        trailers = new ArrayList<String>();
    }

    public void addTrailer(String trailerKey) {
        trailers.add(trailerKey);
    }
}
