package model;

/**
 * Created by naraujo on 29/05/17.
 */
public class RestorationReport {
    private String damage;
    private String restorer;
    private String observations;

    public RestorationReport(String damage, String restorer, String observations) {
        this.damage = damage;
        this.restorer = restorer;
        this.observations = observations;
    }

    public String getDamage() {
        return damage;
    }

    public String getRestorer() {
        return restorer;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
