/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.List;

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
        BlackjackCoord bjCoord = new BlackjackCoord(5, 6);
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
        List<Card> temp = new ArrayList<>();

        for (Player each : bjCoord.getPlayers())
        {
            System.out.print(each.getPlayerHand().getCards().toString() + "\n");
            System.out.print(
                    each.getPlayerName() + ": hand = " + each.getPlayerHand().getHandValue() + "\n");
            temp = each.getPlayerHand().getCards();
            for (Card eachCard : temp)
            {
                System.out.println(eachCard.hashCode());
            }

        }
        System.out.println(bjCoord.toString());

    }

}
