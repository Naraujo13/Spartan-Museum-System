/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class SearchResultsPaneController implements Initializable {
    
    @FXML
    private ListView SearchResultsListView;
    
    @FXML
    private Label MuseumNameLabel;
    
    static private model.Collection collection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    public void showCollection(model.Collection collection){
        this.collection=collection;
        
       System.out.println("Setei " + collection.getName());
       ObservableList elements = FXCollections.observableArrayList();
       ArrayList<model.Item> itens = new ArrayList<>(collection.getItems().values());
        
        for(model.Item item : itens){
        elements.add(item.getID()+ " - " + item.getName());
        }
        SearchResultsListView.setItems(elements);
       MuseumNameLabel.setText("Obras Coleção " + collection.getName());
       
    }
    
    @FXML
    public void showCollectionSearch(String search){
        
        ArrayList<model.Collection> collections = model.System.searchCollectionByName(search);
        ObservableList elements = FXCollections.observableArrayList();
        for(model.Collection collection : collections){
            elements.add(collection.getName());
        }
        if(collections.size()==0){
            elements.add("Nenhuma coleção encontrada...");
        }
        else{
            //código para ouvir o clique em alguma coleção
        }
        
        
        SearchResultsListView.setItems(elements);
        MuseumNameLabel.setText("Coleções: ");
       
    }
    
    @FXML
    public void showIDSearch(String search){
        
        ArrayList<model.Item> itens = model.System.searchItemByID(search);
        ObservableList elements = FXCollections.observableArrayList();
        if(itens!=null){
            for(model.Item item : itens){
                if(item!=null)
                    elements.add(item.getID() + " - " + item.getName() + " - " + item.getStatus());
                
            }
        }
        if(itens.size()==0){
            elements.add("Nenhuma peça encontrada para este ID...");
        }
        else{
            //código para ouvir o clique em alguma peça
        }
        
        
        SearchResultsListView.setItems(elements);
        MuseumNameLabel.setText("Peças: ");
       
    }
    
    @FXML
    public void showNameSearch(String search){
        ArrayList<model.Item> itens = model.System.searchItemByName(search);
        ObservableList elements = FXCollections.observableArrayList();
        if(itens!=null){
            for(model.Item item : itens){
                if(item!=null)
                    elements.add(item.getID() + " - " + item.getName() + " - " + item.getStatus());
            }
        }
        if(itens.size()==0){
            elements.add("Nenhuma peça encontrada para este nome...");
        }
        else{
            //código para ouvir o clique em alguma peça
        }
        
        
        SearchResultsListView.setItems(elements);
        MuseumNameLabel.setText("Peças: ");
       
    }
    
    @FXML
    public void showStatusSearch(String search){
        this.collection=collection;
        
       System.out.println("Setei " + collection.getName());
       ObservableList elements = FXCollections.observableArrayList();
       ArrayList<model.Item> itens = new ArrayList<>(collection.getItems().values());
        
        for(model.Item item : itens){
        elements.add(item.getID()+ " - " + item.getName());
        }
        SearchResultsListView.setItems(elements);
       MuseumNameLabel.setText("Obras Coleção " + collection.getName());
       
    }
}
