package blackjackTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import blackjack.*;
import org.junit.Test;

/**
 *
 * @author Chris Lyle
 */
public class TestBlackjackCoord
{
    BlackjackCoord bjCoord = new BlackjackCoord(5, 6);
    String[] nameArr = {"Joe Bloggs", "Chris Long", "Paul Short"};
            
    @Test
    public void testAddPlayer(){
        for(int n = 0; n < nameArr.length; n++){
            bjCoord.addPlayer(nameArr[n]);
        }
        try{
        assert bjCoord.getPlayers().size() == 3: 
                " players should contain 3 Players";
        
        }
        catch(Exception e){
            assert false: "No exception should be thrown\nError: " + e.toString();
        }       
    }

    @Test
    public void testDealCards(){
        for(int n = 0; n < nameArr.length; n++){
            bjCoord.addPlayer(nameArr[n]);
        }
       
        bjCoord.dealCards();
        
        try{
            for(Player each : bjCoord.getPlayers()){
                assert bjCoord.getPlayerHandSize(each) == 1: 
                        "Each hand sould contain only 1 Card object";
            }
        }
        catch(Exception e){
            assert false: "No exception should be thrown" + e.toString();
        }
    }
}
