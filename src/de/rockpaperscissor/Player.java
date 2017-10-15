package de.rockpaperscissor;

import java.util.Random;

public class Player {

    private Choice choice;
    private final String name;

    /**
     * The Player.
     * @param name Name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Makes a random choice.
     */
    public void makeChoice() {
        Random random = new Random();
        int number = random.nextInt(3);

        this.choice = Choice.values()[number];
    }

    /**
     * Makes a choice in terms of given param.
     * @param choice The choice to set for this player.
     */
    public void makeChoice(Choice choice) {

        this.choice = choice;
    }

    Choice getChoice() {
        return this.choice;
    }

    String getName() {
        return name;
    }
}

