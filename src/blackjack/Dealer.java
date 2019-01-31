/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author chris
 */
class Dealer
{

    private final List<Deck> decks;
    private List<Card> combinedDecks;
    private Action dealerAction;
    private DealerHand dealerHand;

    Dealer()
    {
        this.dealerHand = new DealerHand();
        this.decks = new ArrayList<>();
        this.combinedDecks = new ArrayList<>();
    }

    private List<Deck> addDecks()
    {
        for (int n = 0; n < 6; n++)
        {
            this.decks.add(n, new Deck());
        }

        return this.decks;
    }

    private void combineDecks()
    {

        for (Deck eachDeck : this.addDecks())
        {
            for (int n = 0; n < eachDeck.getCards().length; n++)
            {
                this.combinedDecks.add(eachDeck.getCard(n));
            }

        }
    }

    void shuffleDecks()
    {
        this.combineDecks();
        for (int n = 0; n < 4; n++)
        {
            Collections.shuffle(this.combinedDecks);

        }
    }

    List<Deck> getDecks()
    {
        return this.decks;
    }

    Action getDealerAction()
    {
        return this.dealerAction;
    }

    void setDealerAction(Action anAction)
    {
        this.dealerAction = anAction;
    }

    DealerHand getDealerHand()
    {
        return this.dealerHand;
    }

    Card dealCards(Player aPlayer, int index)
    {
        aPlayer.getPlayerHand().addToHand(this.combinedDecks.get(index));
        return this.combinedDecks.remove(index);
    }

    void addToPlayerHand(Hand aHand, Card aCard)
    {
        aHand.addToHand(aCard);
    }

    void resetDealerHand()
    {
        this.getDealerHand().getCards().clear();
    }

    @Override
    public String toString()
    {
        return "Number of decks: " + this.getDecks().size()
                + "\nDealer action = " + this.getDealerAction();
    }
}
