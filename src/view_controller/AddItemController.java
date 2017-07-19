/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Collection;
import model.DatabaseHelper;

import javax.xml.crypto.Data;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class AddItemController implements Initializable {



    model.Item item;
    
    @FXML
    private  TextField ItemName;
    @FXML
    private  TextField ItemID;
    @FXML
    private  TextField ItemYear;
    @FXML
    private  TextField ItemStatus;
    @FXML
    private  TextField ItemHeight;
    @FXML
    private  TextField ItemWidth;
    @FXML
    private  TextField ItemWeight;
    @FXML
    private  TextField Itemthickness;
    @FXML
    private  TextField ItemAuthor;
    @FXML
    private  TextField ItemDate;
    @FXML
    private  TextField ItemDescription;
    @FXML
    private  TextField ItemInnerCircumference;
    @FXML
    private  TextField ItemOutnerCircumference;
    @FXML
    private TextField Deph;
    @FXML
    private Button SaveItem;
    @FXML
    private AnchorPane AddItemPane;
    @FXML
    private ChoiceBox Collections;
    @FXML
    private TextField ItemOrigin;
    @FXML
    private TextField Destination;
    @FXML
    public TextField ItemConservationState;
    @FXML
    public TextField ItemBiography;
    @FXML
    public TextField ItemAquisitionDate;
    @FXML
    public TextField ItemHistoricalContext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<String> collectionNames = DatabaseHelper.getCollectionNames();
        if (collectionNames.isEmpty())
            System.out.println("Array de nomes vazio");

//        collectionNames = new ArrayList<>(DatabaseHelper.searchCollectionByName("").stream()
//                .map(obj -> obj.getName())
//                .collect(Collectors.toList()));


        ObservableList<String> list = FXCollections.observableArrayList(collectionNames);
        Collections.setItems(list);
        
        
        SaveItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               
               DatabaseHelper.addItem(
                       ItemID.getText(),
                       (String) Collections.getValue(),
                       ItemName.getText(),
                       ItemYear.getText(),
                       ItemStatus.getText(),
                       Itemthickness.getText(),
                       ItemOutnerCircumference.getText(),
                       ItemInnerCircumference.getText(),
                       ItemWeight.getText(),
                       ItemAuthor.getText(),
                       ItemConservationState.getText(),
                       ItemBiography.getText(),
                       ItemDescription.getText(),
                       ItemAquisitionDate.getText(),
                       ItemHeight.getText(),
                       ItemWidth.getText(),
                       ItemHistoricalContext.getText()

                       );

                       Stage stage = (Stage) SaveItem.getScene().getWindow();
                        stage.close();
               
            }

        }
        
        );
        
    }    
    
    @FXML
    public void setItem(model.Item item){
        this.item=item;
    }
}
