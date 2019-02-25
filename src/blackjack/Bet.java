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
     * Return the bet amount linked to the receiver.
     * 
     * @return int
     */
    int getBetAmount()
    {
        return this.betAmount;
    }

    /**
     * Return the Player object linked to the receiver.
     * 
     * @return Player
     */
    Player getPlayer()
    {
        return this.player;
    }

    /**
     * returns the players name and the bet amount linked to this Bet object.
     * 
     * @return String
     */
    @Override
    public String toString()
    {
        return "Player; " + this.getPlayer().getPlayerName()
                + " has £" + this.getBetAmount();
    }
}
