/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
abstract class Hand
{

    private int handValue;
    private final List<Card> cards;

    Hand()
    {
        this.handValue = 0;
        this.cards = new ArrayList<>();
    }

    void setHandValue(int aVal)
    {
        this.handValue = this.getHandValue() + aVal;

    }

    int getHandValue()
    {
        return this.handValue;
    }

    List<Card> getCards()
    {
        return this.cards;
    }

    void addToHand(Card aCard)
    {
        this.cards.add(aCard);
    }

    void removeFromHand(Card aCard)
    {
        this.cards.remove(aCard);
    }

    public int getHandSize(Player aPlayer)
    {
        return this.getCards().size();
    }
}
