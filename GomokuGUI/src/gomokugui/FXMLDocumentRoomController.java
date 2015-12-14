/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vicko
 */
public class FXMLDocumentRoomController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private Label roomTitle;
    @FXML
    private Button exitRoomButton;
    @FXML
    private Button changeCharacterButton;
    @FXML
    private Button startGameButton;
    @FXML
    private TableView<?> playersList;
    
    //private ObjectProperty<DataInputStream> dis = new SimpleObjectProperty<DataInputStream>(FXMLDocumentStartController.in);
    private String serverMessage;
    public static StringProperty str = new SimpleStringProperty();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        str.addListener(new ChangeListener<String>() {
            

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //System.out.println("changed " + oldValue + "->" + newValue);
                
             
            }
        });
        
         //str.set("a");
        
    }    

    @FXML
    private void goToHome(MouseEvent event) throws IOException {
        str.set("Home");
        
        Stage stage; 
        Parent root;
        stage=(Stage) homeButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentStart.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void exitRoom(MouseEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) homeButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentRooms.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void changeCharacter(MouseEvent event) throws IOException {
        Parent root;
        Stage dialogStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentChooseChar.fxml"));
        dialogStage.setTitle("Choose A Character");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner((Stage) homeButton.getScene().getWindow());

        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void startGame(MouseEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) startGameButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentGame.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    
}
