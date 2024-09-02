import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int totalScore = 0;
        int maxAttempts = 10; // Limiting the number of attempts

        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int numberOfAttempts = 0;
            boolean hasWon = false;

            System.out.println("Round " + totalRounds + ": Guess the number between 1 and 100!");

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    totalScore += (maxAttempts - numberOfAttempts + 1); // Score calculation based on attempts
                    hasWon = true;
                    break;
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes or no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        // Display the user's score and summary of rounds
        System.out.println("Thank you for playing!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Score: " + totalScore);
        scanner.close();
    }
}
