package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public class Discharge extends Movimentation {

    public Discharge(Date timestamp, String origin, String cpfAutor) {
        super(timestamp, origin, cpfAutor);
    }
}
