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
public class Driver {
    /* FOR TESTING GAME LOGIC ONLY*/
    public static  void main (String[] args){
        Game game = new Game();
        Player player1 = new Player(1,"A",1);
        Player player2 = new Player(2,"B",2);
        Player player3 = new Player(3,"C",3);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.start(game.getPlayerList());
        
//        for(int i =0; i<3; i++){
//            game.move(1,i,1);
//            game.move(2,i,2);
//            game.move(3,i,3);
//        }
        int playerId = 1;
        Scanner reader = new Scanner(System.in);
        while(game.getStatus() != 2){
            game.printBoard();
            System.out.println("Enter coordinate for player-" + playerId);
            int i = reader.nextInt();
            //System.out.println("i=" + i);
            int j = reader.nextInt();
            //System.out.println("j=" + j);
            int ret = game.move(playerId, i, j);
            if(ret == -1){
                System.out.println("INVALID MOVE, re-enter coordinate");
            }
            else{
                playerId = (playerId % 3) + 1;
            }
        }
        game.printBoard();
        System.out.println("Player nickname:" + game.getWinner()+" wins !");
        System.out.println("Winning Coordinate");
        System.out.println(game.getWinningCoordinate());
    }
}
