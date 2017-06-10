package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public abstract class Movimentation implements Comparable<Movimentation>{
    private String origin;
    private Date timestamp;
    private String cpfAutor;

    Movimentation(Date timestamp, String cpfAutor, String origin) {
        this.timestamp = timestamp;
        this.cpfAutor = cpfAutor;
        this.origin = origin;
    }

    @Override
    public int compareTo(Movimentation movimentation){
        return this.getTimestamp().compareTo(movimentation.getTimestamp());
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getCpfAutor() {
        return cpfAutor;
    }

    public String getOrigin() {
        return origin;
    }
}
