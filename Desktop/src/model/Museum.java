package model;

import utils.Utils;

import java.util.*;

/**
 * Created by naraujo on 01/06/17.
 */
public class Museum {

    /* -- Info -- */

    private String museumCode;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String openingHours;
    private String description;
    /* ---------- */

    /* -- Dados -- */
    //Diretor
    private Director director;


    /*-- Construtores -- */
    Museum(String museumCode, String name, String address) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
    }

    Museum(String museumCode, String name, String address, String phone) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    Museum(String museumCode, String name, String address, String phone, String email) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    Museum(String museumCode, String name, String address, String phone, String email, String openingHours) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.openingHours = openingHours;
    }

    Museum(String museumCode, String name, String address, String phone, String email, String openingHours, String description, Director director) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.openingHours = openingHours;
        this.description = description;
        this.director = director;
    }

    /* -- Getters and Setters -- */
    public String getMuseumCode() {
        return museumCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    void setDirector(Director director) {
        this.director = director;
    }


}