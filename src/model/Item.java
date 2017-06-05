package model;


import utils.Utils;

import java.lang.*;
import java.sql.Date;
import java.util.TreeMap;
import model.System;

import javax.rmi.CORBA.Util;

/**
 * Created by naraujo on 29/05/17.
 */
public class Item {

    private String ID;
    private String name;
    private int year;
    private String status;

    private TreeMap<Date, Movimentation> movimentationsTreeMap;


    Item(String ID, String name, int year, String origin) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.status = Utils.AT_STORAGE;
        this.movimentationsTreeMap = new TreeMap<>();

        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new Admission(new Date(java.lang.System.currentTimeMillis()), origin, System.getActiveUser().getCpf());
        movimentationsTreeMap.put(admission.getTimestamp(), admission);

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

    private void setStatus(String status) {
        this.status = status;
    }

    public TreeMap<Date, Movimentation> getMovimentationsTreeMap() {
        return movimentationsTreeMap;
    }

    /* -- Movimentation -- */

    private void addMovimentation(Movimentation m){
        movimentationsTreeMap.put(m.getTimestamp(), m);
    }

    int discharge(Date timestamp, String origin){
        //Testa se já foi dado baixa ou está indisponível
        if (this.status.equals(Utils.DISCHARGED) || this.status.equals(Utils.AT_RESTAURATION) || this.status.equals(Utils.AT_LOAN))
            return Utils.FORBIDDEN_ERROR;

        //Realiza baixa
        Movimentation discharge = new Discharge(timestamp, origin, System.getActiveUser().getCpf());
        addMovimentation(discharge);
        this.setStatus(Utils.DISCHARGED);
        return Utils.REQUEST_OK;
    }

    int loan(Date timestamp, Date dateOfReturn, String origin, String destination){
        //Testa status
        if (this.status.equals(Utils.DISCHARGED) || this.status.equals(Utils.AT_RESTAURATION) || this.status.equals(Utils.AT_LOAN))
            return Utils.FORBIDDEN_ERROR;

        Movimentation loan = new Loan(timestamp, dateOfReturn, origin, destination, System.getActiveUser().getCpf());
        addMovimentation(loan);
        this.setStatus(Utils.AT_LOAN);
        return Utils.REQUEST_OK;
    }

    int restoration(Date timestamp, String origin, String destination){
        if (this.status.equals(Utils.DISCHARGED) || this.status.equals(Utils.AT_RESTAURATION) || this.status.equals(Utils.AT_LOAN))
            return Utils.FORBIDDEN_ERROR;

        //Realiza envio para restauração
        Movimentation restoration = new Restoration(timestamp, origin, destination, System.getActiveUser().getCpf());
        addMovimentation(restoration);
        this.setStatus(Utils.AT_RESTAURATION);
        return Utils.REQUEST_OK;
    }

    int storage(Date timestamp, String origin, String destination){
        if (this.status.equals(Utils.DISCHARGED) || this.status.equals(Utils.AT_RESTAURATION) || this.status.equals(Utils.AT_LOAN))
            return Utils.FORBIDDEN_ERROR;

        //Realiza envio para restauração
        Movimentation storage = new Storage(timestamp, origin, destination, System.getActiveUser().getCpf());
        addMovimentation(storage);
        this.setStatus(Utils.AT_STORAGE);
        return Utils.REQUEST_OK;
    }

}