/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vicko
 */
public class FXMLDocumentRoomsController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private TableView<?> roomsList;
    @FXML
    private Button createRoomButton;
    @FXML
    private Button joinRoomButton;
    @FXML
    private Label roomTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToHome(MouseEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) homeButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentStart.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void createRoom(MouseEvent event) throws IOException {
        Parent root;
        Stage dialogStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentCreateRoom.fxml"));
        dialogStage.setTitle("Create Room");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner((Stage) homeButton.getScene().getWindow());

        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
        
        
    }

    @FXML
    private void joinRoom(MouseEvent event) throws IOException {
        
        Parent root;
        Stage dialogStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentChooseChar.fxml"));
        dialogStage.setTitle("Choose A Character");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner((Stage) homeButton.getScene().getWindow());

        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
        
//        Stage stage; 
//        Parent root;
//        stage=(Stage) homeButton.getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource("FXMLDocumentRoom.fxml"));
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    
}
