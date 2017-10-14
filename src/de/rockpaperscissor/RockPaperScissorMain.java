package de.rockpaperscissor;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RockPaperScissorMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Choice[] choices = Choice.values();
        Pattern inputPattern = Pattern.compile("[/1-" + choices.length + "q]");

        Player player = new Player("you");
        Player computer = new Player("computer");
        Game game = new Game(player, computer);

        printChoiceOptions(choices);
        while (scanner.hasNext()) {
            if (!scanner.hasNext(inputPattern)) {
                System.out.println("\n\nWrong input. Try again...");
                printChoiceOptions(choices);
                scanner.next();
            } else {
                String input = scanner.next(inputPattern);

                if ("Q".equals(input.toUpperCase())) {
                    System.exit(0);
                }

                // PLAY
                Choice choice = choices[Integer.valueOf(input) - 1];
                player.makeChoice(choice);
                computer.makeChoice();
                Score score = game.move();

                printScore(player, computer, score);
                printChoiceOptions(choices);
            }

        }
    }

    private static void printChoiceOptions(Choice[] choices) {
        System.out.println("------------------------------------");
        System.out.println("Make your Choice: \nOptions:");

        int optionNumber = 1;
        for (Choice choice : choices) {
            System.out.println("(" + optionNumber++ + "): " + choice.name());
        }
        System.out.println("(Q): QUIT");
        System.out.println("------------------------------------");
        System.out.println("Make your choice: ");
    }

    private static void printScore(Player player1, Player player2, Score score) {
        StringBuilder outputText = new StringBuilder("Game Status: ");

        System.out.println("----------- CHOICES -----------------");
        System.out.println(player1.getName() + ": " + player1.getChoice());
        System.out.println(player2.getName() + ": " + player2.getChoice());

        switch (score) {
            case WIN:
            case LOOSE: {
                outputText
                        .append(player1.getName())
                        .append(" ")
                        .append(score);
                break;
            }
            case TIE: {
                outputText.append(score);
                break;
            }
        }

        System.out.println(outputText);
    }
}

