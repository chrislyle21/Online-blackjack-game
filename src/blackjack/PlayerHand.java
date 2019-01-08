/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.List;

/**
 *
 * @author chris
 */
public class PlayerHand extends Hand
{
    PlayerHand(){
        super();
    }
    
    PlayerHand splitHand(PlayerHand aHand){
        PlayerHand handTwo = new PlayerHand();
        handTwo.addToHand(this.getCards().get(1));
        this.getCards().remove(this.getCards().get(1));
        return handTwo;
    }
}

