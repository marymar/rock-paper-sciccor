package test;

import de.rockpaperscissor.Choice;
import de.rockpaperscissor.Score;
import de.rockpaperscissor.Player;
import de.rockpaperscissor.Game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;
    private Player player1;
    private Player player2;


    @BeforeAll
    void initialize() {
        player1 = new Player("Tester");
        player2 = new Player("PC");
        game = new Game(player1, player2);
    }

    @Test
    void movePlayer1Wins() {
        player1.makeChoice(Choice.ROCK);
        player2.makeChoice(Choice.SCISSOR);
        Score score = game.move();

        assertEquals(Score.WIN, score, "Supposed player didn't win but should have to.");
    }

}