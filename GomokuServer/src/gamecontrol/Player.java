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
public class Player {
    /* ATTRIBUTE */
    int id;
    String nickname;
    int roomId;
    int symbolId;

    /* CONSTRUCTOR */
    public Player(int Id, String nickname, int roomId, int symbolId){
        this.setId(Id);
        this.setNickname(nickname);
        this.setRoomId(roomId);
        this.setSymbolId(symbolId);
    }

    /* GETTER */
    public int getId(){
        return this.id;
    }

    public String getNickname(){
        return this.nickname;
    }

    public int getRoomId(){
        return this.roomId;
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

    public void setRoomId(int roomId){
        this.roomId = roomId;
    }

    public void setSymbolId(int symbolId){
        this.symbolId = symbolId;
    }

    /* METHOD */
}
