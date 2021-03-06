/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

//import static gomokugui.FXMLDocumentRoomController.str;
import static gomokugui.FXMLDocumentStartController.in;
import static gomokugui.FXMLDocumentStartController.out;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vicko
 */
public class FXMLDocumentRoomsController implements Initializable {
    
    public static StringProperty str = new SimpleStringProperty();

    public static class Room {
        private SimpleIntegerProperty roomNo;
        private SimpleStringProperty roomName;
        //private SimpleIntegerProperty players;
        
        private Room(int roomNo, String roomName) {
            this.roomNo = new SimpleIntegerProperty(roomNo);
            this.roomName = new SimpleStringProperty(roomName);
            //this.players = new SimpleIntegerProperty(players);
        }
        
        public int getRoomNo() {
            return roomNo.get();
        }
        
        public String getRoomName() {
            return roomName.get();
        }
        
//        public int getPlayers() {
//            return players.get();
//        }
        
        public void setRoomNo(int roomNo) {
            this.roomNo.set(roomNo);
        }
        
        public void setRoomName(String roomName) {
            this.roomName.set(roomName);
        }
        
//        public void setPlayers(int players) {
//            this.players.set(players);
//        }
    }
    
    @FXML
    private Button homeButton;
    @FXML
    private TableView<Room> roomsList;
    @FXML
    private Button createRoomButton;
    @FXML
    private Button joinRoomButton;
    public static String roomName;
    
    private ObservableList<Room> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //try {
            // TODO
            Task task2 = new Task<Void>() {
                @Override
                public Void call() {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    ObservableList<TableColumn<Room, ?>> columns = (ObservableList<TableColumn<Room, ?>>) roomsList.getColumns();
                    for (TableColumn column : columns) {
                        //System.out.println(column.getText());
                        if (column.getText().equals("No.")) {
                            column.setCellValueFactory(new PropertyValueFactory<Room, String>("roomNo"));
                            column.setStyle("-fx-alignment: CENTER;");
                        } else if (column.getText().equals("Room Name")) {
                            column.setCellValueFactory(new PropertyValueFactory<Room, String>("roomName"));
                        } //else if (column.getText().equals("Players")) {
//                            column.setCellValueFactory(new PropertyValueFactory<Room, String>("players"));
//                            column.setStyle("-fx-alignment: CENTER;");
//                        }
                    }
                    
                    roomsList.setItems(data);
                    
                    //data.add(new Room(1, "a", 0));
                    
                    return null;
                }
            };
            new Thread(task2).start();
            
            out.writeUTF("\\getRoomList");
            
            str.set(in.readUTF());
            System.out.println(str.get());
            String[] roomList = str.get().split("\n");
            int k = 1;
            for (String room : roomList) {
                System.out.println("room name : " + room);
                data.add(new Room(k++, room));
            }
            //} catch (IOException ex) {
            //Logger.getLogger(FXMLDocumentRoomsController.class.getName()).log(Level.SEVERE, null, ex);
            //}
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentRoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        roomsList.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
            if (roomsList.getSelectionModel().getSelectedItem() != null) {
                //lblTool.setText(newValue.getTool());
                roomName = newValue.getRoomName();
            }
        });

        
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
//        Parent root;
//        Stage dialogStage = new Stage();
//        root = FXMLLoader.load(getClass().getResource("FXMLDocumentChooseChar.fxml"));
//        dialogStage.setTitle("Choose A Character");
//        dialogStage.initModality(Modality.WINDOW_MODAL);
//        dialogStage.initOwner((Stage) homeButton.getScene().getWindow());
//
//        Scene scene = new Scene(root);
//        dialogStage.setScene(scene);
//        dialogStage.show();
        String[] splits = roomName.split(" ");
        out.writeUTF("\\enter " + splits[1]);
        
        Stage stage; 
        Parent root;
        stage=(Stage) homeButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentRoom.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
