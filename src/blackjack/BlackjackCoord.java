/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public BlackjackCoord(int aMinBet)
    {
        this.minimumBet = aMinBet;
        this.dealer = new Dealer();
        this.players = new ArrayList<>();
    }

    public Dealer getDealer()
    {
        return this.dealer;
    }

    public List<Player> getPlayers()
    {
        return this.players;
    }

    public PlayerHand getPlayerHand(Player aPlayer)
    {
        return aPlayer.getPlayerHand();
    }

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
     * @return
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

    public Action getDealerAction()
    {

        return this.getDealer().getDealerAction();
    }

    public void setDealerAction(String anAction)
    {
        Action action = Action.valueOf(anAction);
        this.getDealer().setDealerAction(action);
    }

    public void setPlayerAction(Player aPlayer, String anAction)
    {
        Action action = Action.valueOf(anAction);
        aPlayer.setPlayerAction(action);
    }

    public int getMinimumBet()
    {
        return this.minimumBet;
    }

    @Override
    public String toString()
    {
        return "Game has " + this.players.size() + " players and a miminum bet of £"
                + this.getMinimumBet();
    }
}
