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
    private double playerCredits;
    private Bet bet;
    private Action playerAction;
    private PlayerHand playerHand;
    
    Player(String aName){
        this.playerName = aName;
    }
    
    double getPlayerCredits(){
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
    
    void setBet(Bet aBet){
        this.bet = aBet;
    }
    
    void addCredits(double credits){
        this.playerCredits = (this.getPlayerCredits() + credits);
    }
    
    PlayerHand getPlayerHand(){
        return this.playerHand;
    }
    
    String getPlayerName(){
        return this.playerName;
    }
    public String toString(){
        return "Player name: " + this.getPlayerName() + "/nCredits: " + this.getPlayerCredits();
    }
    
    void deductCredits(double credits){
        this.playerCredits = (this.playerCredits - credits);
    }
}
