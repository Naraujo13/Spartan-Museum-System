package model;


import utils.Utils;

import java.lang.*;
import java.sql.Date;
import java.util.TreeMap;

/**
 * Created by naraujo on 29/05/17.
 */
public class Item implements Comparable<Item>{

    private String ID;
    private String name;
    private int year;
    private String status;

    private TreeMap<Date, Movimentation> movimentationsTreeMap;


    Item(String ID, String name, int year, String origin, String destination) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.movimentationsTreeMap = new TreeMap<>();

        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new AdmissionMovimentation(new Date(java.lang.System.currentTimeMillis()), System.getActiveUser().getCpf(), origin, destination);
        movimentationsTreeMap.put(admission.getTimestamp(), admission);
        this.status = Utils.AT_STORAGE;

    }

    @Override
    public int compareTo(Item item) {
        return this.getName().compareToIgnoreCase(item.getName());
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

    int discharge(Date timestamp){
        //Testa se já foi dado baixa ou está indisponível
        if (!this.status.equals(Utils.AT_STORAGE))
            return Utils.FORBIDDEN_ERROR;

        //Realiza baixa
        Movimentation m = this.getMovimentationsTreeMap().lastEntry().getValue();
        if (m instanceof PutToStorageMovimentation) {
            Movimentation discharge = new DischargeMovimentation(
                    timestamp,
                    ((PutToStorageMovimentation) m).getDestination(),
                    System.getActiveUser().getCpf());
            addMovimentation(discharge);
            this.setStatus(Utils.DISCHARGED);
            return Utils.REQUEST_OK;
        }
        else  if (m instanceof AdmissionMovimentation) {
            Movimentation discharge = new DischargeMovimentation(
                    timestamp,
                    ((AdmissionMovimentation) m).getDestination(),
                    System.getActiveUser().getCpf());
            addMovimentation(discharge);
            this.setStatus(Utils.DISCHARGED);
            return Utils.REQUEST_OK;
        }
        else
            return Utils.FORBIDDEN_ERROR;
    }

    int putToExposition(Date timestamp, String destination){
        if (!this.status.equals(Utils.AT_STORAGE))
            return Utils.FORBIDDEN_ERROR;
        Movimentation m = this.getMovimentationsTreeMap().lastEntry().getValue();
        if (m instanceof PutToStorageMovimentation) {
            //Realiza envio para exposição
            Movimentation exposition = new PutToExpositionMovimentation(
                    timestamp,
                    ((PutToStorageMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(exposition);
            this.setStatus(Utils.AT_EXPOSITION);
            return Utils.REQUEST_OK;
        }
        else if (m instanceof AdmissionMovimentation) {
            //Realiza envio para exposição
            Movimentation exposition = new PutToExpositionMovimentation(
                    timestamp,
                    ((AdmissionMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(exposition);
            this.setStatus(Utils.AT_EXPOSITION);
            return Utils.REQUEST_OK;
        }
        else
            return Utils.FORBIDDEN_ERROR;
    }

    int putToStorage(Date timestamp, String destination){
        if (!this.status.equals(Utils.AT_STORAGE) && !this.status.equals(Utils.AT_EXPOSITION))
            return Utils.FORBIDDEN_ERROR;
        Movimentation m = this.getMovimentationsTreeMap().lastEntry().getValue();
        if (m instanceof PutToStorageMovimentation) {
            //Realiza envio para restauração
            Movimentation storage = new PutToStorageMovimentation(
                    timestamp,
                    ((PutToStorageMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(storage);
            this.setStatus(Utils.AT_STORAGE);
            return Utils.REQUEST_OK;
        }
        else if (m instanceof AdmissionMovimentation) {
            //Realiza envio para restauração
            Movimentation storage = new PutToStorageMovimentation(
                    timestamp,
                    ((AdmissionMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(storage);
            this.setStatus(Utils.AT_STORAGE);
            return Utils.REQUEST_OK;
        }
        else
            return Utils.FORBIDDEN_ERROR;
    }

    int returnFromLoan(Date timestamp, String destination){
        if (!this.status.equals(Utils.AT_LOAN))
            return Utils.FORBIDDEN_ERROR;
        Movimentation m = this.getMovimentationsTreeMap().lastEntry().getValue();
        if (m instanceof SendToLoanMovimentation) {
            //Recebe movimentação de retorno de empréstimo ou restauração
            Movimentation loan = new PutToStorageMovimentation(
                    timestamp,
                    ((SendToLoanMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(loan);
            this.setStatus(Utils.AT_STORAGE);
            return Utils.REQUEST_OK;
        }
        else
            return Utils.FORBIDDEN_ERROR;
    }

    int returnFromRestauration(Date timestamp, String destination){
        if (!this.status.equals(Utils.AT_RESTAURATION))
            return Utils.FORBIDDEN_ERROR;
        Movimentation m = this.getMovimentationsTreeMap().lastEntry().getValue();
        if (m instanceof SendToRestorationMovimentation) {
            //Recebe movimentação de retorno de empréstimo ou restauração
            Movimentation restauration = new PutToStorageMovimentation(
                    timestamp,
                    ((SendToRestorationMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(restauration);
            this.setStatus(Utils.AT_STORAGE);
            return Utils.REQUEST_OK;
        }
        else
            return Utils.FORBIDDEN_ERROR;
    }

    int sendToLoan(Date timestamp, Date dateOfReturn, String destination){
        //Testa status
        if (!this.status.equals(Utils.AT_STORAGE))
            return Utils.FORBIDDEN_ERROR;

        Movimentation m = this.getMovimentationsTreeMap().lastEntry().getValue();
        if (m instanceof PutToStorageMovimentation) {
            Movimentation loan = new SendToLoanMovimentation(
                    timestamp,
                    dateOfReturn,
                    ((PutToStorageMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(loan);
            this.setStatus(Utils.AT_LOAN);
            return Utils.REQUEST_OK;
        }
        else if (m instanceof AdmissionMovimentation) {
            Movimentation loan = new SendToLoanMovimentation(
                    timestamp,
                    dateOfReturn,
                    ((AdmissionMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(loan);
            this.setStatus(Utils.AT_LOAN);
            return Utils.REQUEST_OK;
        }
        else
            return Utils.FORBIDDEN_ERROR;
    }

    int sendToRestoration(Date timestamp, String destination){
        if (!this.status.equals(Utils.AT_STORAGE))
            return Utils.FORBIDDEN_ERROR;
        Movimentation m = this.getMovimentationsTreeMap().lastEntry().getValue();
        if (m instanceof PutToStorageMovimentation) {
            //Realiza envio para restauração
            Movimentation restoration = new SendToRestorationMovimentation(
                    timestamp,
                    ((PutToStorageMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(restoration);
            this.setStatus(Utils.AT_RESTAURATION);
            return Utils.REQUEST_OK;
        }
        else if (m instanceof AdmissionMovimentation) {
            //Realiza envio para restauração
            Movimentation restoration = new SendToRestorationMovimentation(
                    timestamp,
                    ((AdmissionMovimentation) m).getDestination(),
                    destination,
                    System.getActiveUser().getCpf());
            addMovimentation(restoration);
            this.setStatus(Utils.AT_RESTAURATION);
            return Utils.REQUEST_OK;
        }
        else
            return Utils.FORBIDDEN_ERROR;
    }

}