/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
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
    
    public BlackjackCoord(double aMinBet){
        this.minimumBet = aMinBet;
        this.dealer = new Dealer();
        this.players = new HashSet<>();
    }
    Dealer getDealer(){
        return this.dealer;
    }
    
    Set<Player> getPlayers(){
        return this.players;
    }
    
    public void addPlayer(String aName){
        players.add(new Player(aName));
    }
    
    public Map<Dealer, Set<Player>> getDealerAndPlayers(){
        Map<Dealer, Set<Player>> dealersAndPlayers = new HashMap<>();
        dealersAndPlayers.put(this.getDealer(), this.getPlayers());
        return dealersAndPlayers;
    }
    
    /**
     *
     * @return
     */
    public Set<Bet> getBets(){
        Set<Bet> bets = new HashSet<>();
        for(Player each : this.getPlayers()){
            bets.add(each.getBet());
        }
        return bets;
    }
    
    /**
     *
     * @param aPlayer
     * @return
     */
    public Bet getPlayerBet(Player aPlayer){
        return aPlayer.getBet();
    }
    
    public Action getPlayerAction(Player aPlayer){
        return aPlayer.getPlayerAction();
    }
    
    public Action getDealerAction(){
        
        return this.getDealer().getDealerAction();
    }
    
    public void setDealerAction(String anAction){
        Action action = Action.valueOf(anAction);
        this.getDealer().setAction(action);
    }
    
    public void setPlayerAction(Player aPlayer, String anAction){
        Action action = Action.valueOf(anAction);
        aPlayer.setPlayerAction(action);
    }
    
    public double getMinimumBet(){
        return this.minimumBet;
    }
}
