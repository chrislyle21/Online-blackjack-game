/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author chris lyle
 */
public class Player
{

    private String playerName;
    private int playerCredits;
    private Bet bet;
    private Action playerAction;
    private PlayerHand playerHand;

    Player(String aName)
    {
        this.playerName = aName;
        this.playerHand = new PlayerHand();
    }

    PlayerHand getPlayerHand()
    {
        return this.playerHand;
    }

    String getPlayerName()
    {
        return this.playerName;
    }

    int getPlayerCredits()
    {
        return this.playerCredits;
    }

    Action getPlayerAction()
    {
        return this.playerAction;
    }

    void setPlayerAction(Action anAction)
    {
        this.playerAction = anAction;
    }

    Bet getBet()
    {
        return this.bet;
    }

    void setBet(Bet aBet)
    {
        this.bet = aBet;
    }

    boolean addCredits(int credits)
    {
        boolean result = false;
        if (credits > 0)
        {
            this.playerCredits = (this.getPlayerCredits() + credits);
            result = true;
        }
        return result;
    }

    int deductCredits(int credits)
    {
        if ((this.getPlayerCredits() - credits) > 0)
        {
            this.playerCredits = (this.playerCredits - credits);
        }
        return this.getPlayerCredits();
    }

    void resetPlayerHand()
    {
        this.getPlayerHand().getCards().clear();
    }

    @Override
    public String toString()
    {
        return "Player name: " + this.getPlayerName() + "/nCredits: " + this.getPlayerCredits();
    }
}
