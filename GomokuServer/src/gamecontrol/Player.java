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
    int symbolId;

    /* CONSTRUCTOR */
    public Player(int Id, String nickname, int symbolId){
        this.setId(Id);
        this.setNickname(nickname);
        this.setSymbolId(symbolId);
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

    /* METHOD */
}
