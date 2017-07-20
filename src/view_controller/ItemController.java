/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class ItemController implements Initializable {
    
    model.Item item;
    
    @FXML
    private AnchorPane ItemPane;
    
    @FXML
    private Label ItemName;
    
    @FXML
    private Label ItemID;

    @FXML
    private Label ItemYear;

    @FXML
    private Label ItemStatus;
    
    @FXML
    private Button ViewMovimentation;
    
    @FXML
    private Label BiographyItem;
    
    @FXML
    private Label HeightItem;
    
    @FXML
    private Label WidthItem;
    
    @FXML
    private Label WeightItem;
    
    @FXML
    private Label ThicknessItem;
    
    @FXML
    private Label AuthorItem;
    
    @FXML
    private Label DateItem;
    
    @FXML
    private Label ItemDescription;
    
    @FXML
    private Label InnerCircumference;
    
    @FXML
    private Label OuterCircumference;
    
    @FXML
    private Label Depth;
    
    @FXML
    private Button EditItem;

    @FXML
    private Label ConservationStateItem;

    @FXML
    private Label HistoricalContextItem;

    @FXML
    private Label LenghtItem;

    /**
     * Initializes the controller class.
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ViewMovimentation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("hello there,  you clicked me");
               
                try {
                
               // Pane p2 = fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Movimentation.fxml"));
                //fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                MovimentationController movimentationController = new MovimentationController();
                fxmlLoader.setController(movimentationController);

                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                movimentationController.showMovimentations(item);
  
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        );
        
        EditItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("hello there,  you clicked me");
               
                try {
                
               // Pane p2 = fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
                //fxmlLoader.load(getClass().getResource("Item.fxml").openStream());
                EditItemController editItemController = new EditItemController();
                fxmlLoader.setController(editItemController);

                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
                editItemController.setItem(item);
  
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        );
    }

    

    @FXML
    public void showItem(model.Item item){
        this.item=item;
        if(item!=null){
            System.out.println(item.getName());
            if(ItemName==null){
                System.out.println("O LABEL É NULL");
            }
            else{
                ItemName.setText( item.getName());
                ItemID.setText("ID: " +item.getID());
                ItemYear.setText("Ano: "+item.getYear());
                ItemStatus.setText("Status: " + item.getStatus());
                BiographyItem.setText("Biografia: " + item.getBiography());
                HeightItem.setText("Altura: "+item.getHeight());
                WidthItem.setText("Largura: "+item.getWidth());
                ThicknessItem.setText("Espessura: "+item.getThickness());
                AuthorItem.setText("Autor: " + item.getAuthor());
                DateItem.setText("Data de Aquisição: "+item.getAquisitionDate());
                ItemDescription.setText("Descrição: " +item.getDescription());
                InnerCircumference.setText("Circunferência interna: "+item.getInnerCircumference());
                OuterCircumference.setText("Circunferência externa: "+item.getOuterCircumference());
                Depth.setText("Profundidade: "+ item.getDepth());
                ConservationStateItem.setText("Estado de Conservação: " + item.getConservationState());
                HistoricalContextItem.setText("Contexto Histórico: " + item.getHistoricalContext());
                LenghtItem.setText("Comprimento: "+item.getLenght());

                
            }
            
        }
    }
    
  
    
    
}
