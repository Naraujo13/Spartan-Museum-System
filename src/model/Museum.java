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

    //Coleções
    private TreeMap<String, Collection> collectionsTreeMap; /* -- TreeMap  nome->Coleção -- */
    /* ---------- */

    /*-- Construtores -- */
    Museum(String museumCode, String name, String address) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.collectionsTreeMap = new TreeMap<>();
    }

    Museum(String museumCode, String name, String address, String phone) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.collectionsTreeMap = new TreeMap<>();
    }

    Museum(String museumCode, String name, String address, String phone, String email) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.collectionsTreeMap = new TreeMap<>();
    }

    Museum(String museumCode, String name, String address, String phone, String email, String openingHours) {
        this.museumCode = museumCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.openingHours = openingHours;
        this.collectionsTreeMap = new TreeMap<>();
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
        this.collectionsTreeMap = new TreeMap<>();
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

    public TreeMap<String, Collection> getCollectionsTreeMap() {
        return collectionsTreeMap;
    }

    /* -- Inserção -- */
    int addCollection(String name){
         //Testa se já existe coleção com este nome
        if (!System.getMuseum().getCollectionByName(name).isEmpty())
            return Utils.ALREADY_EXISTS_ERROR;

        //Insere coleção
        Collection collection = new Collection(name);
        this.collectionsTreeMap.put(collection.getName(), collection);

        return Utils.REQUEST_OK;
    }

    /* -- Pesquisa -- */
    /**
     * Pesquisa Coleção por nome
     * @param search - parametro de busca
     * @return - Retorna array com coleções que contém parametro de busca no nome
     */
    ArrayList<Collection> getCollectionByName(String search){
        return new ArrayList<>(searchByPrefix(collectionsTreeMap, search).values());
    }

    private SortedMap<String, Collection> searchByPrefix(SortedMap<String, Collection> baseMap, String prefix) {
        if(prefix.length() > 0) {
            char nextLetter = (char) (prefix.charAt(prefix.length() -1) + 1);
            String end = prefix.substring(0, prefix.length()-1) + nextLetter;
            return baseMap.subMap(prefix, end);
        }
        return baseMap;
    }



}