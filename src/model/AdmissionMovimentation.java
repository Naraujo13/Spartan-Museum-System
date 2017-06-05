package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
class AdmissionMovimentation extends MovimentationTo {
    AdmissionMovimentation(Date timestamp, String origin, String destination, String cpfAutor) {
        super(timestamp,  cpfAutor, origin, destination);
    }
}
