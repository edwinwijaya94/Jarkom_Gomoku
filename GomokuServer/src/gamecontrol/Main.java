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
    
    public static int curRoomId = 0;
    public static ArrayList<Room> roomList = new ArrayList<Room>();
    public static void addRoom(){
        roomList.add(new Room(curRoomId));
        new Thread(roomList.get(curRoomId++)).start();
    }
    public static void getRoomList(){
        for(int i=0; i<roomList.size(); i++){
            System.out.println("Room " + roomList.get(i).getId());
        }
    }
    
    public static void main(String args[]) throws IOException, InterruptedException{
        
        ServerSocket ssock = new ServerSocket(7777);
        System.out.println("Listening to port " + "7777");
        
        ArrayList<Player> playerList = new ArrayList<Player>();
        
        addRoom();
        addRoom();
        
        int curPlayerId = 0;
        int numPlayersConnected  = 0;
        while(true){
            Socket socket = ssock.accept();
            System.out.println("Connected");
            playerList.add(new Player(socket, curPlayerId, curPlayerId++));
            new Thread(playerList.get(numPlayersConnected)).start();
            numPlayersConnected++;
        }
        
    }
    
}