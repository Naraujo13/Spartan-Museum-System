package model;

import utils.Utils;

import java.lang.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by naraujo on 29/05/17.
 */
class Collection {
    //Info
    private String name;

    //Dados
    private TreeMap<String, Item> items; /* -- Tree Map com ID->Item -- */
    private HashMap<String, String> nameToID; /* -- Hash Map com Nome->ID -- */
    private HashMap<String, String> statusToID; /* -- Hash Map com Status->ID -- */


    Collection(String name) {
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

    public TreeMap<String, Item> getItems() {
        return items;
    }

    public HashMap<String, String> getNameToID() {
        return nameToID;
    }

    public HashMap<String, String> getStatusToID() {
        return statusToID;
    }

    /**
     * Adiciona Item à coleção
     * @param museumCode - código do museu
     * @param name - nome do item
     * @param year - ano do item
     * @param origin - origem do item
     * @return - true || false representando sucesso || fracasso na inserção
     */
    int addItem(String museumCode, String name, int year, String origin){

        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(System.getTechniciansTreeMap().containsKey(System.getActiveUser().getCpf())
                || System.getDirectorsTreeMap().containsKey(System.getActiveUser().getCpf())
                || System.getCoordinator().getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.NOT_FOUND_ERROR;

        /* -- Cria novo item -- */
        Item item = new Item(museumCode + items.size(), name, year, origin);

        /* -- Adiciona item nas estruturas -- */
        this.items.put(item.getID(), item);
        this.nameToID.put(item.getName(), item.getID());
        this.statusToID.put(item.getStatus(), item.getID());

        return Utils.REQUEST_OK;
    }

    /**
     * Pesquisa Item por nome
     * @param name - nome do item desejado
     * @return - Retorna item desejado ou null
     */
    Item getItemsByName(String name){
        return this.items.get(this.nameToID.get(name));
    }

    /**
     * Pesquisa item por ID
     * @param ID - ID do item desejado
     * @return - Retorna Item encontrado ou null
     */
    Item getItemsByID(String ID){
        return this.items.get(ID);
    }

}

