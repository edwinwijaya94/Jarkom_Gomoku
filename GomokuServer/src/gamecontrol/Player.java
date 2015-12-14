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
public class Player implements Runnable {
    /* ATTRIBUTE */
    int id;
    String nickname;
    int symbolId;
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
            }
            else {
                try {
                     if(id == game.getTurn()){
                        sendMessage("Your Move");
                        int i = Integer.parseInt(in.readUTF());
                        int j = Integer.parseInt(in.readUTF());
                        
                        System.out.println(i +" " +j);
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
                    else{
                        // Opponent's turn
                        //sendMessage("Opponent's turn");
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
