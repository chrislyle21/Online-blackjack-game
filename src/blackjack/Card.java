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
    public int hashCode(){
        int suit = 0;
        if (this.getSuit().equals("HEARTS")){
            suit = 2;
        }
        else if (this.getSuit().equals("SPADES")){
            suit = 3;
        }
        else if (this.getSuit().equals("CLUBS")) {
            suit = 4;
        }
        else{
        suit = 5;
        }
        return (int) (Math.pow(this.getValue().getNumVal(), suit));
    }

    @Override
    public String toString()
    {
        return this.getValue() + " of " + this.getSuit()
                + " has a value of " + this.getValue().getNumVal();
    }
}
