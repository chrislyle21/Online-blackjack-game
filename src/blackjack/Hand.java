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

import java.util.ArrayList;
import java.util.List;

/**
 *A hand of cards for a dealer or a player in a card game
 * 
 * @author Chris Lyle
 */
public class Hand
{

    private int handValue;
    private final List<Card> cards;
    
    /**
     * Sets up an empty Hand object
     */
    Hand()
    {
        this.handValue = 0;
        this.cards = new ArrayList<>();
    }
    
    /**
     * Increments the handValue by aVal
     * 
     * @param aVal 
     */
    void setHandValue(int aVal)
    {
        this.handValue = this.getHandValue() + aVal;

    }
    
    /**
     * returns the value of this Hand object
     * 
     * @return int
     */
    int getHandValue()
    {
        return this.handValue;
    }

    /**
     * Clears all the Card objects from this Hand object
     */
    void resetHandValue()
    {
        this.handValue = 0;
    }

    /**
     * Returns the Card objects linked to this Hand object
     * 
     * @return List<Card>
     */
    List<Card> getCards()
    {
        return this.cards;
    }

    /**
     * Increments this Hand object by aCard
     * 
     * @param aCard 
     */
    void addToHand(Card aCard)
    {
        this.cards.add(aCard);
    }

    /**
     * Decrements this Hand object by aCard
     * 
     * @param aCard 
     */
    void removeFromHand(Card aCard)
    {
        this.cards.remove(aCard);
    }

    /**
     * Returns a string representation of this Hand object
     * 
     * @return String 
     */
    @Override
    public String toString()
    {
        return "Hand size = " + this.getCards().size();             
    }
}
