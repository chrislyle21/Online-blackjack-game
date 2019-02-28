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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public class BlackjackCoord
{

    private int counter;
    private final int minimumBet;
    private final Dealer dealer;
    private final List<Player> players;

    /**
     *
     * @param aMinBet
     * @param numberOfDecks
     */
    public BlackjackCoord(int aMinBet, int numberOfDecks)
    {
        this.minimumBet = aMinBet;
        this.dealer = new Dealer(numberOfDecks);
        this.players = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public Dealer getDealer()
    {
        return this.dealer;
    }

    /**
     *
     * @return
     */
    public List<Player> getPlayers()
    {
        return this.players;
    }

    /**
     *
     * @param aPlayer
     * @return
     */
    public Hand getPlayerHand(Player aPlayer)
    {
        return aPlayer.getPlayerHand();
    }
    
    /**
     * Return the Hand size of aPlayer.
     * 
     * @param aPlayer
     * @return int
     */
    public int getPlayerHandSize(Player aPlayer)
    {
        return aPlayer.getPlayerHand().getCards().size();
    }

    /**
     *
     * @param aName
     */
    public void addPlayer(String aName)
    {
        Player player = new Player(aName);
        player.addCredits(1000);
        players.add(player);
    }

    /**
     *
     * @return
     */
    public Map<Dealer, List<Player>> getDealerAndPlayers()
    {
        Map<Dealer, List<Player>> dealersAndPlayers = new HashMap<>();
        dealersAndPlayers.put(this.getDealer(), this.getPlayers());
        return dealersAndPlayers;
    }

    /**
     *
     * @return
     */
    public Set<Bet> getBets()
    {
        Set<Bet> bets = new HashSet<>();

        for (Player each : this.getPlayers())
        {
            bets.add(each.getBet());
        }

        return bets;
    }

    /**
     *
     * @param aPlayer
     * @param aBet
     * @return
     */
    public boolean placeBet(Player aPlayer, int aBet)
    {
        boolean result = false;

        if ((aBet >= minimumBet) && ((aPlayer.getPlayerCredits() - aBet) > 0))
        {
            aPlayer.setBet(new Bet(aPlayer, aBet));
            aPlayer.deductCredits(aBet);
            result = true;
        }

        return result;
    }

    /**
     * Deals one card to each Player object.  The variable Counter is used to 
     * track the position is the deck.
     * @see Dealer#addToPlayerHand(blackjack.Hand, blackjack.Card)
     */
    public void dealCards()
    {
        for (Player each : this.getPlayers())
        {
            this.getDealer().addToPlayerHand(each.getPlayerHand(), 
                    this.getDealer().getCombinedDecks().remove(this.counter));
            this.counter++;
        }
    }

    /**
     * 
     * @param aPlayer
     * @return aPlayer.Bet
     */
    public Bet getPlayerBet(Player aPlayer)
    {
        return aPlayer.getBet();
    }

    /**
     *
     * @param aPlayer
     * @return aPlayer.Action
     */
    public Action getPlayerAction(Player aPlayer)
    {
        return aPlayer.getPlayerAction();
    }

    /**
     *
     * @return Dealer.Action
     */
    public Action getDealerAction()
    {

        return this.getDealer().getDealerAction();
    }

    /**
     * 
     * @param anAction
     */
    public void setDealerAction(String anAction)
    {
        Action action = Action.valueOf(anAction);
        this.getDealer().setDealerAction(action);
    }

    /**
     *
     * @param aPlayer
     * @param anAction
     */
    public void setPlayerAction(Player aPlayer, String anAction)
    {
        Action action = Action.valueOf(anAction);
        aPlayer.setPlayerAction(action);
    }

    /**
     *
     * @return
     */
    public int getMinimumBet()
    {
        return this.minimumBet;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "Game has " + this.players.size() + " players and a miminum bet of £"
                + this.getMinimumBet();
    }
}
