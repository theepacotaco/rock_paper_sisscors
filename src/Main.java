import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // Get moves from players
            String playerAChoice, playerBChoice;
            playerAChoice = getPlayerChoice(scanner, "Player A");
            playerBChoice = getPlayerChoice(scanner, "Player B");

            // Determine the winner
            String result = determineWinner(playerAChoice, playerBChoice);

            // Display the results
            System.out.println(result);

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainChoice = scanner.next().trim();
            playAgain = playAgainChoice.equalsIgnoreCase("Y");
        }

        System.out.println("Thanks for playing Rock Paper Scissors!");
        scanner.close();
    }

    // Helper method to get a valid move from a player
    private static String getPlayerChoice(Scanner scanner, String playerName) {
        String choice;
        do {
            System.out.print(playerName + ", enter your choice (R/P/S): ");
            choice = scanner.next().toUpperCase();
        } while (!choice.matches("[RPS]"));
        return choice;
    }

    // Helper method to determine the winner
    private static String determineWinner(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equals(playerBChoice)) {
            return "It's a Tie!";
        } else if ((playerAChoice.equals("R") && playerBChoice.equals("S")) ||
                (playerAChoice.equals("P") && playerBChoice.equals("R")) ||
                (playerAChoice.equals("S") && playerBChoice.equals("P"))) {
            return "Player A wins!";
        } else {
            return "Player B wins!";
        }
    }
}
