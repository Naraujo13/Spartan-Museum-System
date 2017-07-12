/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DatabaseHelper;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class AddCollectionController implements Initializable {
    
    @FXML
    private TextField CollectionName;
    
    @FXML
    private Button AddCollectionButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AddCollectionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseHelper.addCollection(CollectionName.getText());
                Stage stage = (Stage) AddCollectionButton.getScene().getWindow();
                stage.close();
            }
        });
    }    
    
}
