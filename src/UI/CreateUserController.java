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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DatabaseHelper;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class CreateUserController implements Initializable {
    
    @FXML
    private RadioButton ResearcherButton;
    
    @FXML
    private RadioButton TecnicianButton;
    
    @FXML
    private RadioButton DirectorButton;
    
    @FXML
    private Button AddUserButton;
    
    @FXML
    private TextField Name;
    
    @FXML
    private TextField Password;
    
    @FXML
    private TextField CPF;
    
    @FXML
    private TextField Email;
    
    @FXML
    private TextField Phone;
    
    @FXML
    private TextField UniversityRegistration;
    
    @FXML
    private TextField MuseumID;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(ResearcherButton.isSelected()){
                    DatabaseHelper.addPerson(Name.getText(), CPF.getText(), Password.getText(), Email.getText(), Integer.parseInt(UniversityRegistration.getText()));
                }
                if(TecnicianButton.isSelected()){
                    DatabaseHelper.addPerson(Name.getText(), CPF.getText(), Password.getText(), Email.getText(), MuseumID.getText());
                }
                if(ResearcherButton.isSelected()){
                    DatabaseHelper.addPerson(Name.getText(), CPF.getText(), Password.getText(), Email.getText());
                }
                Stage stage = (Stage) AddUserButton.getScene().getWindow();
                stage.close();
                
            }
        });
    }    
    
}
