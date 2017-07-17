package model;

import java.sql.Timestamp;

/**
 * Created by naraujo on 29/05/17.
 */
public class SendToRestorationMovimentation extends MovimentationTo {

    private Timestamp dateOfReturn;
    private RestorationReport report;

     SendToRestorationMovimentation(Timestamp timestamp, Timestamp dateOfReturn, String origin, String destination, String cpfAutor) {
        super(timestamp, cpfAutor, origin, destination);
        this.dateOfReturn = dateOfReturn;
    }

    public RestorationReport getReport() {
        return report;
    }

    public void setReport(RestorationReport report) {
        this.report = report;
    }

    public Timestamp getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Timestamp dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
