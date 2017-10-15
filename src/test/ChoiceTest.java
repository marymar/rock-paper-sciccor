package test;

import de.rockpaperscissor.Choice;
import de.rockpaperscissor.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChoiceTest {

    @Test
    void testPaperBeatsRock() {
        Score score = Choice.PAPER.beats(Choice.ROCK);
        assertEquals(score, Score.WIN);
    }

    @Test
    void testRockBeatsScissor() {
        Score score = Choice.ROCK.beats(Choice.SCISSOR);
        assertEquals(score, Score.WIN, "Rock didn't beat.");
    }

    @Test
    void testScissorBeatsPaper() {
        Score score = Choice.SCISSOR.beats(Choice.PAPER);
        assertEquals(score, Score.WIN, "Scissor didn't beat.");
    }

    @Test
    void testScissorDoesNotBeatsRock() {
        Score score = Choice.SCISSOR.beats(Choice.ROCK);
        assertEquals(score, Score.LOOSE, "Scissor didn't loose.");
    }

    @Test
    void noOneBeats() {
        Score score = Choice.SCISSOR.beats(Choice.SCISSOR);
        assertEquals(score, Score.TIE, "Scissor and Scissor can't beat each other.");
    }
}