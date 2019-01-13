/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public class BlackjackCoord
{

    private final double minimumBet;
    private final Dealer dealer;
    private final Set<Player> players;
    private List<Card> decks;

    public BlackjackCoord(double aMinBet)
    {
        this.minimumBet = aMinBet;
        this.dealer = new Dealer();
        this.players = new HashSet<>();
        this.decks = new ArrayList<>();
    }

    public Dealer getDealer()
    {
        return this.dealer;
    }

    public Set<Player> getPlayers()
    {
        return this.players;
    }

    public PlayerHand getPlayerHand(Player aPlayer)
    {
        return aPlayer.getPlayerHand();
    }

    public int getPlayerHandSize(Player aPlayer)
    {
        return aPlayer.getPlayerHand().getCards().size();
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
    public Map<Dealer, Set<Player>> getDealerAndPlayers()
    {
        Map<Dealer, Set<Player>> dealersAndPlayers = new HashMap<>();
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

    public boolean placeBet(Player aPlayer, double bet)
    {
        boolean result = false;

        if ((aPlayer.getPlayerCredits() - bet) > 0)
        {
            aPlayer.setBet(new Bet(aPlayer, bet));
            aPlayer.deductCredits(bet);
            result = true;
        }

        return result;
    }

    public void dealCards()
    {
        this.decks = this.getDealer().dealCards();
        int counter = 0;
        
        for (Player each : this.getPlayers())
        {
            this.getDealer().addToPlayerHand(each.getPlayerHand(),
                    this.decks.get(counter));
            counter++;
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
        this.getDealer().setAction(action);
    }

    public void setPlayerAction(Player aPlayer, String anAction)
    {
        Action action = Action.valueOf(anAction);
        aPlayer.setPlayerAction(action);
    }

    public double getMinimumBet()
    {
        return this.minimumBet;
    }

}
