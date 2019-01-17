<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name= "description" content="requirements documentfor the core system objects for a Java
        implemented game of Blackjack."/>
    </head>
    <body>
        <h1>Requirements document</h1>
        <h2><u>Use cases</h2>
        <div style="color: blue; font-family: verdana; font-size: 300%;}">
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
                    <ul type="disc"><li>If the dealer does not have an ace as the first card and after the initial card deal, but before any extra cards are dealt the player can surrender, which causes them to lose half their original bet.</li>
                    </ul></li>
                </ol>
        </div>
    </body>
</html>
