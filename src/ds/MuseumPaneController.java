/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
        MuseumNameLabel.setText(model.System.getMuseum().getName());
        //MuseumIDLabel.setText(model.System.getMuseum().); ??? cadê o método???
        MuseumIDLabel.setText("");
        MuseumAddressLabel.setText(model.System.getMuseum().getAddress());
        MuseumPhoneLabel.setText(model.System.getMuseum().getPhone());
        MuseumEmailLabel.setText(model.System.getMuseum().getEmail());
        MuseumScheduleLabel.setText(model.System.getMuseum().getOpeningHours());
        MuseumDescriptionLabel.setText(model.System.getMuseum().getDescription());
        System.out.println("CHEGUEI AQUI");
    }    
    
}
