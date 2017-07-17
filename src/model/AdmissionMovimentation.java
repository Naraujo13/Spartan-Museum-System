package model;

import java.sql.Timestamp;

/**
 * Created by naraujo on 29/05/17.
 */
public class AdmissionMovimentation extends MovimentationTo {
    AdmissionMovimentation(Timestamp timestamp, String origin, String destination, String cpfAutor) {
        super(timestamp,  cpfAutor, origin, destination);
    }
}
