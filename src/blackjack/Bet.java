/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 * This class is an in game bet and will be linked to a Player object. 
 * @author Chris Lyle
 */
class Bet
{

    private final Player player; 
    private int betAmount;

    /**
     * Creates a new Bet object linked to aPlayer with the bet amount set to 
     * anAmount.
     * @param aPlayer
     * @param anAmount 
     */
    Bet(Player aPlayer, int anAmount)
    {
        this.player = aPlayer;
        this.betAmount = anAmount;
    }

    /**
     * 
     * @return int
     */
    int getBetAmount()
    {
        return this.betAmount;
    }

    /**
     * 
     * @return Player
     */
    Player getPlayer()
    {
        return this.player;
    }

    /**
     * A string representation of this object linked to a Player object and 
     * this objects bet amount.
     * @return 
     */
    @Override
    public String toString()
    {
        return "Player; " + this.getPlayer()
                + " has £" + this.getBetAmount();
    }
}
