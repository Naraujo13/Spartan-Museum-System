/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class MovimentationController implements Initializable {
    
    @FXML
    private Accordion Accordion; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void showMovimentations(model.Item item){
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
