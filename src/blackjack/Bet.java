/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author chris
 */
class Bet
{
    private final Player player;
    private double betAmount;
    
    Bet(Player aPlayer, double anAmount){
        this.player = aPlayer;
        this.betAmount = anAmount;        
    }
    
    double getBetAmount(){
        return this.betAmount;
    }
    
    Player getPlayer(){
        return this.player;
    }
    
    @Override
    public String toString(){
        return "Player; " + this.getPlayer()
                + " has £" + this.getBetAmount();
    }
}
