<h1>Requirements document</h1>

<h2>Use cases</h2>
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
            <li>If there was an insurance bet and the dealers hand has 21 or blackjack the payout is 2 to 1, otherwise bet paid as                   normal.</li>
            <li>Winnings are added, loses are deducted and player/dealer hands are cleared. </li>
            <li>Players are then asked if they want to play again.</li>
        </ul>
    </li>
    </ol>
    <h2><b>Acceptance tests</b></h2>
    <ol type="A">
        <li>Test that a new player is created with the correct name and 1000 credits.</li>
        <li>Test that a bet cannot be placed which is lower than the minimum bet.
            <ul type="disc">
                <li>Test that a bet can be placed which is equal to the minimum bet.</li>
                <li>Test that a bet can be placed which is more than the minimum bet.</li>
            </ul>
        </li>
        <li>Test that 6 decks are created with the correct cards in each deck.
            <ul type="disc">
                <li>Test that all cards from each deck shuffle together.</li>
                <li>Test that cards are dealt in the correct orde.r</li>
            </ul>
        </li>
        <li>Test that a player can add insurance if the dealer has an Ace.
            <ul type="disc">
                <li>Test that a player cannot add insurance if the dealer does not have an Ace.</li>
            </ul>
        </li>
        <li>Test player decisions if the players hand is less than 21.
            <ul type="disc">
                <li>Test that hit gives a new card to a player.</li>
                <li>Test that int adds at least half of and up to an equal amount of the bet if the player does not have a blackjack.
                </li>
                <li>Test that stand confirms the players hand score.</li>
                <li>Test that a player can surrender and lose half their bet.</li>
                <li>Test that a player can split their hand if there are two cards dealt to the player are of the same value.</li>
                <li>Test that a player cannot spilt their hand if 2 cards dealt to the player are not of the same value.</li>
                <li>Test that player goes bust if a players hand score is over 21.</li>
            </ul>
        </li>
        <li>Test dealer decisions,
            <ul type="disc">
                <li>Test that a dealer hits if a dealers hand score is 16 or less.</li>
                <li>Test that a dealer stands if a dealers hand score is 17 or more.</li>
                <li>Test that a dealer goes bust if a dealers hand score is over 21.</li>
            </ul>
        </li>
        <li>Test that 1 : 1 is paid on a split pair.
            <ul type="disc">
                <li>Test that 3 : 2 is paid on a player blackjack.</li>
                <li>Test that an insurance bet is paid at 2 : 1.</li>
                <li>Test that a winning bet that is not a blackjack is paid at 1 : 1.></li>
                <li>Test that a bet is not paid out if a player loses.</li>
            </ul>
        </li>
    </ol>
    <h1>Initial structural model</h1>
    <h2>Class diagram</h2>
    <img src="https://github.com/chrislyle21/blackjack_core_objects/blob/master/images/class-diagram-initial-structural.jpg"                 height="600" width="800"/>
<h2>Class descriptions (conceptual)</h2>
<p>
    <b>Class</b><br />
    <code>BlackjackCoord</code> - The game coordinator<br />
    <b>Attributes</b><br />
    <code>MinimumBet</code> - The minimum bet amount for the game
</p>
<p>
    <b>Class</b><br />
    <code>Player</code> - A player in the game<br />
    <b>Attributes</b><br />
    <code>playerName</code> - The name of the player<br />
    <code>credits</code> - A players credits
</p>
<p>
    <b>Class</b><br />
    <code>Dealer</code> - The dealer in a game<br />
    <b>Attributes</b><br />
    None
</p>
<p>
    <b>Class</b><br />
    <code>Deck</code> - The decks used in a game<br />
    <b>Attributes</b><br />
    None
</p>
<p>
    <b>Class</b><br />
    <code>Card</code> - The cards used is each deck<br />
    <b>Attributes</b><br />
    <code>suit</code> - The suit of the card<br />
    <code>value</code> - The value of the card
</p>
<p>
    <b>Class</b><br />
    <code>Bet</code> - Bet used to place wagers in a game<br />
    <b>Attributes</b><br />
    <code>betAmount</code> - The amount of credits placed in a bet
</p>
<p>
    <b>Class</b><br />
    <code>Hand</code> - The hand that has been dealt.  Generalises <code>PlayerHand</code> and <code>DealerHand</code><br />
    <b>Attributes</b><br />
    <code>handScore</code> - The score of the hand
</p>
<p>
    <b>Class</b><br />
    <code>PlayerHand</code> - The players hand.  Specialises <code>Hand</code><br />
    <b>Attributes</b><br />
    <code>handScore</code> - The score of the hand
</p>
<p>
    <b>Class</b><br />
    <code>DealerHand</code> - The dealers hand.  Specialises <code>Hand</code><br />
    <b>Attributes</b><br />
    <code>handScore</code> - The score of the hand
</p>
<p>
    <b>Enum</b><br />
    <code>Action</code> - Action used for decisions<br />
    <b>Values</b><br />
    <code>HIT, BUST, STAND, INSURANCE, SPLIT, DOUBLE, SURRENDER</code>
</p>
<p>
    <b>Enum</b><br />
    <code>Suit</code> - The suit of a card<br />
    <b>Values</b><br />
    <code>HEARTS, DIAMONDS, CLUBS, SPADES</code>
</p>
<p>
    <b>Enum</b><br />
    <code>Value</code> - The value of the card<br />
    <b>Values</b><br />
    <code>ACE(11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10)</code><br />
    <b>Attributes</b><br />
    <code>numVal</code> - The numerical value of <code>Value</code>
</p>
<h2>Invariants</h2>
<p>
    If a PlayerHand object aPlayerHand is equal to or greater than a DealerHand object aDealerHand, then aPlayerHand is linked to a Bet     object aBet via wins association.
</p>
<p>When aBet is placed, the attribute betAmount of aBet must be equal to or greater than the attribute minimumBet of BlackjackCoord     object aBlackjackCoord.
</p>
<p>
    If aDealerHand or aPlayerHand attribute handScore is greater than 21 the corresponding Hand object aHand loses.
    No two Player objects in a single game may have the same playerName attribute.
</p>
<h1>Implementation model</h1>
<h2>Class diagram</h2>
<img src="https://github.com/chrislyle21/blackjack_core_objects/blob/master/images/class-diagram-implementation.jpg" height="600" width="800" />


