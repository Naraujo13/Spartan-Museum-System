package model;

import java.sql.Timestamp;

/**
 * Created by naraujo on 29/05/17.
 */
public class SendToLoanMovimentation extends MovimentationTo {
    private Timestamp dateOfReturn;

    SendToLoanMovimentation(Timestamp timestamp, Timestamp dateOfReturn, String origin, String destination, String cpfAutor) {
        super(timestamp, cpfAutor, origin, destination);
        this.dateOfReturn = dateOfReturn;
    }

    public Timestamp getDateOfReturn() {
        return dateOfReturn;
    }
}
