/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
import model.PutToExpositionMovimentation;

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
        
        ArrayList<model.Movimentation> movimentations = new ArrayList<>(item.getMovimentationsTreeMap().values());
        for(model.Movimentation movimentation : movimentations){
            if(movimentation instanceof model.PutToExpositionMovimentation){
                AnchorPane newPanelContent = new AnchorPane();
                newPanelContent.getChildren().add(new Label("Origem: "+movimentation.getOrigin() + "\n" + "Destino: "+((PutToExpositionMovimentation) movimentation).getDestination() + "\n" + "Movimentação registrada por: "+movimentation.getCpfAutor()));
                TitledPane pane = new TitledPane(utils.Utils.AT_EXPOSITION+" - " + movimentation.getTimestamp(), newPanelContent);
                Accordion.getPanes().add(pane);
            }
            if(movimentation instanceof model.DischargeMovimentation){
                AnchorPane newPanelContent = new AnchorPane();
                newPanelContent.getChildren().add(new Label("Origem: "+movimentation.getOrigin()  + "\n" + "Movimentação registrada por: "+movimentation.getCpfAutor()));
                TitledPane pane = new TitledPane(utils.Utils.DISCHARGED+" - " + movimentation.getTimestamp(), newPanelContent);
                Accordion.getPanes().add(pane);
            }
            if(movimentation instanceof model.PutToStorageMovimentation){
                AnchorPane newPanelContent = new AnchorPane();
                newPanelContent.getChildren().add(new Label("Origem: "+movimentation.getOrigin() + "\n" + "Destino: "+((model.PutToStorageMovimentation) movimentation).getDestination() + "\n" + "Movimentação registrada por: "+movimentation.getCpfAutor()));
                TitledPane pane = new TitledPane(utils.Utils.AT_STORAGE+" - " + movimentation.getTimestamp(), newPanelContent);
                Accordion.getPanes().add(pane);
            }
            if(movimentation instanceof model.AdmissionMovimentation){
                AnchorPane newPanelContent = new AnchorPane();
                newPanelContent.getChildren().add(new Label("Origem: "+movimentation.getOrigin() + "\n" + "Destino: "+((model.AdmissionMovimentation) movimentation).getDestination() + "\n" + "Movimentação registrada por: "+movimentation.getCpfAutor()));
                TitledPane pane = new TitledPane("Entrada"+" - " + movimentation.getTimestamp(), newPanelContent);
                Accordion.getPanes().add(pane);
            }
            if(movimentation instanceof model.SendToLoanMovimentation){
                AnchorPane newPanelContent = new AnchorPane();
                newPanelContent.getChildren().add(new Label("Origem: "+movimentation.getOrigin() + "\n" + "Destino: "+((model.SendToLoanMovimentation) movimentation).getDestination() + "\n" + "Movimentação registrada por: "+movimentation.getCpfAutor()));
                TitledPane pane = new TitledPane(utils.Utils.AT_LOAN+" - " + movimentation.getTimestamp(), newPanelContent);
                Accordion.getPanes().add(pane);
            }
            if(movimentation instanceof model.SendToRestorationMovimentation){
                AnchorPane newPanelContent = new AnchorPane();
                newPanelContent.getChildren().add(new Label("Origem: "+movimentation.getOrigin() + "\n" + "Destino: "+((model.SendToRestorationMovimentation) movimentation).getDestination() + "\n" + "Movimentação registrada por: "+movimentation.getCpfAutor()));
                TitledPane pane = new TitledPane(utils.Utils.AT_RESTAURATION+" - " + movimentation.getTimestamp(), newPanelContent);
                Accordion.getPanes().add(pane);
            }
            
            
        }
        
        
    }
    
}
