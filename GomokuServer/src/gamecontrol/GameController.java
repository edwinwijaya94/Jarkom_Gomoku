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
public class GameController {
    /* ATTRIBUTE */
    ArrayList<Room> roomList;
    
    /* CONSTRUCTOR */
    public GameController(){
        roomList = new ArrayList<>();
    }
    
    /* GETTER */
    public ArrayList<Room> getRoomList(){
        return this.roomList;
    }
    
    public Room getRoom(int id){
        return this.getRoomList().get(id);
    }
    
    public int getTotalRoom(){
        return this.getRoomList().size();
    }
    
    /* METHOD */
//    public void addRoom(Player creator){
//        Room newRoom = new Room(creator);
//        roomList.add(newRoom);
//    }
    
    public void removeRoom(int id){
        int i=0;
        while(i<this.getTotalRoom() && this.getRoom(i).getId() != id)
            i++;
        this.getRoomList().remove(i);
    }
    
}
