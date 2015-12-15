/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

import static gomokugui.FXMLDocumentRoomsController.str;
import static gomokugui.FXMLDocumentStartController.in;
import static gomokugui.FXMLDocumentStartController.out;
import static gomokugui.FXMLDocumentStartController.socket;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
    
    //private ObjectProperty<DataInputStream> dis = new SimpleObjectProperty<DataInputStream>(FXMLDocumentStartController.in);
    private String serverMessage;
//    public static StringProperty str = new SimpleStringProperty();
    @FXML
    private TableView<?> playersNo;
    @FXML
    private TableView<?> playersName;
    @FXML
    private TableView<?> playersChar;
    @FXML
    private Label no1;
    @FXML
    private Label name1;
    @FXML
    private Label char1;
    @FXML
    private Label no2;
    @FXML
    private Label no3;
    @FXML
    private Label no4;
    @FXML
    private Label no5;
    @FXML
    private Label name2;
    @FXML
    private Label name3;
    @FXML
    private Label name4;
    @FXML
    private Label name5;
    @FXML
    private Label char2;
    @FXML
    private Label char3;
    @FXML
    private Label char4;
    @FXML
    private Label char5;
    
    private Label[] playersNumbers = new Label[5];
    private Label[] playersNames = new Label[5];
    private Label[] playersChars = new Label[5];
    @FXML
    private GridPane gridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*str.addListener(new ChangeListener<String>() {
            

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //System.out.println("changed " + oldValue + "->" + newValue);
                
             
            }
        });*/
        
        Task task2 = new Task<Void>() {
            @Override
            public Void call() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                      playersNo.setPlaceholder(new Label(""));
                      playersName.setPlaceholder(new Label(""));
                      playersChar.setPlaceholder(new Label(""));
                      gridPane.setGridLinesVisible(true);
                      roomTitle.setText(FXMLDocumentRoomsController.roomName);
                    }  
                });
                
                ObservableList<Node> childrens = gridPane.getChildren();
                for(Node node : childrens) {
                    if (GridPane.getColumnIndex(node) == null) {
                        if (GridPane.getRowIndex(node) != null) {
                            playersNumbers[GridPane.getRowIndex(node)-1] = (Label)node;
                        }
                    }
                    else if (GridPane.getColumnIndex(node) == 1) {
                        if (GridPane.getRowIndex(node) != null)
                            playersNames[GridPane.getRowIndex(node)-1] = (Label)node;
                    }
                    else if (GridPane.getColumnIndex(node) == 2) {
                        if (GridPane.getRowIndex(node) != null)
                            playersChars[GridPane.getRowIndex(node)-1] = (Label)node;
                    }
                }
                
                /*Platform.runLater(new Runnable() {
                    @Override public void run() {  
                      playersNumbers[0].setText("1");
                      playersNames[0].setText("p1");
                      String imglocation = "img/small/crop/" + 1 + ".png";
                      Image image = new Image(getClass().getResourceAsStream(imglocation));
                      ImageView iv = new ImageView(image);
                      playersChars[0].setGraphic(iv);
                    }  
                });*/
                         
                return null;
            }
        };
        new Thread(task2).start();
        
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
        out.writeUTF("\\start");
        
        Stage stage; 
        Parent root;
        stage=(Stage) startGameButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentGame.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    
}
