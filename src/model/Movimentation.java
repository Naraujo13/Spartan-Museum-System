package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
abstract class Movimentation implements Comparable<Movimentation>{

    private Date timestamp;
    private String origin;
    private String cpfAutor;

    Movimentation(Date timestamp, String origin, String cpfAutor) {
        this.timestamp = timestamp;
        this.origin = origin;
        this.cpfAutor = cpfAutor;
    }

    @Override
    public int compareTo(Movimentation movimentation){
        return this.getTimestamp().compareTo(movimentation.getTimestamp());
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getOrigin() {
        return origin;
    }

}
