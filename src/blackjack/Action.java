/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 * This enum controls the options for the decisions made by Player objects and
 * Dealer objects in game.
 * @author Chris Lyle
 */
enum Action
{
    HIT, // Option to receive a new card.
    STAND, // Option to stay with hand.
    BUST, // Option when a players hand score is over 21.
    INSURANCE, // Option to add insurance. 
    SPLIT, // Option to split the hand.
    DOUBLE, // Option increase the size of a bet
    SURRENDER; // Oprtion to give up.
}
