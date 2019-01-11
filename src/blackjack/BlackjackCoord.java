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
    
    public BlackjackCoord(double aMinimumBet){
        this.minimumBet = aMinimumBet;
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
    
    public Set<Bet> getBets(){
        Set<Bet> bets = new HashSet<>();
        for(Player each : this.getPlayers()){
            bets.add(each.getBet());
        }
        return bets;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        
    }
    
}
