package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
abstract class Movimentation {

    private Date timestamp;
    private String origin;
    private String cpfAutor;

    public Movimentation(Date timestamp, String origin, String cpfAutor) {
        this.timestamp = timestamp;
        this.origin = origin;
        this.cpfAutor = cpfAutor;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getOrigin() {
        return origin;
    }

}
