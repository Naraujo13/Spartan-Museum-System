package model;

import java.sql.Timestamp;

/**
 * Created by naraujo on 29/05/17.
 */
public class SendToRestorationMovimentation extends MovimentationTo {

    private Timestamp dateOfReturn;
    private RestorationReport report;
    private String damage;
    private String restorer;
    private String repair;

     SendToRestorationMovimentation(Timestamp timestamp, Timestamp dateOfReturn, String origin, String destination, String cpfAutor, String damage, String restorer, String repair) {
        super(timestamp, cpfAutor, origin, destination);
        this.dateOfReturn = dateOfReturn;
        this.damage = damage;
        this.restorer = restorer;
        this.repair = repair;
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

    public String getRepair() {
        return repair;
    }

    public String getDamage() {
        return damage;
    }

    public String getRestorer() {
        return restorer;
    }
}
