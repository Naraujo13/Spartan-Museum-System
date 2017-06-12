package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public class SendToRestorationMovimentation extends MovimentationTo {

    private RestorationReport report;

     SendToRestorationMovimentation(Date timestamp, String origin, String destination, String cpfAutor) {
        super(timestamp, cpfAutor, origin, destination);
    }

    public RestorationReport getReport() {
        return report;
    }

    public void setReport(RestorationReport report) {
        this.report = report;
    }
}
