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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Utils;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button LoginButton;
    @FXML
    private Button btn2;
    @FXML
    private TextField CPFTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private Label WarnningLabel;
    
    
    
    @FXML
    private void handleLoginAction(ActionEvent event) {
        Stage stage; 
        Parent root = null;
        
        //get reference to the button's stage         
        stage=(Stage) LoginButton.getScene().getWindow();
        
        //load up OTHER FXML document
        if(model.System.login(CPFTextField.getText(), PasswordTextField.getText())==Utils.REQUEST_OK){
        //if(CPFTextField.getText().equals("01939512077") && PasswordTextField.getText().equals("kellerson123")){
            try {
                root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            if(model.System.login(CPFTextField.getText(), PasswordTextField.getText())==Utils.NOT_FOUND_ERROR){
            //if(CPFTextField.getText().equals("01939512077")){
                WarnningLabel.setText("Senha inválida");
                WarnningLabel.setVisible(true);
            }
            else{
                WarnningLabel.setText("CPF inválido");
                WarnningLabel.setVisible(true);
            }
        }
            
            
        
            
           
        //create a new scene with root and set the stage
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
