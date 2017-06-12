/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.PutToExpositionMovimentation;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class AddMovimentationController implements Initializable {
    
    model.Item item;

    @FXML
    private ChoiceBox MovimentationTypeChoiceBox;
    
    @FXML
    private Button AddMovimentationButton;
    
    @FXML
    private TextField Origin;
    
    @FXML
    private TextField Destination;
    
    @FXML
    private TextField AuthorCPF;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> collections;
        collections = new ArrayList<>();
        collections.add(utils.Utils.AT_LOAN);
        collections.add(utils.Utils.AT_RESTAURATION);
        collections.add(utils.Utils.AT_STORAGE);
        collections.add(utils.Utils.DISCHARGED);
        collections.add(utils.Utils.AT_EXPOSITION);
        ObservableList<String> list = FXCollections.observableArrayList(collections);
        MovimentationTypeChoiceBox.setItems(list);
        
        
        AddMovimentationButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(MovimentationTypeChoiceBox.getValue().equals(utils.Utils.AT_EXPOSITION)){                      
                        model.System.exposeItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals(utils.Utils.AT_LOAN)){                      
                        model.System.loanItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                       
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals(utils.Utils.AT_RESTAURATION)){                                        
                        model.System.restoreItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals(utils.Utils.AT_STORAGE)){                                        
                        model.System.storeItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals(utils.Utils.AT_EXPOSITION)){                                        
                        model.System.dischargeItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()));
                    }
                }
            }   
        );
    }

    public void setItem(model.Item item){
        this.item=item;
        
    }
    
}
