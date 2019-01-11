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
public final class Deck
{
    private final Card[] cardArr;
    
    Deck(){
        this.cardArr = new Card[52];
        this.generateDeck();
    }
    
    void generateDeck(){
        int counter = 0;
        for(Suit each : Suit.values()){
            for(Value eachVal : Value.values()){
                cardArr[counter] = new Card(eachVal, each);
                counter++;
            }
        }
    }
    
    Card[] getDeck(){
        return this.cardArr;
    }
    
    @Override
    public String toString(){
        return "Deck size is: " + this.getDeck().length;
    }
    
    
}
