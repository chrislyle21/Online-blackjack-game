/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Dealer
{
    private List<Deck> decks;
    private Action dealerAction;
    private DealerHand dealerHand;
    
    Dealer(){
        this.dealerHand = new DealerHand();
        this.decks = new ArrayList<>();
    }
    
    List
}
