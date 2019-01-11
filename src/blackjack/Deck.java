/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chris
 */
public final class Deck
{
    private Card[] cardArr;
    
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
    
    public void printDeck()
    {
        String str ="";
        for (Card card : cardArr)
        {
            str += card.toString() + "\n";
        }
        System.out.println(str);
    }
}
