/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Chris Lyle
 * This class represents a player in a card game.
 */
public class Player implements Comparable<Player>
{

    private String playerName;
    private int playerCredits;
    private Bet bet;
    private Action playerAction;
    private PlayerHand playerHand;
    /**
     * Creates a new Player object with the name aName.
     * Creates a new PlayerHand object and links itr to the receiver.
     * @param aName 
     */
    Player(String aName)
    {
        this.playerName = aName;
        this.playerHand = new PlayerHand();
    }
    /**
     * Returns the PlayerHand object linked to the receiver.
     * 
     * @return PlayerHand 
     */
    PlayerHand getPlayerHand()
    {
        return this.playerHand;
    }
    
    /**
     * Returns a String object representing the name of the receiver. 
     * 
     * @return String 
     */
    String getPlayerName()
    {
        return this.playerName;
    }

    /**
     * Returns the amount of credits linked to the receiver.  
     * 
     * @return int
     */
    int getPlayerCredits()
    {
        return this.playerCredits;
    }

    /**
     * Return the Action object linked to the receiver.
     * 
     * @return Action
     */
    Action getPlayerAction()
    {
        return this.playerAction;
    }

    /**
     * Sets the Action object linked to the receiver to the Action anAction.
     * 
     * @param anAction 
     */
    void setPlayerAction(Action anAction)
    {
        this.playerAction = anAction;
    }

    /**
     * Returns the Bet object linked to the receiver.
     * 
     * @return Bet
     */
    Bet getBet()
    {
        return this.bet;
    }

    /**
     * Set the Bet object linked to the receiver to the Bet aBet.
     * 
     * @param aBet 
     */
    void setBet(Bet aBet)
    {
        this.bet = aBet;
    }

    /**
     * Increments the credits linked to the receiver by the amount credits.
     * 
     * @param credits
     * @return boolean 
     */
    boolean addCredits(int credits)
    {
        boolean result = false;
        if (credits > 0)
        {
            this.playerCredits = (this.getPlayerCredits() + credits);
            result = true;
        }
        return result;
    }

    /**
     * Deducts the credits linked to the receiver by the amount credits.
     * 
     * @param credits
     * @return int 
     */
    int deductCredits(int credits)
    {
        if ((this.getPlayerCredits() - credits) > 0)
        {
            this.playerCredits = (this.playerCredits - credits);
        }
        return this.getPlayerCredits();
    }

    /**
     * Clears the Hand object linked to the receiver
     */
    void resetPlayerHand()
    {
        this.getPlayerHand().getCards().clear();
    }

    /**
     * Compares thisPlayer object to aPlayer by the amount of credits that is 
     * linked to the receiver.
     * 
     * @param aPlayer
     * @return int
     */
    @Override
    public int compareTo(Player aPlayer)
    {
        int result = 0;
        if (aPlayer == null || aPlayer.getClass() != this.getClass())
        {
            result = -1;
        }
        else
        {
            result = this.getPlayerCredits() - aPlayer.getPlayerCredits();
        }
        return result;
    }

    /**
     * Returns a string representation of the receiver.
     * 
     * @return String
     */
    @Override
    public String toString()
    {
        return "Player name: " + this.getPlayerName() + "/nCredits: " 
                + this.getPlayerCredits();
    }
}
