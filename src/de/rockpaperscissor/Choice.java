package de.rockpaperscissor;

public enum Choice {

    PAPER("ROCK"),
    SCISSOR("PAPER"),
    ROCK("SCISSOR");

    private final String beats;


    Choice(String beats) {
        this.beats = beats;
    }

    /**
     * Determines if this choice would beat the given choice.
     * Returns the score status.
     *
     * @param choice The choice to compare with.
     * @return Score returns the corresponding score status from this choice perspective.
     */
    public Score beats(Choice choice) {
        if (this.name().equals(choice.name())) {
            return Score.TIE;
        } else if (this.beats.equals(choice.name())) {
            return Score.WIN;
        }
        return Score.LOOSE;
    }
}
