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

    //Dados
    private HashMap<String, Item> items; /* -- Tree Map com ID->Item -- */
    private TreeMap<String, String> nameToID; /* -- Hash Map com Nome->ID -- */
    private TreeMap<String, String> statusToID; /* -- Hash Map com Status->ID -- */


    Collection(String name) {
        this.name = name;
        this.items = new HashMap<>();
        this.nameToID = new TreeMap<>();
        this.statusToID = new TreeMap<>();
    }

    Collection(String ID, String codMuseum, String name) {
        this.name = name;
        this.codMuseum = codMuseum;
        this.name = name;
        this.items = new HashMap<>();
        this.nameToID = new TreeMap<>();
        this.statusToID = new TreeMap<>();
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

    public HashMap<String, Item> getItems() {
        return items;
    }

    public TreeMap<String, String> getNameToID() {
        return nameToID;
    }

    public TreeMap<String, String> getStatusToID() {
        return statusToID;
    }

    /**
     * Adiciona Item à coleção
     * @param museumCode - código do museu
     * @param name - nome do item
     * @param year - ano do item
     * @param origin - origem do item
     * @param weight - peso do item
     * @param lenght - comprimento do item
     * @param width - largura do item
     * @param height - altura do item
     * @param aquisitionDate - data de aquisição
     * @return - true || false representando sucesso || fracasso na inserção
     */

    int addItem(String museumCode, String name, int year, String origin, String destination,
                float weight, float lenght, float width, float height, java.sql.Date aquisitionDate){

        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(DatabaseHelper.getTechniciansTreeMap().containsKey(DatabaseHelper.getActiveUser().getCpf())
                || DatabaseHelper.getDirectorsTreeMap().containsKey(DatabaseHelper.getActiveUser().getCpf())
                || DatabaseHelper.getCoordinator().getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return Utils.NOT_FOUND_ERROR;

        /* -- Cria novo item -- */
        Item item = new Item(museumCode + items.size(), name, year, origin, destination, weight, lenght, width, height, aquisitionDate);

        /* -- Adiciona item nas estruturas -- */
        this.items.put(item.getID(), item);
        this.nameToID.put(item.getName(), item.getID());
        this.statusToID.put(item.getStatus(), item.getID());

        return Utils.REQUEST_OK;
    }

    /**
     * Pesquisa Item por nome
     * @param search - parametro de busca
     * @return - Retorna array com items que contém parametro de busca no nome
     */
    ArrayList <Item> getItemsByName(String search){

        SortedMap<String, String> results = Utils.searchByPrefix(nameToID, search);
        ArrayList<Item> final_results = new ArrayList<>();

        for (String id : results.values()){
            final_results.add(this.items.get(id));
        }
        return final_results;
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

