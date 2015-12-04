/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

import static gomokugui.FXMLDocumentRoomController.str;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class FXMLDocumentStartController implements Initializable{

    @FXML
    private TextField nicknameField;
    @FXML
    private Button nicknameButton;
    @FXML
    private ImageView logoStart;
    
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    @FXML
    private TextField ipAddress;
    
    private class GameStarted implements Runnable {

        @Override
        public void run() {
            
        }
    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logoStart.setImage(new Image(getClass().getResourceAsStream("img/logo.png")));
        logoStart.setFitWidth(400);
        logoStart.setFitHeight(150);
        
//        
//        String serverMessage = "";
//        String message = "";
        
        //message = sc.nextLine();
        
        //System.out.println("Connecting...");
//        try {
//            socket = new Socket("10.5.21.94", 7777);
//            //socket = new Socket("localhost", 7777);
//            //System.out.println("Connection Successful");
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLDocumentStartController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        //in = new DataInputStream(socket.getInputStream());
        //out = new DataOutputStream(socket.getOutputStream());
        
        //out.writeUTF(message);
        //System.out.println(in.readUTF());
        
//        while(!serverMessage.equals("Game Started")){
//            serverMessage = in.readUTF();
//        }
//        System.out.println(serverMessage);
//        
//        while(!serverMessage.equals("Game Ended")){
//            serverMessage = in.readUTF();
//            if(serverMessage.equals("Your Move")){
//                System.out.println(serverMessage);
//                
//                System.out.println("Enter i coordinate");
//                int i = sc.nextInt();
//                out.writeUTF(Integer.toString(i));
//                
//                // Should be enter j coordinate
//                System.out.println("Enter j coordinate");
//                int j = sc.nextInt();
//                out.writeUTF(Integer.toString(j));
//            }
//            else{
//                System.out.println(serverMessage);
//            }
//            
//        }        
   // }
    }    

    @FXML
    private void submitNickname(MouseEvent event) throws IOException {
        if (nicknameField.getText().length() > 0) {
            
            socket = new Socket(ipAddress.getText(), 7777);
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(nicknameField.getText());
            
            Stage stage = new Stage(); 
            Parent root;
            Stage curstage=(Stage) nicknameButton.getScene().getWindow();
            curstage.hide();
            root = FXMLLoader.load(getClass().getResource("FXMLDocumentRoom.fxml"));

            stage.setTitle("Create Room");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner((Stage) nicknameField.getScene().getWindow());

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            str.set("");
            System.out.println("ROOM");
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentRoomController.class.getName()).log(Level.SEVERE, null, ex);
            }
//            GameStarted gameStarted = new GameStarted();
//            new Thread(gameStarted).start();
            
            Task task = new Task<Void>() {
                @Override
                public Void call() {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    while(!str.get().equals("Game Started")){
                        try {
                            str.set(in.readUTF());
                            System.out.println(str.get());
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentRoomController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("keluar");
                    
                    return null;
                }
            };
            
            task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent t) {
                    try {
                        Stage stage = new Stage(); 
                        Parent root;
                        Stage curstage=(Stage) nicknameButton.getScene().getWindow();
                        curstage.hide();
                        root = FXMLLoader.load(getClass().getResource("FXMLDocumentGame.fxml"));

                        stage.setTitle("Playing");
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.initOwner((Stage) nicknameField.getScene().getWindow());

                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentStartController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            new Thread(task).start();
            
        }
    }
    
}
