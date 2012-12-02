package by.minsler.infokadr.dvo;

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

    public String name;

    public String shortName;

    public String description;

    public String url;

    @Parent
    public Key film;

    @Index
    public Date added;

}
