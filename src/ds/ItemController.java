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
import model.Item;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class ItemController implements Initializable {
    
    @FXML
    private Label ItemName;
    
    @FXML
    private Label ItemID;

    @FXML
    private Label ItemYear;

    @FXML
    private Label ItemStatus;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void showItem(model.Item item){
        if(item!=null){
            System.out.println(item.getName());
            if(ItemName==null){
                System.out.println("O LABEL É NULL");
            }
            else{
                ItemName.setText(item.getName());
                ItemID.setText(item.getID());
                ItemYear.setText(""+item.getYear());
                ItemStatus.setText(item.getStatus());
                
            }
            
        }
    }
    
}
