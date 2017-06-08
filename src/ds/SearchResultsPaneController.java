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
    
}
