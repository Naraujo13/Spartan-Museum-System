package model;

import java.sql.Date;

/**
 * Created by naraujo on 29/05/17.
 */
public class Restoration extends Movimentation {

    private String destination;
    private RestorationReport report;

    public Restoration(Date timestamp, String origin, String destination, String cpfAutor) {
        super(timestamp, origin, cpfAutor);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public RestorationReport getReport() {
        return report;
    }

    public void setReport(RestorationReport report) {
        this.report = report;
    }
}
