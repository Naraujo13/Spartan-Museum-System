/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.DatabaseHelper;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class MuseumPaneController implements Initializable {
    
    @FXML
    private Label MuseumNameLabel;
    @FXML
    private Label MuseumIDLabel;
    @FXML
    private Label MuseumAddressLabel;
    @FXML
    private Label MuseumPhoneLabel;
    @FXML
    private Label MuseumEmailLabel;
    @FXML
    private Label MuseumScheduleLabel;
    @FXML
    private Label MuseumDescriptionLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MuseumNameLabel.setText(DatabaseHelper.getMuseum().getName());
        //MuseumIDLabel.setText(model.DatabaseHelper.getMuseum().); ??? cadê o método???
        MuseumIDLabel.setText("");
        MuseumAddressLabel.setText(DatabaseHelper.getMuseum().getAddress());
        MuseumPhoneLabel.setText(DatabaseHelper.getMuseum().getPhone());
        MuseumEmailLabel.setText(DatabaseHelper.getMuseum().getEmail());
        MuseumScheduleLabel.setText(DatabaseHelper.getMuseum().getOpeningHours());
        MuseumDescriptionLabel.setText(DatabaseHelper.getMuseum().getDescription());
        System.out.println("CHEGUEI AQUI");
    }    
    
}
