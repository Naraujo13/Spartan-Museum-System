package model;

import java.sql.Date;

/**
 * Created by naraujo on 05/06/17.
 */
public class MovimentationTo extends Movimentation{
    private String destination;
    MovimentationTo(Date timestamp, String cpfAutor, String origin, String destination) {
        super(timestamp, cpfAutor, origin);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }
}
