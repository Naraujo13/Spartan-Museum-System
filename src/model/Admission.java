package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public class Admission extends Movimentation {
    public Admission(Date timestamp, String from, String cpfAutor) {
        super(timestamp, from, cpfAutor);
    }
}
