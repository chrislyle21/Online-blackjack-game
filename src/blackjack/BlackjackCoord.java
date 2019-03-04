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
 * This is the coordinating class for a game of the card game Blackjack.
 *
 * @author chris
 */
public class BlackjackCoord
{

    private int counter;
    private final int minimumBet;
    private final Dealer dealer;
    private final List<Player> players;
    private Set<Action> actionSet;
    private Map<Player, Set<Action>> playerActions;

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
        actionSet = new HashSet<>();
        playerActions = new HashMap<>();
    }

    /**
     * Returns the Dealer object linked to the receiver.
     *
     * @return Dealer
     */
    public Dealer getDealer()
    {
        return this.dealer;
    }

    public Map<Player, Set<Action>> getPlayerActions()
    {
        return this.playerActions;
    }

    /**
     * Returns a list of Player objects linker to the receiver.
     *
     * @return List<Player>
     */
    public List<Player> getPlayers()
    {
        return this.players;
    }

    /**
     * Returns the Hand object linked to aPlayer.
     *
     * @param aPlayer
     * @return Hand
     */
    public Hand getPlayerHand(Player aPlayer)
    {
        return aPlayer.getPlayerHand();
    }

    /**
     * Return the size of the Hand object linked to aPlayer.
     *
     * @param aPlayer
     * @return int
     */
    public int getPlayerHandSize(Player aPlayer)
    {
        return aPlayer.getPlayerHand().getCards().size();
    }

    /**
     * Adds a Player object to a game of Blackjack with the String aName as the
     * Player objects name and a 100 credits.
     *
     * @param aName
     */
    public void addPlayer(String aName)
    {
        Player player = new Player(aName);
        player.addCredits(1000);
        this.players.add(player);
    }

    /**
     * Returns a Map with a Dealer object as the key and a List of Player
     * objects as the value.
     *
     * @return Map<Dealer, List<Player>>
     */
    public Map<Dealer, List<Player>> getDealerAndPlayers()
    {
        Map<Dealer, List<Player>> dealersAndPlayers = new HashMap<>();
        dealersAndPlayers.put(this.getDealer(), this.getPlayers());
        return dealersAndPlayers;
    }

    /**
     * Returns a Set of Bet objects.
     *
     * @return Set<Bet>
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
     *
     * @param aPlayer
     * @param aBet
     * @return boolean
     */
    public boolean placeBet(Player aPlayer, int aBet)
    {
        boolean result = false;

        if ((aBet >= minimumBet) && ((aPlayer.getPlayerCredits() - aBet) > 0)
                && aPlayer.getPlayerHand().getHandValue() < 21 &&
                    aPlayer.getPlayerAction() != Action.STAND)
        {
            aPlayer.setBet(new Bet(aPlayer, aBet));
            aPlayer.deductCredits(aBet);
            result = true;
        }

        return result;
    }

    /**
     * Deals one card to each Player object. The variable Counter is used to
     * track the position is the deck.
     *
     * @see Dealer#addToPlayerHand(blackjack.Hand, blackjack.Card)
     */
    public void dealToPlayers()
    {
        for (Player each : this.getPlayers())
        {
            if (each.getPlayerHand().getHandValue() < 21 &&
                    each.getPlayerAction() != Action.STAND)
            {
                this.getDealer().addToPlayerHand(each.getPlayerHand(),
                    this.getDealer().getCombinedDecks().remove(this.counter));
                this.counter++;
            }
        }
    }
    
    public void dealToDealer()
    {
        if (this.getDealer().getDealerAction() != Action.STAND &&
                this.getDealer().getDealerHand().getHandValue() < 21)
        {
            this.getDealer().addToDealerHand(this.getDealer()
                    .getCombinedDecks().remove(counter));
            this.counter++;
        }
        else
        {
            System.out.println(this.getDealer().getDealerHand().toString());
        }
    }

    /**
     *
     *
     * @param aPlayer
     * @return Set<Action>
     */
    public Map<Player, Set<Action>> playerActions(Player aPlayer)
    {
        Set<Action> tmpSet = new HashSet<>();
        if (aPlayer.getPlayerAction() != Action.STAND)
        {            
            this.surrender(aPlayer);
            this.insurance(aPlayer);
            this.doubleUp(aPlayer);
            this.hit(aPlayer);
            this.stand(aPlayer);
            this.split(aPlayer);
        }
        if (aPlayer.getPlayerHand().getHandValue() > 21)
        {
            this.actionSet.add(Action.BUST);
        }
        else if (aPlayer.getPlayerHand().getHandValue() == 21) 
        {
            this.actionSet.add(Action.WINNER);
        }
        tmpSet.addAll(this.actionSet);
        this.actionSet.clear();
        this.playerActions.put(aPlayer, tmpSet);
        return this.playerActions;
    }

    /**
     *
     *
     * @param aPlayer
     */
    private void split(Player aPlayer)
    {
        if (aPlayer.getPlayerHand().getHandValue() < 21 && 
                aPlayer.getPlayerHand().getCards().size() > 1 && 
                aPlayer.getPlayerHand().getHandValue() < 21 && 
                aPlayer.getPlayerHand().getCards().get(0).equals(
                        aPlayer.getPlayerHand().getCards().get(1)))
        {
            this.actionSet.add(Action.SPLIT);
        }
    }

    public Action dealerActions()
    {
        int handVal = this.getDealer().getDealerHand().getHandValue();
        if (handVal <= 16)
        {
            this.getDealer().setDealerAction(Action.HIT);
        }
        else if (handVal > 16 && handVal < 21)
        {
            this.getDealer().setDealerAction(Action.STAND);
        }
        else
        {
            this.getDealer().setDealerAction(Action.BUST);
        }
        return this.getDealer().getDealerAction();
    }

    /**
     *
     *
     * @param aPlayer
     */
    private void stand(Player aPlayer)
    {
        if (aPlayer.getPlayerHand().getHandValue() < 21)
        {
            this.actionSet.add(Action.STAND);
        }
    }

    /**
     *
     * @param aPlayer
     */
    private void hit(Player aPlayer)
    {
        if (aPlayer.getPlayerHand().getHandValue() < 21)
        {
            this.actionSet.add(Action.HIT);
        }
    }

    /**
     *
     *
     * @param aPlayer
     */
    private void doubleUp(Player aPlayer)
    {
        if (aPlayer.getPlayerHand().getCards().size() < 3 && aPlayer.getPlayerHand().getHandValue() < 21 && aPlayer.getPlayerCredits() >= (this.getMinimumBet() / 2))
        {
            this.actionSet.add(Action.DOUBLE);
        }
    }

    /**
     *
     *
     * @param aPlayer
     */
    private void surrender(Player aPlayer)
    {
        if (this.getDealer().getDealerHand().getCards().size() > 0 && this.getDealer().getDealerHand().getCards().get(0).getValue() != Value.ACE && aPlayer.getPlayerHand().getCards().size() == 1)
        {
            this.actionSet.add(Action.SURRENDER);
        }
    }

    /**
     *
     *
     * @param aPlayer
     */
    private void insurance(Player aPlayer)
    {
        if (this.getDealer().getDealerHand().getCards().size() > 0 && this.getPlayerHand(aPlayer).getHandValue() < 21 && this.getDealer().getDealerHand().getCards().get(0).getValue() == Value.ACE && aPlayer.getPlayerCredits() >= (this.getMinimumBet() / 2))
        {
            this.actionSet.add(Action.INSURANCE);
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
