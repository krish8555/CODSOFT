import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;

        do {
            // Get user input for number of attempts
            System.out.println("Enter the desired number of attempts (default: 5): ");
            int maxAttempts;
            try {
                maxAttempts = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                maxAttempts = 5; // Use default if invalid input
                System.out.println("Invalid input. Using default attempts (5).");
            }

            // Generate random number
            int numberToGuess = random.nextInt(100) + 1; // Range: 1 to 100

            // Game loop
            int attempt = 0;
            boolean guessedCorrect = false;
            while (attempt < maxAttempts && !guessedCorrect) {
                System.out.println("Guess a number between 1 and 100 (Attempts: " + (attempt + 1) + ")");
                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    guessedCorrect = true;
                    System.out.println("Congratulations! You guessed the number in " + (attempt + 1) + " attempts.");
                    score++;
                } else if (guess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
                attempt++;
            }

            if (!guessedCorrect) {
                System.out.println("You ran out of attempts. The number was: " + numberToGuess);
            }

            // Consume the newline character left by the guess input
            scanner.nextLine();

            System.out.println("Play again? (y/n)");
        } while (scanner.nextLine().equalsIgnoreCase("y"));

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
