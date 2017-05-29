package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public class Loan extends Movimentation {

    private String destination;
    private Date dateOfReturn;

    public Loan(Date timestamp, Date dateOfReturn, String origin, String destination, String cpfAutor) {
        super(timestamp, origin, cpfAutor);
        this.dateOfReturn = dateOfReturn;
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }
}
