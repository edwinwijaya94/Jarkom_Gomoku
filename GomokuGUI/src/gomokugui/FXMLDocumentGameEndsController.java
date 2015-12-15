/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vickonovianto
 */
public class FXMLDocumentGameEndsController implements Initializable {

    @FXML
    private Label winLoseLabel;
    @FXML
    private Button okButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Task task2 = new Task<Void>() {
            @Override
            public Void call() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                 Platform.runLater(new Runnable() {
          @Override public void run() {
            //((Label)getNodeByRowColumnIndex(i2,j2 , gridPane)).setGraphic(iv);
            winLoseLabel.setText(FXMLDocumentGameController.message);
          }  
        });
                
              
                         
                return null;
            }
        };
        new Thread(task2).start();
    }    

    @FXML
    private void clickOk(MouseEvent event) throws IOException {
        Parent root;
        Stage stage; 
        stage=(Stage) okButton.getScene().getWindow();
        stage.close();
        
        stage= (Stage) stage.getOwner();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentRoom.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
