/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vickonovianto
 */
public class FXMLDocumentChooseCharController implements Initializable {

    @FXML
    private ToggleGroup tg;
    @FXML
    private Button okButton;
    @FXML
    private Group tggroup;
    @FXML
    private ToggleButton tb1;
    @FXML
    private ToggleButton tb2;
    @FXML
    private ToggleButton tb3;
    @FXML
    private ToggleButton tb4;
    @FXML
    private ToggleButton tb5;
    @FXML
    private ToggleButton tb6;
    @FXML
    private ToggleButton tb7;
    @FXML
    private ToggleButton tb8;
    @FXML
    private ToggleButton tb9;
    @FXML
    private ToggleButton tb10;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Image image = new Image(getClass().getResourceAsStream("img/small/crop/1.png"));
        ImageView iv = new ImageView(image);
        tb1.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/2.png"));
        iv = new ImageView(image);
        tb2.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/3.png"));
        iv = new ImageView(image);
        tb3.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/4.png"));
        iv = new ImageView(image);
        tb4.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/5.png"));
        iv = new ImageView(image);
        tb5.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/6.png"));
        iv = new ImageView(image);
        tb6.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/7.png"));
        iv = new ImageView(image);
        tb7.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/8.png"));
        iv = new ImageView(image);
        tb8.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/9.png"));
        iv = new ImageView(image);
        tb9.setGraphic(iv);
        image = new Image(getClass().getResourceAsStream("img/small/crop/10.png"));
        iv = new ImageView(image);
        tb10.setGraphic(iv);
        
        tb1.setUserData(1);
        tb2.setUserData(2);
        tb3.setUserData(3);
        tb4.setUserData(4);
        tb5.setUserData(5);
        tb6.setUserData(6);
        tb7.setUserData(7);
        tb8.setUserData(8);
        tb9.setUserData(9);
        tb10.setUserData(10);
        
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
                if (new_toggle == null) {
                    
                }
                else {
                    
                }
            }
        });
    }    

    @FXML
    private void clickOk(MouseEvent event) throws IOException {
        if (tg.getSelectedToggle() != null) {
            Stage stage; 
            Parent root;
            stage=(Stage) okButton.getScene().getWindow();
            stage.close();

            stage= (Stage) stage.getOwner();
            root = FXMLLoader.load(getClass().getResource("FXMLDocumentRoom.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    
}
