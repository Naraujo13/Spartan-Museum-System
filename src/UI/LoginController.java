/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
import javafx.stage.Stage;
import model.DatabaseHelper;
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
    private TextField CPFTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private Label WarnningLabel;
    
    
    
    @FXML
    private void handleLoginAction(ActionEvent event) {
        
        
        //load up OTHER FXML document
        if(DatabaseHelper.login(CPFTextField.getText(), PasswordTextField.getText())==Utils.REQUEST_OK){
        //if(CPFTextField.getText().equals("01939512077") && PasswordTextField.getText().equals("kellerson123")){
            Stage stage; 
            Parent root = null;

            //get reference to the button's stage         
            stage=(Stage) LoginButton.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            if(DatabaseHelper.login(CPFTextField.getText(), PasswordTextField.getText())==Utils.NOT_FOUND_ERROR){
            //if(CPFTextField.getText().equals("01939512077")){
                WarnningLabel.setText("CPF inválido");
                WarnningLabel.setVisible(true);
            }
            else{
                WarnningLabel.setText("Senha inválido");
                WarnningLabel.setVisible(true);
            }
        }
            
            
        
            
           
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
