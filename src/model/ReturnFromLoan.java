package model;

import java.sql.Date;

/**
 * Created by naraujo on 05/06/17.
 */
public class ReturnFromLoan extends MovimentationTo {
    ReturnFromLoan(Date timestamp, String cpfAutor, String origin, String destination) {
        super(timestamp, cpfAutor, origin, destination);
    }
}
