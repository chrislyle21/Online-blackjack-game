/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
