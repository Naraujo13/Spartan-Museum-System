/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DatabaseHelper;

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
        
    }

    public void setItem(model.Item item){
        this.item=item;
        ArrayList<String> collections;
        collections = new ArrayList<>();
        
        if(item.getStatus().equals(utils.Utils.AT_RESTAURATION)){
            collections.add("Retornar da Restauração");
        }
        else if(item.getStatus().equals(utils.Utils.AT_LOAN)){
            collections.add("Retornar de Empréstimo");
        }
        else if(item.getStatus().equals(utils.Utils.AT_EXPOSITION)){
            collections.add("Retornar de Exposição");
        }
        else if(item.getStatus().equals(utils.Utils.AT_STORAGE)){
            collections.add("Emprestar");
            collections.add("Restaurar");
            collections.add("Armazenar");
            collections.add("Expor");
            collections.add("Remover");
        }
        ObservableList<String> list = FXCollections.observableArrayList(collections);
        MovimentationTypeChoiceBox.setItems(list);
        
        
        AddMovimentationButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(MovimentationTypeChoiceBox.getValue().equals("Expor")){                      
                        DatabaseHelper.exposeItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals("Emprestar")){                      
                        DatabaseHelper.loanItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                       
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals("Restaurar")){                                        
                        DatabaseHelper.restoreItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals("Armazenar")){                                        
                        DatabaseHelper.storeItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals("Remover")){                                        
                        DatabaseHelper.dischargeItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()));
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals("Retornar da Restauração")){                                                               
                        DatabaseHelper.returnFromRestoration("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals("Retornar de Empréstimo")){                                                               
                        DatabaseHelper.returnFromLoan("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    if(MovimentationTypeChoiceBox.getValue().equals("Retornar de Exposição")){                                                               
                        DatabaseHelper.storeItem("Picasso", item.getID(), new Date(java.lang.System.currentTimeMillis()), Destination.getText());
                    }
                    Stage stage = (Stage) AddMovimentationButton.getScene().getWindow();
                    stage.close();
                }
            }   
        );
    }
    
}
