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

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Chris Lyle This class controls the dealing, combining and shuffling
 * of all the Card objects. The Dealer class plays in a card game with a limited
 * amount of actions.
 */
class Dealer
{

    // A list of Deck objects each Deck contains 52 Card abjects.
    private final List<Deck> decks;
    // All Card objects extracted and combined in to 1 larger Card List.
    private final List<Card> combinedDecks;
    private Action dealerAction;
    private final Hand dealerHand;
    private final int numOfDecks;

    /**
     * Creates a new Dealer object with the number of Deck objects used in game
     * set to numOfDecks.
     *
     * @param deckAmount - is used with addDecks()
     * @see Dealer#addDecks()
     */
    Dealer(int deckAmount)
    {
        this.dealerHand = new Hand();
        this.decks = new ArrayList<>();
        this.combinedDecks = new ArrayList<>();
        this.numOfDecks = deckAmount;
    }

    /**
     * Creates numOfDecks amount of Deck objects and returns a list of Deck
     * objects.
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
     * Calls combineDecks, then shuffles the list of card objects.
     *
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
     * Returns a list of Deck objects linked to the receiver.
     *
     * @return List<Deck>
     */
    List<Deck> getDecks()
    {
        return this.decks;
    }

    /**
     * Returns a list of Card objects.
     *
     * @return List<Card>
     */
    List<Card> getCombinedDecks()
    {
        return this.combinedDecks;
    }

    /**
     * Returns a Action object linked to the receiver.
     *
     * @return this.Action
     */
    Action getDealerAction()
    {
        return this.dealerAction;
    }

    /**
     * Sets the Action object linked to the receiver.
     *
     * @param anAction
     */
    void setDealerAction(Action anAction)
    {
        this.dealerAction = anAction;
    }

    /**
     * Returns the Hand object linked to the receiver.
     *
     * @return Dealer.DealerHand
     */
    Hand getDealerHand()
    {
        return this.dealerHand;
    }

    /**
     * Adds 1 Card object to the players Hand object.
     *
     * @param aHand
     * @param aCard
     * @see Hand#addToHand(blackjack.Card)
     */
    void addToPlayerHand(Hand aHand, Card aCard)
    {
        aHand.addToHand(aCard);
        aHand.setHandValue(aCard.getValue().getNumVal());
    }

    /**
     * Clears the Card objects from this DealerHand
     */
    void resetDealerHand()
    {
        this.getDealerHand().getCards().clear();
    }

    /**
     * A string representation of the Deck objects linked to the receiver and
     * the receiver’s last action
     *
     * @return this.String
     */
    @Override
    public String toString()
    {
        return "Number of decks: " + this.getDecks().size()
                + "\nDealer action = " + this.getDealerAction();
    }
}