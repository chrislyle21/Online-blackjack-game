/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author chris lyle
 */
public class Player
{
    private String playerName;
    private int playerCredits;
    private Bet bet;
    private Action playerAction;
    private PlayerHand hand;
    
    Player(String aName){
        this.playerName = aName;
    }
    
    int getPlayerCredits(){
        return this.playerCredits;
    }
    
    Action getPlayerAction(){
        return this.playerAction;
    }

    void setPlayerAction(Action anAction){
        this.playerAction = anAction;
    }
    
    Bet getBet(){
        return this.bet; 
    }
    
    void addCredits(int credits){
        this.playerCredits = (this.getPlayerCredits() + credits);
    }
    
    PlayerHand getPlayerHand(){
        return this.hand;
    }
    
    String getPlayerName(){
        return this.playerName;
    }
    public String toString(){
        return "Player name: " + this.getPlayerName() + "/nCredits: " + this.getPlayerCredits();
    }
    
    void deductCredits(int credits){
        this.playerCredits = (this.playerCredits - credits);
    }
}
