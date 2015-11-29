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
public class Game {
    /* CONSTANT */
    final int MAX_PLAYER = 5;
    final int BOARD_SIZE = 20;
    
    /* ATTRIBUTE */
    //int id;
    int status; // 0 = not started, 1 = playing, 2 = finished
    int[][] board; // 1-base indexed, started from (1,1)
    ArrayList<Player> playerList;
    String winner;
    
    /* CONSTRUCTOR */
    public Game(){
        //this.setId(id);
        this.setStatus(0);
        this.board = new int[BOARD_SIZE + 1][BOARD_SIZE + 1];
        this.playerList = new ArrayList<>(MAX_PLAYER);
        this.winner = new String();
    }

    /* GETTER */
//    public int getId(){
//        return this.id;
//    }
    
    public int getStatus(){
        return this.status;
    }
    
    public int[][] getBoard(){
        return this.board;
    }
    
    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }
    
    public String getWinner(){
        return this.winner;
    }
    
    /* SETTER */
//    public void setId(int id){
//        this.id = id;
//    }
    
    public void setStatus(int status){
          this.status = status;
    }

    public void setWinner(String winner){
        this.winner = winner;
    }
    
    /* METHOD */
    public void addPlayer(Player player){
        this.getPlayerList().add(player);
    }
    
    public void start(ArrayList<Player> playerList){
        this.setStatus(1);
        this.resetBoard();
        
        // add players
        for(int i=0; i<playerList.size(); i++)
            this.addPlayer(playerList.get(i));
        
    }
    
    public void resetBoard(){
        for(int i=1; i<=BOARD_SIZE; i++){
            for(int j=1; j<=BOARD_SIZE; j++)
                this.board[i][j] = 0;
        }
    }
    
    public void finish(){
        
    }
}
