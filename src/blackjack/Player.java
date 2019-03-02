/* 
 * The MIT License
 *
 * Copyright 2019 Chris Lyle.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blackjack;

/**
 *
 * @author Chris Lyle
 * This class represents a player in a card game.
 */
public class Player implements Comparable<Player>
{

    private final String playerName;
    private int playerCredits;
    private Bet bet;
    private Action playerAction;
    private final Hand playerHand;
    
    /**
     * Creates a new Player object with the name aName.
     * Creates a new Hand object and links it to the receiver.
     * 
     * @param aName 
     */
    Player(String aName)
    {
        this.playerName = aName;
        this.playerHand = new Hand();
    }
    /**
     * Returns the Hand object linked to the receiver.
     * 
     * @return Hand 
     */
    Hand getPlayerHand()
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
     * Compares this Player object to aPlayer by the amount of credits that is 
     * linked to the receiver.
     * 
     * @param aPlayer
     * @return int
     */    
    @Override
    public int compareTo(Player aPlayer)
    {
        return this.getPlayerCredits() - aPlayer.getPlayerCredits();
    }

    /**
     * Returns a string representation of the receiver.
     * 
     * @return String
     */
    @Override
    public String toString()
    {
        return "Player name: " + this.getPlayerName() + "\nCredits: " 
                + this.getPlayerCredits();
    }
}
