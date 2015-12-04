/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontrol;

import java.util.*;
import javafx.util.Pair;
/**
 *
 * @author Edwin
 */
public class Game {
    /* CONSTANT */
    final int MAX_PLAYER = 5;
    final int BOARD_SIZE = 20;
    final int WINNING_LENGTH = 5;
    
    /* ATTRIBUTE */
    //int id;
    int status; // 0 = not started, 1 = playing, 2 = finished
    int[][] board; // 0-base indexed, started from (0,0)
    ArrayList<Player> playerList;
    String winner;
    int turn;
    
    /*INFO FOR ACCESS WINNING COORDINATE*/
    /*Coordinate access uses matrix access type (i,j) ->(row,column)
    /* First pair is 1st bound coordinate
    /* Second pair is 2nd bound coordinate
    */
    Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> winningCoordinate;
    
    /* CONSTRUCTOR */
    public Game(){
        //this.setId(id);
        this.setStatus(0);
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
        this.playerList = new ArrayList<>(MAX_PLAYER);
        this.winner = new String();
    }

    /* GETTER */
    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    
    public int getStatus(){
        return this.status;
    }
    
    public int[][] getBoard(){
        return this.board;
    }
    
    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }
    
    public Player getPlayer(int id){
        int i = 0;
        while(this.getPlayerList().get(i).getId() != id)
            i++;
        return this.getPlayerList().get(i);
    }
    
    public String getWinner(){
        return this.winner;
    }
    
    public boolean isAborted(){
        if(this.getPlayerList().size() <= 1)
            return true;
        else
            return false;
    }
    
    public Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> getWinningCoordinate(){
        return this.winningCoordinate;
    }
    
    /* SETTER */
    
    public void setStatus(int status){
          this.status = status;
    }

    public void setWinner(String winner){
        this.winner = winner;
    }
    
    public void setWinningCoordinate(int i1, int j1, int i2, int j2){
        Integer a = i1;
        Integer b = j1;
        Integer c = i2;
        Integer d = j2;
        this.winningCoordinate = new Pair<>(new Pair<>(a,b),new Pair<>(c,d));
    }
    
    /* METHOD */
    public void addPlayer(Player player){
        this.getPlayerList().add(player);
    }
    
    public void removePLayer(int id){
        int i = 0;
        while(this.getPlayer(i).getId() != id)
            i++;
        this.getPlayerList().remove(i);
    }
    
    public void start(ArrayList<Player> playerList){
        this.setStatus(1);
        this.resetBoard();
        this.turn = 0;
    }
    
    public void resetBoard(){
        for(int i=0; i<BOARD_SIZE; i++){
            for(int j=0; j<BOARD_SIZE; j++)
                this.board[i][j] = -1;
        }
    }
    
    public int move(int playerId, int i, int j){
        Player player = this.getPlayer(playerId);
        if(this.getBoard()[i][j] == -1){
            //process
            this.getBoard()[i][j] = player.getSymbolId();
            if(this.isFinished(player.getSymbolId(), i, j) || this.isAborted()){
                this.setWinner(this.getPlayer(playerId).getNickname());
                this.finish();
                return 1; // player wins or game aborted
            }
            else{
                // valid move
                return 0;
            }
        }
        else{
            //rejected, invalid move
            return -1;
        }
    }
    
    public void nextTurn(){
         turn = (turn + 1) % playerList.size();
    }
    
    public boolean isFinished(int symbolId, int i, int j){
        boolean found = false;
        
        // CHECK ALL DIRECTIONS
        int a = i, b = j;
        int streak;
        
        //check vertical
        //System.out.println("Vertical");
        if(!this.checkByDirection(symbolId, i, j, 0 ,-1 ,0 ,1 )){
            //check horizontal
            //System.out.println("Horizontal");
            if(!this.checkByDirection(symbolId, i, j,-1,0,1,0)){
                //check up-left to down-right diagonal
                //System.out.println("up-left to down-right diagonal");
                if(!this.checkByDirection(symbolId, i, j,-1,-1,1,1)){
                    //check down-left to up-right diagonal
                    //System.out.println("down-left to up-right diagonal");
                    found = this.checkByDirection(symbolId, i, j,1,-1,-1,1);
                }
                else
                    found = true;
            }
            else
                found = true;
        }
        else
            found = true;
               
        //return
        return found;
    }
    
    public void finish(){
        this.status = 2;
    }
    
    public String toStringBoard(){
        String output = "";
        for(int i=0; i<10;i++){
            for(int j=0; j<10; j++){
                output += board[i][j] + " ";
            }
            output += "\n";
        }
        
        return output;
    }
    
    public boolean checkByDirection(int symbolId, int i, int j, int dx1, int dy1, int dx2, int dy2){
        boolean found = false;
        int i1 = i, i2 = i;
        int j1 =j, j2 =j;
        int streak = 0;
        //get 1st bound
        for(int p =1; p<=WINNING_LENGTH; p++){
            if(board[i1][j1] == symbolId)
                streak++;
            else{
                i1 -= dy1;
                j1 -= dx1;
                break;
            }
            if(streak == 5)
                break;
            
            if(((i1>0 || dy1>0) && (i1<BOARD_SIZE-1 || dy1<0)) || dy1 == 0){
               i1 += dy1;
            }
            else
                break;
            if(((j1>0 || dx1>0) && (j1<BOARD_SIZE-1 || dx1<0)) || dx1 == 0){
                j1 += dx1;
            }
            else
                break;
        }
        //get 2nd bound
        for(int p =1; p<=WINNING_LENGTH; p++){
            if(board[i2][j2] == symbolId){
                if(p>1)
                    streak++;
            }
            else{    
                i2 -= dy2;
                j2 -= dx2;
                break;
            }
            
            if(streak == 5)
                break;
            if(((i2>0 || dy2>0) && (i2<BOARD_SIZE-1 || dy2<0)) || dy2 == 0){
               i2 += dy2;
            }
            else
                break;
            if(((j2>0 || dx2>0) && (j2<BOARD_SIZE-1 || dx2<0)) || dx2 == 0){
                j2 += dx2;
            }
            else
                break;
        }
        //checking
//        System.out.println("i1="+i1+" j1="+j1);
//        System.out.println("i2="+i2+" j2="+j2);
        if(streak == 5){
            found = true;
            this.setWinningCoordinate(i1, j1, i2, j2);
        }
        return found;
    }
}
