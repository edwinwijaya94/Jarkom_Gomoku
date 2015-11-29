/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontrol;

import java.util.*;


/**
 *
 * @author Edwin
 */
public class Room {
    /* ATTRIBUTE */
    int id;
    ArrayList<Player> playerList;
    Game game;
    
    /* CONSTRUCTOR */
    public Room(Player creator){
        playerList = new ArrayList<>();
        this.addPlayer(creator);
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
    
}
