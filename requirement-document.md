<h1>Requirements document</h1>

<h2><u>Use cases</h2>
<ol type="A">
    <li> <b>Add player</b>, player enters name, is allocated 1000 credits player is added to the game and player name is displayed.</li>
    <li><b>Place bets</b>, each player places their bets in turn, working clockwise from the dealers left, the bet must equal to or greater than the bet minimum.  The bet is acknowledged.</li>
    <li><b>Deal cards</b>,the dealer shuffles the decks of cards,
        <ul type="disc">
            <li>A single card is dealt to the players hand clockwise from the dealers left, followed by a single card to the dealers hand, all face-up</li>  
            <li>If the dealers card is an ace the players have the choice of adding insurance to their bet.</li>  
            <li>A second card is then dealt face up to the players hand only.</li>
        </ul>
    </li>
    <li><b>Player action</b>, If the score of the hand is less than 21 the player can decide their action.
        <ul type="disc">
                <li>If the dealer does not have an ace as the first card and after the initial card deal, but before any extra cards are dealt the player can surrender, which causes them to lose half their original bet.</li>
                <li>If the dealers first card dealt is an ace and the player has enough credits to cover half the amount of the minimum bet and up to half the amount of the bet, the player can add insurance.  If the next card added to the dealers hand is a 10, jack, queen or king, the insurance bet wins and the bet is payed at 2 to 1.  If not the bet is paid as normal.  Insurance bets are placed in the insurance area.</li>
                <li>After the first two cards are dealt a player can choose int and add at least half the game minimum and up to the same amount of the original bet, providing they do not have a blackjack.</li>
                <li>If a player wants another card the player chooses hit, if a player wants to stick with their hand, the player will choose stand and PlayerHand score is recorded.</li>
                <li>If a player is dealt two cards with the same value on the initial deal the player can choose to split the pair which gives the player two hands, the player must place a bet on the second hand equal to the bet placed on the first hand and the first hand must be played) completed first.  A player can continue to split if they receive the same numerical pair again.  When an Ace is dealt, if the second card split is anything other than an Ace the hand is complete, otherwise the player can split again.  Doubling and drawing a third card is not allowed when Aces are drawn.  blackjacks do not count after a pair is split, furthermore a dealers blackjack always beats a player score of 21.</li>
        </ul>
    </li>
    <li><b>Dealer action</b>, all players must have completed their hands before the dealer can play theirs.
        <ul type="disc">
            <li>The dealer deals their second card face up.</li>
            <li>If the dealers hand is equal to or less than 16 the dealer must hit.</li>
            <li>If the dealers hand is equal to or more than 17 the dealer must stand. </li>
            <li>Otherwise if the dealer is greater than 21 the dealer is bust. </li>
            <li>Should the dealer not bust, the dealers hand is compared with each players hand.  The dealer collects from those players holding weaker hands and pays those holding stronger hands. Should the point total of a players hand be equal to the dealers, the bet is a “standoff” (a tie), and no money exchanges hands.</li>
        </ul>    
    </li>
    <li><b>Pay out</b>, Split pairs pay 1 to 1 (even money),
        <ul type="disc">
            <li>If the dealer or player hand does not have a blackjack the payout is 1 to 1. </li>
            <li>If a players hand has a blackjack it is paid at 3 to 2. </li>
            <li><If there was an insurance bet and the dealers hand has 21 or blackjack the payout is 2 to 1, otherwise bet paid as normal.</li>
            <li>Winnings are added, loses are deducted and player/dealer hands are cleared. </li>
            <li>Players are then asked if they want to play again.</li>
        </ul>
    </li>
    </ol>
    <h2><b>Acceptance tests</b></h2>
   
