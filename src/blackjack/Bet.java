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
 * This class is an in game bet and will be linked to a Player object. 
 * @author Chris Lyle
 */
class Bet implements Comparable<Bet>
{

    private final Player player;
    private final int betAmount;

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
     * returns 0if the receiver is of equal positioning, negative
     * if the receiver is before otherBet and positive if the receiver comes 
     * after otherBet.
     * 
     * @param otherBet
     * @return int
     */
    @Override
    public int compareTo(Bet otherBet)
    {            
        return this.getBetAmount() - otherBet.getBetAmount();
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
