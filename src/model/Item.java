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
    //Measures
    private float lenght;
    private float height;
    private float width;
    private float thickness;
    private float depth;
    private float outerCircumference;
    private float innerCircumference;
    private float weight;
    //Extra info
    private String author;
    private String conservationState;
    private String historicalContext;
    private String biography;
    private String description;
    private java.sql.Date aquisitionDate;

    private TreeMap<Date, Movimentation> movimentationsTreeMap;


    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, java.sql.Date aquisitionDate) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.movimentationsTreeMap = new TreeMap<>();
        this.lenght = lenght;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.aquisitionDate = aquisitionDate;
        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new AdmissionMovimentation(new Date(java.lang.System.currentTimeMillis()), System.getActiveUser().getCpf(), origin, destination);
        movimentationsTreeMap.put(admission.getTimestamp(), admission);
        this.status = Utils.AT_STORAGE;

    }
    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, float thickness, String description, String author, java.sql.Date aquisitionDate) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.movimentationsTreeMap = new TreeMap<>();
        this.lenght = lenght;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.description = description;
        this.author = author;
        this.aquisitionDate = aquisitionDate;
        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new AdmissionMovimentation(new Date(java.lang.System.currentTimeMillis()), System.getActiveUser().getCpf(), origin, destination);
        movimentationsTreeMap.put(admission.getTimestamp(), admission);
        this.status = Utils.AT_STORAGE;

    }
    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, float thickness, String description, float outerCircumference, float innerCircumference, float depth, String conservationState, String author, String historicalContext, java.sql.Date aquisitionDate) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.movimentationsTreeMap = new TreeMap<>();
        this.lenght = lenght;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.description = description;
        this.author = author;
        this.innerCircumference = innerCircumference;
        this.outerCircumference = outerCircumference;
        this.depth = depth;
        this.aquisitionDate = aquisitionDate;
        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new AdmissionMovimentation(new Date(java.lang.System.currentTimeMillis()), System.getActiveUser().getCpf(), origin, destination);
        movimentationsTreeMap.put(admission.getTimestamp(), admission);
        this.status = Utils.AT_STORAGE;

    }

    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, float thickness, String description, String author, float outerCircumference, float innerCircumference, float depth) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.movimentationsTreeMap = new TreeMap<>();
        this.lenght = lenght;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.description = description;
        this.author = author;
        this.innerCircumference = innerCircumference;
        this.outerCircumference = outerCircumference;
        this.depth = depth;
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

    public float getLenght() {
        return lenght;
    }

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getOuterCircumference() {
        return outerCircumference;
    }

    public void setOuterCircumference(float outerCircumference) {
        this.outerCircumference = outerCircumference;
    }

    public float getInnerCircumference() {
        return innerCircumference;
    }

    public void setInnerCircumference(float innerCircumference) {
        this.innerCircumference = innerCircumference;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getConservationState() {
        return conservationState;
    }

    public void setConservationState(String conservationState) {
        this.conservationState = conservationState;
    }

    public String getHistoricalContext() {
        return historicalContext;
    }

    public void setHistoricalContext(String historicalContext) {
        this.historicalContext = historicalContext;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAquisitionDate() {
        return aquisitionDate;
    }

    public void setAquisitionDate(Date aquisitionDate) {
        this.aquisitionDate = aquisitionDate;
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