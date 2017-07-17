package model;

import utils.Utils;

import java.lang.*;
import java.util.*;

/**
 * Created by naraujo on 29/05/17.
 */
public class Collection implements Comparable<Collection>{
    //Info
    private String name;
    private String collectionID;
    private String codMuseum;



    Collection(String name) {
        this.name = name;
    }

    Collection(String ID, String codMuseum, String name) {
        this.name = name;
        this.codMuseum = codMuseum;
        this.name = name;
    }

    @Override
    public int compareTo(Collection collection) {
        return this.getName().compareToIgnoreCase(collection.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

