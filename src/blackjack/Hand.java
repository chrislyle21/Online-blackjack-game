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
class Hand
{

    private int handValue;
    private final List<Card> cards;

    Hand()
    {
        this.handValue = 0;
        this.cards = new ArrayList<>();
    }

    void addToHand(Card aCard)
    {
        this.cards.add(aCard);
    }

    void removeFromHand(Card aCard)
    {
        this.cards.remove(aCard);
    }

    List<Card> getCards()
    {
        return this.cards;
    }

    int getHandValue()
    {
        this.setHandValue();
        return this.handValue;
    }

    private void setHandValue()
    {

        for (Card each : this.cards)
        {
            this.handValue = this.handValue + each.getValue().getNumVal();
        }
    }
}
