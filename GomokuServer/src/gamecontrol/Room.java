/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontrol;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Edwin
 */
public class Room implements Runnable {
    /* ATTRIBUTE */
    int id;
    ArrayList<Player> playerList = new ArrayList<Player>();
    Game game;
    
    /* CONSTRUCTOR */
    public Room(int roomId){
        this.id = roomId;
        game = new Game();
    }
    
    /* GETTER */
    public int getId(){
        return this.id;
    }
    
    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }
    
    public Player getPlayer(int id){
        return this.getPlayerList().get(id);
    }
    
    public int getGameStatus(){
        return this.game.getStatus();
    }
    
    public Game getGame(){
        return this.game;
    }
    
    public int getTotalPlayer(){
        return playerList.size();
    }
    
    /* SETTER */
    public void setId(int id){
        this.id = id;
    }
    
    /* METHOD */
    public void addPlayer(Player player){
        this.getPlayerList().add(player);
    }
    
    public void removePlayer(int id){
        int i=0;
        while( i<this.getTotalPlayer() && this.getPlayer(i).getId() != id)
            i++;
        this.getPlayerList().remove(i);
    }
    
    public void startGame(ArrayList<Player> playerList){
        this.getGame().start(playerList);
    }
    
    public boolean isEmpty(){
        return this.getTotalPlayer() == 0;
    }

    @Override
    public void run() {
        
        while(getTotalPlayer() < 2){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Initialize game
        for(int i = 0; i<playerList.size() ; i++){
            playerList.get(i).setId(i);
            playerList.get(i).setSymbolId(i);
            game.addPlayer(playerList.get(i));
        }
        
        game.start(game.getPlayerList());
        System.out.println("Game Started");
        for(int i = 0; i<playerList.size(); i++){
            try {
                playerList.get(i).setGame(game);
                playerList.get(i).sendMessage("Game Started");
            } catch (IOException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while(game.getStatus() != 2){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int i = 0; i< playerList.size(); i++){
            try {
                playerList.get(i).sendMessage("Game Ended");
            } catch (IOException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}