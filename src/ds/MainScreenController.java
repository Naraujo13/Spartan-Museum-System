/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.awt.event.MouseEvent;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Usuário
 */
public class MainScreenController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane MainScreen;

    @FXML
    private ListView ListViewCollections;
    
    @FXML
    private TextField SearchArea;
    
    @FXML
    private RadioButton SearchByID;
    
    @FXML
    private RadioButton SearchByName;
    
    @FXML
    private RadioButton SearchByCollection;
    
    @FXML
    private RadioButton SearchByStatus;
    
    
    
    @FXML
    private void handleLogoutAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handleHomeAction(ActionEvent event) {
        if(MainScreen.getChildren().size() > 7)
            MainScreen.getChildren().remove(MainScreen.getChildren().size()-1);
        try {
            MainScreen.getChildren().add(FXMLLoader.load(getClass().getResource("MuseumPane.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleSearchAction(ActionEvent event) {
        SearchResultsPaneController controller = null;
        
        if(MainScreen.getChildren().size() > 7)
                MainScreen.getChildren().remove(MainScreen.getChildren().size()-1);
            //SearchResultsPaneController controller;
            FXMLLoader fxmlLoader = new FXMLLoader();
            
            try {
                
                Pane p = fxmlLoader.load(getClass().getResource("SearchResultsPane.fxml").openStream());
                MainScreen.getChildren().add(p);
                controller = (SearchResultsPaneController) fxmlLoader.getController();
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            if(SearchByID.isSelected()){
                controller.showIDSearch(SearchArea.getText());
                
            }
            if(SearchByName.isSelected()){
                controller.showNameSearch(SearchArea.getText());
                
            }
            if(SearchByCollection.isSelected()){
                controller.showCollectionSearch(SearchArea.getText());
                
            }
            if(SearchByStatus.isSelected()){
                controller.showStatusSearch(SearchArea.getText());
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(MainScreen.getChildren().size() > 7)
            MainScreen.getChildren().remove(MainScreen.getChildren().size()-1);
        try {
            MainScreen.getChildren().add(FXMLLoader.load(getClass().getResource("MuseumPane.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList elements = FXCollections.observableArrayList();
        ArrayList<model.Collection> collections = new ArrayList<>(model.System.getMuseum().getCollectionsTreeMap().values());
        for(model.Collection collection : collections){
            elements.add(collection.getName());
        }
        ListViewCollections.setItems(elements);
        ListViewCollections.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            //System.out.println("ListView selection changed from oldValue = " 
               // + oldValue + " to newValue = " + newValue);
            ArrayList<model.Collection> selectedCollection = new ArrayList<>(model.System.searchCollectionByName(newValue));
            System.out.println("Selecionado: " + selectedCollection.get(0).getName());
            if(MainScreen.getChildren().size() > 7)
                MainScreen.getChildren().remove(MainScreen.getChildren().size()-1);
            //SearchResultsPaneController controller;
            FXMLLoader fxmlLoader = new FXMLLoader();
            try {
                
                Pane p = fxmlLoader.load(getClass().getResource("SearchResultsPane.fxml").openStream());
                MainScreen.getChildren().add(p);
                SearchResultsPaneController controller = (SearchResultsPaneController) fxmlLoader.getController();
                controller.showCollection(selectedCollection.get(0));
                
            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        
    }    
  
}
