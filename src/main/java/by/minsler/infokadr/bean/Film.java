package by.minsler.infokadr.bean;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

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

}
