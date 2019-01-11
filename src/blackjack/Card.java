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
public class Card
{
    private Value value;
    private Suit suit;
    
    Card(Value aValue, Suit aSuit){
        this.value = aValue;
        this.suit = aSuit;
    }
    
    Value getValue(){
        return this.value;
    }
    
    Suit getSuit(){
        return this.suit;
    }
    
    public String toString(){
        return this.getValue() + " of " + this.getSuit()
                + " has a value of " + this.getValue().getNumVal();
    }
}

