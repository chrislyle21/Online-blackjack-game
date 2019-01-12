/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author chris
 */
class Dealer
{
    private List<Deck> decks;
    private Action dealerAction;
    private DealerHand dealerHand;
    
    Dealer(){
        this.dealerHand = new DealerHand();
        this.decks = new ArrayList<>();
    }
    
    List<Deck> getDecks(){
        for(int n = 0; n < 6; n++){
            this.decks.add(n, new Deck());
        }
        return this.decks;
    }
    
    Action getDealerAction(){
        return this.dealerAction;
    }
    
    void setAction(Action anAction){
        this.dealerAction = anAction;
    }
    
    DealerHand getDealerHand(){
        return this.dealerHand;
    }
    
    List<Card> combineDecks(){
        List<Card> listArr;
        Card[] largeArr = new Card[312];
        int counter = 0;
        
        for(Deck eachDeck : this.getDecks()){
            for(int n = 0; n < eachDeck.getDeck().length; n++){
                largeArr[n] = eachDeck.getCard(n);
            }
            counter = counter + 52;
        }
        
        listArr = Arrays.asList(largeArr);
        return listArr;
    }
    
    List<Card> ShuffleDecks(){
        List<Card> shuffledList = this.combineDecks();
        Collections.shuffle(shuffledList);
        return shuffledList;
    }
    
    @Override
    public String toString(){
        return "Number of decks: " + this.getDecks().size() 
                + "\nDealer action = " + this.getDealerAction();
    }
}
