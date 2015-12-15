/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontrol;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Edwin
 */

// room.getListPlayers().get(i).curRoom == this;

public class Player implements Runnable {
    /* ATTRIBUTE */
    int id;
    String nickname;
    int symbolId;
    Room curRoom;
    Game game = null;
    boolean gameStarted = false;
    
    private final Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    
    /* CONSTRUCTOR */
    public Player(Socket socket, int Id, int symbolId) throws IOException{
        this.socket = socket;
        this.setId(Id);
        this.setSymbolId(symbolId);
        
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        
        String input;
        input = in.readUTF();
        setNickname(input);
        sendMessage("Hello " + nickname);
    }

    /* GETTER */
    public int getId(){
        return this.id;
    }

    public String getNickname(){
        return this.nickname;
    }

    public int getSymbolId(){
        return this.symbolId;
    }

    /* SETTER */
    public void setId(int id){
        this.id = id;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public void setSymbolId(int symbolId){
        this.symbolId = symbolId;
    }
    
    public void setGame(Game game){
        this.game = game;
        this.gameStarted = true;
    }

    /* METHOD */
    public void sendMessage(String message) throws IOException{
        out.writeUTF(message);
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!gameStarted){
                // Ignored
                String message = "";
                try {
                    message = in.readUTF();
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String[] splitted = message.split("\\s+");
                if(splitted[0].equals("\\enter")){
                    curRoom = Main.roomList.get(Integer.parseInt(splitted[1]));
                    curRoom.addPlayer(this);
                    try {
                        sendMessage("Entered room " + curRoom.getId());
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if (splitted[0].equals("\\create")){
                    Main.addRoom();
                    try {
                        sendMessage("Created Room " + (Main.curRoomId));
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if (splitted[0].equals("\\start")){
                    if(curRoom != null && curRoom.getPlayerList().size() >= 3){
                        curRoom.gameStarted = true;
                    }
                    else{
                        try {
                            sendMessage("Fail starting game");
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else if (splitted[0].equals("\\getRoomList")){
                    // getRoomList
                    message = "";
                    for(int i=0; i<Main.roomList.size(); i++){
                        message += "Room " + Main.roomList.get(i).getId() + "\n";
                    }
                    try {
                        sendMessage(message);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else {
                try {
                    if(id == game.getTurn() && game.getStatus() != 2){
                        int i,j;
                        sendMessage("Your Move");
                        String message = in.readUTF();
                        if(message.equals("\\dummy"))
                            i = Integer.parseInt(in.readUTF());
                        else
                            i = Integer.parseInt(message);
                            
                        j = Integer.parseInt(in.readUTF());
                        int ret = game.move(id, i, j);
                        if(ret == -1){
                            sendMessage("INVALID MOVE, re-enter coordinate");
                        } else{
			    String updatedCoordinate = id + " " + i + " " + j;
                            //System.out.println("update:" + updatedCoordinate);
                            for (int index = 0; index < game.playerList.size(); index++) {
                                game.playerList.get(index).sendMessage(updatedCoordinate);
                            }
                            game.nextTurn();
                        }
                    }
                    else if(game.getStatus()==2) {
                        // Game Ended
                        gameStarted = false;
                        
                    }
                } catch (IOException ex) {
                    if(gameStarted)
                        game.nextTurn();
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}