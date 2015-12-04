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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vicko
 */
public class FXMLDocumentCreateRoomController implements Initializable {

    @FXML
    private TextField newRoomName;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickOk(MouseEvent event) throws IOException {
        //room = new Room();
        if (newRoomName.getText().length() > 0) {
            Stage stage; 
            Parent root;
            stage=(Stage) okButton.getScene().getWindow();
            stage.close();
           
            Stage dialogStage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLDocumentChooseChar.fxml"));
            dialogStage.setTitle("Choose A Character");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner((Stage) okButton.getScene().getWindow());

            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            dialogStage.show();
        }
    }

    @FXML
    private void clickCancel(MouseEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
}
