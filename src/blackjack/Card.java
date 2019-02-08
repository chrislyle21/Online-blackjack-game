/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author chris
 */
class Card implements Comparable<Card>
{

    private final Value value;
    private final Suit suit;

    Card(Value aValue, Suit aSuit)
    {
        this.value = aValue;
        this.suit = aSuit;
    }

    Value getValue()
    {
        return this.value;
    }

    Suit getSuit()
    {
        return this.suit;
    }

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

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if (obj != null || obj.getClass() == this.getClass())
        {
            Card otherCard = ((Card) obj);
            if (this.getValue() == otherCard.getValue() && otherCard.getSuit() == this.getSuit())
            {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int faceCard = 0;
        switch (this.getValue())
        {
            case JACK:
                faceCard = 10;
                break;
            case QUEEN:
                faceCard = 11;
                break;
            case KING:
                faceCard = 12;
                break;
            default:
                break;
        }
        return (this.getValue().getNumVal() + faceCard);
    }

    @Override
    public String toString()
    {
        return this.getValue() + " of " + this.getSuit()
                + " has a value of " + this.getValue().getNumVal();
    }
}
