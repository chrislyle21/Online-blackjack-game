/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 * This class is a card used in game. This object uses two enums for the value
 * and the suit of this class.
 *
 * @author Chris Lyle
 */
class Card implements Comparable<Card>
{

    private final Value value;
    private final Suit suit;

    /**
     * Creates a new Card object with the value set to aValue and the suit set
     * to aSuit.
     *
     * @param aValue
     * @param aSuit
     */
    Card(Value aValue, Suit aSuit)
    {
        this.value = aValue;
        this.suit = aSuit;
    }

    /**
     *
     * @return Value
     */
    Value getValue()
    {
        return this.value;
    }

    /**
     *
     * @return Suit
     */
    Suit getSuit()
    {
        return this.suit;
    }

    /**
     * Compares this Card object with the use of the enum Value. returns a
     * negative if this object is before aCard, 0 if equal and positive if this
     * object comes after aCard.
     *
     * @param aCard
     * @return int
     * @see Value#getNumVal()
     */
    @Override
    public int compareTo(Card aCard)
    {
        int result = 0;

        if (this.getValue().getNumVal() < aCard.getValue().getNumVal())
        {
            result = -1;
        }
        else if (this.getValue().getNumVal() > aCard.getValue().getNumVal())
        {
            result = 1;
        }
        return result;
    }

    /**
     * returns true if the receiver is equal to obj. Otherwise returns false obj
     * must not be null and must be of the same class.
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if (obj != null || obj.getClass() == this.getClass())
        {
            Card otherCard = ((Card) obj);
            if (this.getValue() == otherCard.getValue()
                    && otherCard.getSuit() == this.getSuit())
            {
                result = true;
            }
        }
        return result;
    }


    /**
     * returns a calculated hash code for this class
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        int hashVal = 0;
        int faceCard = 0;
        int suitType = 0;
        switch (this.getValue())
        {
            case JACK:
                faceCard = 2;
                break;
            case QUEEN:
                faceCard = 3;
                break;
            case KING:
                faceCard = 4;
                break;
            default:
                break;
        }
        switch (this.getSuit())
        {
            case HEARTS:
                suitType = 15;
                break;
            case SPADES:
                suitType = 30;
                break;
            case CLUBS:
                suitType = 45;
                break;
            default:
                break;
        }
        hashVal = (this.getValue().getNumVal() + faceCard + suitType);
        return hashVal;
    }

    /**
     * returns a string representation of the Card object linked to this object
     *
     * @return String
     */
    @Override
    public String toString()
    {
        return this.getValue() + " of " + this.getSuit()
                + " has a value of " + this.getValue().getNumVal();
    }
}
