/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class MovimentationController implements Initializable {
    
    model.Item item;
    
    @FXML
    private Accordion Accordion; 
    
    @FXML
    private Button AddMovimentationPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddMovimentationPane.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //inicio
                Stage stage; 
                Parent root = null;

                //get reference to the button's stage         
                stage=(Stage) AddMovimentationPane.getScene().getWindow();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMovimentation.fxml"));
                    AddMovimentationController addMovimentationController = new AddMovimentationController();
                    fxmlLoader.setController(addMovimentationController);
                    root = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root));  
                    stage.show();
                    addMovimentationController.setItem(item);
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                //fim
            }
        }
        );

    }

    @FXML
    public void showMovimentations(model.Item item){
        this.item = item;
        AnchorPane newPanelContent = new AnchorPane();
        ArrayList<model.Movimentation> movimentations = new ArrayList<>(item.getMovimentationsTreeMap().values());
        for(model.Movimentation movimentation : movimentations){
            newPanelContent.getChildren().add(new Label("Origem: "+movimentation.getOrigin() + " Responsável: " + movimentation.getCpfAutor()));
        }
        
        TitledPane pane = new TitledPane("Todas", newPanelContent);
        //System.out.println(Accordion);
        Accordion.getPanes().add(pane);
    }
    
}
