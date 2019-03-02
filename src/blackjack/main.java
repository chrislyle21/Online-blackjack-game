/* 
 * The MIT License
 *
 * Copyright 2019 Chris Lyle.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blackjack;

import java.util.List;
import java.util.Set;

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
        bjCoord.getDealer().shuffleDecks();
        bjCoord.dealCards();
        
      
        System.out.println(bjCoord.getDealer().getCombinedDecks().size());
        List<Card> temp;

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
            bjCoord.playerActions(each);
        }
        
        
        
            System.out.println(bjCoord.getPlayerActions());
            System.out.println(bjCoord.getDealer().getDealerHand().getCards());

    }


}
