package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public class SendToLoanMovimentation extends MovimentationTo {
    private Date dateOfReturn;

    SendToLoanMovimentation(Date timestamp, Date dateOfReturn, String origin, String destination, String cpfAutor) {
        super(timestamp, cpfAutor, origin, destination);
        this.dateOfReturn = dateOfReturn;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }
}
