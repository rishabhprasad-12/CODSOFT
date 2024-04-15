import java.util.*;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t\t\tWelcome to Game: Guessing Number\n");
        System.out.println(
                "You have to guess a number between 1 and 100. You'll have limited choices based on the level you choose. Good Luck!");

        // A never ending loop for a never ending game until the user press '0'.
        while (true) {
            System.out.println("\n\t\t\t\t\tDifficulty Level");
            System.out.print("Easy: Press '1'\t");
            System.out.print("\tMedium: Press '2'\t");
            System.out.print("\tHard: Press '3'\t");
            System.out.print("\tExit: Press '0'\n");

            System.out.print("Enter Level: ");
            int level = sc.nextInt(); // Read user input for difficulty level

            Random randomNum = new Random(); // Instance of class Random.
            int secretNum = randomNum.nextInt(100) + 1; // generate a number between 1 and 100

            if (level == 1) { // Easy Level
                System.out.println("You have 10 chances, guess the number.");
                int chanceLeft = 10;
                for (int i = 0; i < 10; i++) {
                    System.out.print("Enter Number: ");
                    int n = sc.nextInt();
                    if (secretNum == n) {
                        System.out.println("\nCongratulation! You guess the right number.");
                        System.out.println(n + " is the right answer");
                        System.out.println("\t\t\tThanks for playing!");
                        System.out.println("Wanna play more...!\n\n");
                        break;
                    } else {
                        System.out.println("\nNope! This is not the right answer.");
                        // Hint: Player number is higher or lower than the secret number.
                        if (secretNum < n) {
                            System.out.println("Number is smaller than  " + n);
                            System.out.println("Try again!");
                        } else {
                            System.out.println("Number is greater than  " + n);
                            System.out.println("Try again!");
                        }
                        chanceLeft--; // decreases chance with attempt taken by player
                        System.out.println("\nChance Left: " + chanceLeft + "\n");
                        if (chanceLeft == 0) {
                            System.out.println("You are not able to find right answer.");
                            System.out.println("The correct  number is " + secretNum + "\n");
                            System.out.println("Don't Give Up! Try again and win the next game.");
                        }
                    }
                }
            } else if (level == 2) { // Medium Level
                System.out.println("You have 6 chances, guess the number.");
                int chanceLeft = 6;
                for (int i = 0; i < 6; i++) {
                    System.out.print("Enter Number: ");
                    int n = sc.nextInt();
                    if (secretNum == n) {
                        System.out.println("\nCongratulation! You guess the right number.");
                        System.out.println(n + " is the right answer");
                        System.out.println("\t\t\tThanks for playing!");
                        System.out.println("Wanna play more...!\n\n");
                        break;
                    } else {
                        System.out.println("\nNope! This is not the right answer.");
                        // Hint: Player number is higher or lower than the secret number.
                        if (secretNum < n) {
                            System.out.println("Number is smaller than  " + n);
                            System.out.println("Try again!");
                        } else {
                            System.out.println("Number is greater than  " + n);
                            System.out.println("Try again!");
                        }
                        chanceLeft--;
                        System.out.println("\nChance Left: " + chanceLeft + "\n");
                        if (chanceLeft == 0) {
                            System.out.println("You are not able to find right answer.");
                            System.out.println("The correct  number is " + secretNum + "\n");
                            System.out.println("Don't Give Up! Try again and win the next game.");
                        }
                    }
                }
            } else if (level == 3) { // Hard Level
                System.out.println("You have 3 chances, guess the number.");
                int chanceLeft = 3;
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter Number: ");
                    int n = sc.nextInt();
                    if (secretNum == n) {
                        System.out.println("\nCongratulation! You guess the right number.");
                        System.out.println(n + " is the right answer");
                        System.out.println("\t\t\tThanks for playing!");
                        System.out.println("Wanna play more...!\n\n");
                        break;
                    } else {
                        System.out.println("\nNope! This is not the right answer.");
                        // Hint: Player number is higher or lower than the secret number.
                        if (secretNum < n) {
                            System.out.println("Number is smaller than  " + n);
                            System.out.println("Try again!");
                        } else {
                            System.out.println("Number is greater than  " + n);
                            System.out.println("Try again!");
                        }
                        chanceLeft--;
                        System.out.println("\nChance Left: " + chanceLeft + "\n");
                        if (chanceLeft == 0) {
                            System.out.println("\nYou are not able to find right answer.");
                            System.out.println("The correct  number is " + secretNum + "\n");
                            System.out.println("Don't Give Up! Try again and win the next game.");
                        }
                    }
                }
            } else if (level == 0) { // Exit Game
                System.out.println("Thanks for Playing!");
                System.exit(0);
            } else {
                System.out.println("LEVEL IS NOT AVILABLE. \nPLEASE! CHOOSE ONE OF THE MENTIONED LEVEL.");
            }
        }
    }
}