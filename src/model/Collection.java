package model;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by naraujo on 29/05/17.
 */
public class Collection {
    //Info
    private String name;

    //Dados
    private TreeMap<String, Item> items; /* -- Tree Map com ID->Item -- */
    private HashMap<String, String> nameToID; /* -- Hash Map com Nome->ID -- */
    private HashMap<String, String> statusToID; /* -- Hash Map com Status->ID -- */


    public Collection(String name) {
        this.name = name;
        this.items = new TreeMap<>();
        this.nameToID = new HashMap<>();
        this.statusToID = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Item item){
        this.items.put(item.getID(), item);
        this.nameToID.put(item.getName(), item.getID());
        this.statusToID.put(item.getStatus(), item.getID());
    }

    public void removeItem(String IDItem) {
        items.remove(IDItem);
    }

}
