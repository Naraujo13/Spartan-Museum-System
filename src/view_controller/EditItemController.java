/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import model.DatabaseHelper;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class EditItemController implements Initializable {
        
    private model.Item item;

    @FXML
    private  TextField ItemName;
    @FXML
    private  TextField ItemID;
    @FXML
    private  TextField ItemYear;
    @FXML
    private  TextField ItemLenght;
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
    private  TextField ItemDescription;
    @FXML
    private  TextField ItemInnerCircumference;
    @FXML
    private  TextField ItemOutnerCircumference;
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
                        ItemLenght.getText(),
                        ItemHeight.getText(),
                        ItemWidth.getText(),
                        Itemthickness.getText(),
                        ItemOutnerCircumference.getText(),
                        ItemInnerCircumference.getText(),
                        ItemWeight.getText(),
                        ItemAuthor.getText(),
                        ItemConservationState.getText(),
                        ItemBiography.getText(),
                        ItemDescription.getText(),
                        ItemHistoricalContext.getText(),
                        ItemAquisitionDate.getText(),
                        ItemOrigin.getText(),
                        Destination.getText()
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

        if (item != null) {
            ItemID.setText(item.getID());
            ItemName.setText(item.getName());
            ItemYear.setText(Integer.toString(item.getYear()));
            ItemLenght.setText(Float.toString(item.getLenght()));
            ItemHeight.setText(Float.toString(item.getHeight()));
            ItemWidth.setText(Float.toString(item.getWidth()));
            ItemWeight.setText(Float.toString(item.getWeight()));
            ItemWidth.setText(Float.toString(item.getWidth()));
            Itemthickness.setText(Float.toString(item.getThickness()));
            ItemOutnerCircumference.setText(Float.toString(item.getOuterCircumference()));
            ItemInnerCircumference.setText(Float.toString(item.getInnerCircumference()));
            ItemAuthor.setText(item.getAuthor());
            ItemConservationState.setText(item.getConservationState());
            ItemBiography.setText(item.getBiography());
            ItemDescription.setText(item.getDescription());
            ItemHistoricalContext.setText(item.getHistoricalContext());
            ItemAquisitionDate.setText(item.getAquisitionDate());
        }

    }
}
