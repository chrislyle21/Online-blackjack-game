/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 * This class is a deck of 52 Card objects.
 * @author Chris Lyle
 */
final class Deck
{

    private final Card[] cardArr;

    /**
     * Creates a new Deck object with an array of 52 Card objects.
     */
    Deck()
    {
        this.cardArr = new Card[52];
        this.generateDeck();
    }

    /**
     * Returns an array of 52 Card objects.
     * @return Card[]
     */
    Card[] getCards()
    {
        return this.cardArr;
    }

    /**
     * Returns a card from specific index from 0 - 51.
     * @param index
     * @return Card
     */
    Card getCard(int index)
    {
        return cardArr[index];
    }

    /**
     * Adds 52 Card objects to an array.
     */
    void generateDeck()
    {
        int counter = 0;

        for (Suit each : Suit.values())
        {
            for (Value eachVal : Value.values())
            {
                cardArr[counter] = new Card(eachVal, each);
                counter++;
            }
        }

    }

    /**
     * Returns a string representation of the deck size. 
     * @return String
     */
    @Override
    public String toString()
    {
        return "Deck size is: " + this.getCards().length;
    }

}
