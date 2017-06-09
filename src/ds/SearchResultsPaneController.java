/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    
    @FXML
    private Pane SearchResultsPane;
    
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
        //FXMLLoader fxmlLoader;
        
        ObservableList elements = FXCollections.observableArrayList();
        ArrayList<model.Item> itens = new ArrayList<>(collection.getItems().values());
        
        for(model.Item item : itens){
        elements.add(item.getID()+ " - " + item.getName());
        }
        SearchResultsListView.setItems(elements); 
        MuseumNameLabel.setText("Obras Coleção " + collection.getName());
        SearchResultsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            System.out.println("ListView selection changed from oldValue = " 
                + oldValue + " to newValue = " + newValue);
            model.Item itemClicked=null;
            for(model.Item item : itens){
                if(newValue.equals(item.getID()+ " - " + item.getName())){
                    itemClicked=item;
                }
            }
          
            if(SearchResultsPane.getChildren().size() > 7)
                SearchResultsPane.getChildren().remove(SearchResultsPane.getChildren().size()-1);

            try {
                
               // Pane p2 = fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Item.fxml"));
                //fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                ItemController itemController = new ItemController();
                fxmlLoader.setController(itemController);

                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                itemController.showItem(itemClicked);
  
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        });
        
       
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
            SearchResultsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = " 
                    + oldValue + " to newValue = " + newValue);
                model.Item itemClicked=null;
                for(model.Item item : itens){
                    if(newValue.equals(item.getID() + " - " + item.getName() + " - " + item.getStatus())){
                        itemClicked=item;
                    }
                }

                if(SearchResultsPane.getChildren().size() > 7)
                    SearchResultsPane.getChildren().remove(SearchResultsPane.getChildren().size()-1);

                try {

                   // Pane p2 = fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Item.fxml"));
                    //fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                    ItemController itemController = new ItemController();
                    fxmlLoader.setController(itemController);

                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));  
                    stage.show();
                    itemController.showItem(itemClicked);

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            });
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
        ArrayList<model.Item> itens = null;
        ObservableList elements = FXCollections.observableArrayList();
        if(itens!=null){
            for(model.Item item : itens){
                if(item!=null)
                    elements.add(item.getID() + " - " + item.getName() + " - " + item.getStatus());
            }
        }
        if(itens==null || itens.size()==0){
            elements.add("TIPO DE PESQUISA INDISPONÍVEL NO MOMENTO...");
        }
        else{
            //código para ouvir o clique em alguma peça
        }
        
        
        SearchResultsListView.setItems(elements);
        MuseumNameLabel.setText("Peças: ");
       
    }
}

