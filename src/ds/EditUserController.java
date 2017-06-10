/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class EditUserController implements Initializable {
    
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
                if(!Name.getText().equals("")){
                    model.System.getActiveUser().setName(Name.getText());
                }
                if(!CPF.getText().equals("")){
                    model.System.getActiveUser().setCpf(CPF.getText());
                }
                if(!Password.getText().equals("")){
                    model.System.getActiveUser().setSenha(Password.getText());
                }
                if(!Email.getText().equals("")){
                    model.System.getActiveUser().setEmail(Email.getText());
                }
                if(!Phone.getText().equals("")){
                    model.System.getActiveUser().setTelefone(Phone.getText());
                }
                if(!UniversityRegistration.getText().equals("")){
                    //model.System.getActiveUser().setUniversityRegistration(Integer.parseInt(UniversityRegistration.getText()));
                }
                if(!MuseumID.getText().equals("")){
                    //model.System.getActiveUser().setMuseumID(MuseumID.getText());
          
                }
            }
        });
    }    
    
}
