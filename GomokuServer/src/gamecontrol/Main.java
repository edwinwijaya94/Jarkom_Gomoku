/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontrol;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author davidkwan
 */
public class Main {
    
    public static boolean moved = false;
    
    
    public static void main(String args[]) throws IOException, InterruptedException{
        int curPlayerId = 0;
        int numPlayersConnected  = 0;
        ArrayList<Player> playerList = new ArrayList<Player>();
        
        ServerSocket ssock = new ServerSocket(7777);
        System.out.println("Listening to port " + "7777");
        
        while(numPlayersConnected < 2){
            Socket socket = ssock.accept();
            System.out.println("Connected");
            playerList.add(new Player(socket, curPlayerId, curPlayerId++));
            new Thread(playerList.get(numPlayersConnected)).start();
            
            numPlayersConnected++;
        }
        
        Game game = new Game();
        for(int i = 0; i<playerList.size() ; i++){
            game.addPlayer(playerList.get(i));
        }
        
        game.start(game.getPlayerList());
        System.out.println("Game Started");
        for(int i = 0; i<playerList.size(); i++){
            playerList.get(i).setGame(game);
            playerList.get(i).sendMessage("Game Started");
        }
        
        while(game.getStatus() != 2){
            Thread.sleep(50);
            if(moved){
                moved = false;
                for (int i = 0; i < playerList.size(); i++) {
                    playerList.get(i).sendMessage(game.toStringBoard());
                }
            }
        }
        
        for(int i = 0; i<playerList.size(); i++){
            playerList.get(i).sendMessage("Game Ended");
        }
        
    }
    
}
