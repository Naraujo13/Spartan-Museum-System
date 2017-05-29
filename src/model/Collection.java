package model;

import java.util.HashMap;

/**
 * Created by naraujo on 29/05/17.
 */
public class Collection {

    private String name;
    private HashMap<String, Item> items;

    public Collection(String name) {
        this.name = name;
        this.items = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Item item){
        this.items.put(item.getID(), item);
    }
}
