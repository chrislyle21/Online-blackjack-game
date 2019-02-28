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
 * @author Chris Lyle This class is a deck of 52 Card objects.
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
     *
     * @return Card[]
     */
    Card[] getCards()
    {
        return this.cardArr;
    }

    /**
     * Returns a card from specific index from 0 - 51.
     *
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
     *
     * @return String
     */
    @Override
    public String toString()
    {
        return "Deck size is: " + this.getCards().length;
    }
}
