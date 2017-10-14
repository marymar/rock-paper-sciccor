package de.rockpaperscissor;

public enum Score {
    WIN("win"),
    TIE("tie"),
    LOOSE("loose");

    final String status;

    Score(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
