/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Chris Lyle
 */
public class main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BlackjackCoord bjCoord = new BlackjackCoord(5);
        String[] nameArr =
        {
            "Joe Bloggs", "Chris Long", "Paul Short"
        };
        for (int n = 0; n < nameArr.length; n++)
        {
            bjCoord.addPlayer(nameArr[n]);
        }
        bjCoord.getDealer().shuffleDecks();
       
        bjCoord.dealCards();
        bjCoord.dealCards();
        for (Player each : bjCoord.getPlayers())
        {
            System.out.print(each.getPlayerHand().getCards().toString() + "\n");
            System.out.print(each.getPlayerName() + ": hand = " + each.getPlayerHand().getHandValue() + "\n");
        }
        System.out.println(bjCoord.toString());
        
    }

}
