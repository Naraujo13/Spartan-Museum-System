package model;


import java.util.Date;
import java.util.TreeMap;

/**
 * Created by naraujo on 29/05/17.
 */
public class Item {

    private String ID;
    private String name;
    private int year;
    private String status;

    private TreeMap<Date, Movimentation> movimentationsTreeMap;


    public Item(String ID, String name, int year) {
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.movimentationsTreeMap = new TreeMap<>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TreeMap<Date, Movimentation> getMovimentationsTreeMap() {
        return movimentationsTreeMap;
    }

    public void addMovimentation(Movimentation m){
        movimentationsTreeMap.put(m.getTimestamp(), m);
    }
}

/*
if (m instanceof  Storage){

        }
        else if (m instanceof Loan){

        }
        else if (m instanceof  Restoration){

        }
        else if (m instanceof Admission){

        }
        else if (m instanceof Discharge){

        }
        
 */