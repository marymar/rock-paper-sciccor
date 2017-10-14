package de.rockpaperscissor;

class Game {

    private final Player player1;
    private final Player player2;

    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Makes a move.
     * Returns the achieved score for player1.
     * @return Score
     */
    Score move(){
        Choice choice1 = this.player1.getChoice();
        Choice choice2 = this.player2.getChoice();

        return choice1.beats(choice2);
    }
}
