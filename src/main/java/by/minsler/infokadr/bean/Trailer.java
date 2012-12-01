package by.minsler.infokadr.bean;

import com.google.appengine.api.datastore.Link;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.*;

import java.util.Date;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 2:21 AM
 */
@Entity
@Cache
public class Trailer {

    @Id
    public Long id;

    public String description;

    public String shortName;

    @Parent
    public Key film;

    public Link youtubeUrl;

    @Index
    public Date added;

}
