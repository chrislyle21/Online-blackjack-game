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
        return this.getValue() + " of " + this.getSuit();
    }
    
    /**@Override
    public int compareTo(Card obj){
        if (obj != null){
            Card card = obj;
            
            if (this.getValue() > card.getValue() && 
                    this.getSuit().equals(card.getSuit())){
                return 1;
            }
            else if (this.getValue() < card.getValue() && this.getSuit().equals(card.getSuit()))
                    {
                return -1;
            }
        }
        return result;**/
}

