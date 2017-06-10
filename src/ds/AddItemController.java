/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<String> collections;
        collections = new ArrayList<>(model.System.getMuseum().getCollectionsTreeMap().keySet());
        ObservableList<String> list = FXCollections.observableArrayList(collections);
        Collections.setItems(list);
        
        
        SaveItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("hello there,  you clicked me");
               if(!ItemName.getText().equals("")){
                   item.setName(ItemName.getText());
               }
               if(!ItemID.getText().equals("")){
                   //item.setID(ItemID.getText());
               }
               if(!ItemYear.getText().equals("")){
                   item.setYear(Integer.parseInt(ItemYear.getText()));
               }
               
               if(!ItemStatus.getText().equals("")){
                   //item.setStatus(ItemStatus.getText()));
               }
               
               if(!ItemHeight.getText().equals("")){
                   item.setHeight(Float.parseFloat(ItemHeight.getText()));
               }
               
               if(!ItemWidth.getText().equals("")){
                   item.setWidth(Float.parseFloat(ItemWidth.getText()));
               }
               
               if(!Itemthickness.getText().equals("")){
                   item.setThickness(Float.parseFloat(Itemthickness.getText()));
               }
               
               if(!ItemAuthor.getText().equals("")){
                   item.setAuthor(ItemAuthor.getText());
               }
               
               if(!ItemDate.getText().equals("")){
                   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    
                   try {
                       item.setAquisitionDate((Date) formato.parse(ItemDate.getText()));
                   } catch (ParseException ex) {
                       Logger.getLogger(EditItemController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
               if(!ItemDescription.getText().equals("")){
                   item.setDescription(ItemDescription.getText());
               }
               
               if(!ItemInnerCircumference.getText().equals("")){
                   item.setInnerCircumference(Float.parseFloat(ItemInnerCircumference.getText()));
               }
               
               if(!ItemOutnerCircumference.getText().equals("")){
                   item.setOuterCircumference(Float.parseFloat(ItemOutnerCircumference.getText()));
               }
               
               if(!Deph.getText().equals("")){
                   item.setDepth(Float.parseFloat(Deph.getText()));
               }
               
               if(Collections.getValue()!=null){
                   //ArrayList<model.Collection> collectionsName = new ArrayList<>(model.System.searchCollectionByName(Collections.getValue()).values());
                   System.out.println("COLEÇÃO ESCOLHIDA: " + Collections.getValue());

                   //item.setCollection(Collections.getValue());
               }
            }
        }
        );
    }    
    
    @FXML
    public void setItem(model.Item item){
        this.item=item;
    }
}
