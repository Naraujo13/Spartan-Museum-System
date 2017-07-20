package model;


import utils.Utils;

import java.lang.*;
import java.sql.Date;
import java.sql.Timestamp;
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
    private String aquisitionDate;
    private float outerCircumference;
    private float innerCircumference;
    private float weight;
    //Extra info
    private String author;
    private String conservationState;
    private String historicalContext;
    private String biography;
    private String description;



    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, String aquisitionDate) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.lenght = lenght;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.aquisitionDate = aquisitionDate;
        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new AdmissionMovimentation(new Timestamp(java.lang.System.currentTimeMillis()), DatabaseHelper.getActiveUser().getCpf(), origin, destination);
        this.status = Utils.AT_STORAGE;

    }
    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, float thickness, String description, String author, String aquisitionDate) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.lenght = lenght;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.description = description;
        this.author = author;
        this.aquisitionDate = aquisitionDate;
        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new AdmissionMovimentation(new Timestamp(java.lang.System.currentTimeMillis()), DatabaseHelper.getActiveUser().getCpf(), origin, destination);
        this.status = Utils.AT_STORAGE;

    }
    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, float thickness, String description, float outerCircumference, float innerCircumference, float depth, String conservationState, String author, String historicalContext, String aquisitionDate) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
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
        Movimentation admission = new AdmissionMovimentation(new Timestamp(java.lang.System.currentTimeMillis()), DatabaseHelper.getActiveUser().getCpf(), origin, destination);
        this.status = Utils.AT_STORAGE;

    }

    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, float thickness, String description, String author, float outerCircumference, float innerCircumference, float depth) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
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
        Movimentation admission = new AdmissionMovimentation(new Timestamp(java.lang.System.currentTimeMillis()), DatabaseHelper.getActiveUser().getCpf(), origin, destination);
        this.status = Utils.AT_STORAGE;

    }

    Item(String ID, String name, int year, String origin, String destination, float weight, float lenght, float width, float height, float thickness, String description, String author, float outerCircumference, float innerCircumference, String aquisitionDate, String status) {

        /* -- Cria item --  */
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.lenght = lenght;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.description = description;
        this.author = author;
        this.innerCircumference = innerCircumference;
        this.outerCircumference = outerCircumference;
        this.aquisitionDate = aquisitionDate;
        /* -- Cria Movimentação de entrada -- */
        Movimentation admission = new AdmissionMovimentation(new Timestamp(java.lang.System.currentTimeMillis()), DatabaseHelper.getActiveUser().getCpf(), origin, destination);
        this.status = status;
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

    public void setStatus(String status) {
        this.status = status;
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

    public String getAquisitionDate() {
        return aquisitionDate;
    }

    public void setAquisitionDate(String aquisitionDate) {
        this.aquisitionDate = aquisitionDate;
    }

}