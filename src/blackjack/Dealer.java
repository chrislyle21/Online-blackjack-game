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
 * @author Chris Lyle
 * This class controls the dealing, combining and shuffling of all the Card 
 * objects.
 * The Dealer class plays in a game of blackjack with a limited amount of 
 * actions.
 */
class Dealer
{
    // A list of Deck objects each Deck contains 52 Card abjects.
    private final List<Deck> decks; 
    // All Card objects extracted and combined in to 1 larger Card List.
    private List<Card> combinedDecks;
    private Action dealerAction;
    private DealerHand dealerHand;
    private int numOfDecks;

    /**
     * Creates a new Dealer object with the number of Deck objects used in game
     * set to numOfDecks.
     * @param deckAmount - is used with addDecks()
     * @see Dealer#addDecks()
     */
    Dealer(int deckAmount)
    {
        this.dealerHand = new DealerHand();
        this.decks = new ArrayList<>();
        this.combinedDecks = new ArrayList<>();
        this.numOfDecks = deckAmount;
    }

    /**
     * 
     * @return List<Deck>
     */
    private List<Deck> addDecks()
    {
        for (int n = 0; n < this.numOfDecks; n++)
        {
            this.decks.add(n, new Deck());
        }

        return this.decks;
    }

    /**
     * All Card objects are extracted and combined in to 1 larger Card List.
     */
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

    /**
     * The Card list is shuffled.
     * @see Dealer#combineDecks() 
     */
    void shuffleDecks()
    {
        this.combineDecks();
        for (int n = 0; n < 4; n++)
        {
            Collections.shuffle(this.combinedDecks);

        }
    }

    /**
     *
     * @return List<Deck>
     */
    List<Deck> getDecks()
    {
        return this.decks;
    }

    /**
     *
     * @return List<Card>
     */
    List<Card> getCombinedDecks()
    {
        return this.combinedDecks;
    }

    /**
     *
     * @return this.Action
     */
    Action getDealerAction()
    {
        return this.dealerAction;
    }

    /**
     *
     * @param anAction
     */
    void setDealerAction(Action anAction)
    {
        this.dealerAction = anAction;
    }

    /**
     *
     * @return Dealer.DealerHand
     */
    DealerHand getDealerHand()
    {
        return this.dealerHand;
    }

    /**
     * Adds 1 Card object to the players PlayerHand object.
     * @param aHand
     * @param aCard
     * @see Hand#addToHand(blackjack.Card)
     */
    void addToPlayerHand(Hand aHand, Card aCard)
    {
        aHand.addToHand(aCard);
    }

    /**
     * Clears the Card objects from this DealerHand
     */
    void resetDealerHand()
    {
        this.getDealerHand().getCards().clear();
    }

    /**
     * A string representation of the Deck objects linked to the receiver and the 
     * receiver’s last action
     * @return this.String
     */
    @Override
    public String toString()
    {
        return "Number of decks: " + this.getDecks().size()
                + "\nDealer action = " + this.getDealerAction();
    }
}
