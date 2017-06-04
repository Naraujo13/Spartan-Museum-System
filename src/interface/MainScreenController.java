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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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
        if(MainScreen.getChildren().size() > 7)
            MainScreen.getChildren().remove(MainScreen.getChildren().size()-1);
        try {
            MainScreen.getChildren().add(FXMLLoader.load(getClass().getResource("SearchResultsPane.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(MainScreen.getChildren().size());
        // TODO
    }    
    
}
