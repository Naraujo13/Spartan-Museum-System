package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public class Storage extends Movimentation {

    private String destination;

    public Storage(Date timestamp, String origin, String destination, String cpfAutor) {
        super(timestamp, origin, cpfAutor);
        this.destination = destination;
    }
}
