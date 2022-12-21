import java.util.Scanner;

/**
 * Simple dice game that runs while dice doesn't roll a six.
 * This task is from The Complete Java Development Bootcamp course on Udemy. (link in README)
 *
 * @author sondrefjellvingandersen
 */
public class JavaRolls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 0;

        System.out.print("\nGreat here are the rules:\n"
            + " - If you roll a 6, the game stops.\n"
            + " - If you roll a 4, nothing happens.\n"
            + " - Otherwise, you get 1 point.\n\n"
            + "You must collect at least 3 points to win. Press enter to roll."
            );
        scan.nextLine();

        while (true) {
            int diceRoll = rollDice();
            System.out.print("You rolled a " + diceRoll + ". ");

            if (diceRoll == 6) {
                System.out.println("End of game.");
                break;
            } else if (diceRoll == 4) {
                System.out.println("Zero points. Keep rolling.");
            } else {
                System.out.println("One point. Keep rolling.");
                score++;
            }

            scan.nextLine(); // press enter to keep rolling
        }

        printResult(score);
    }


    /**
     * Return a random number in the range 1-6.
     *
     * @return the random number - (int)
     */
    public static int rollDice() {
        return (int) ((Math.random() * 6) + 1);
    }


    /**
     * Check the score and print result.
     *
     * @param score the score - (int)
     */
    public static void printResult(int score) {
        if (score >= 3) {
            System.out.println("Wow, that's lucky. You win!");
        } else {
            System.out.println("Tough luck, you lose.");
        }
    }
}
