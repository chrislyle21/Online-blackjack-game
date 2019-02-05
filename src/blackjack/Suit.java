/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Chris Lyle
 */
enum Suit
{
    HEARTS(2),
    DIAMONDS(3),
    CLUBS(4),
    SPADES(5);

    private final int suitVal;

    private Suit(int aSuitVal)
    {
        this.suitVal = aSuitVal;
    }

    int getSuitVal()
    {
        return this.suitVal;
    }
}
