/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Item;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class ItemController implements Initializable {
    
    model.Item item;
    
    @FXML
    private Label ItemName;
    
    @FXML
    private Label ItemID;

    @FXML
    private Label ItemYear;

    @FXML
    private Label ItemStatus;
    
    @FXML
    private Button ViewMovimentation;


    /**
     * Initializes the controller class.
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ViewMovimentation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("hello there,  you clicked me"); 
            }
        }
        );
    }

    

    @FXML
    public void showItem(model.Item item){
        this.item=item;
        if(item!=null){
            System.out.println(item.getName());
            if(ItemName==null){
                System.out.println("O LABEL É NULL");
            }
            else{
                ItemName.setText(item.getName());
                ItemID.setText(item.getID());
                ItemYear.setText(""+item.getYear());
                ItemStatus.setText(item.getStatus());
                
            }
            
        }
    }
    
  
    
    
}
