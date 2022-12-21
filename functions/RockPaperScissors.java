import java.util.Scanner;

/**
 * A simple rock-paper-scissors game simulation where you play against the computer.
 * This task is from The Complete Java Development Bootcamp course on Udemy (link in Readme).
 *
 * @author sondrefjellvingandersen
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");

        String ready = scan.nextLine();

        if (ready.equals("yes")) { // play game
            System.out.println("\nGreat!");
            System.out.println("rock - paper - scissors, shoot!");
            String yourChoice = scan.nextLine();
            String computerChoice = computerChoice();
            printResult(yourChoice, computerChoice, result(yourChoice, computerChoice));
        } else {                    // not interested in game or typo
            System.out.println("Darn, some other time...");
        }

        scan.close();
    }


    /**
     * Gets a randomNumber and uses that to choose either rock, paper or scissor.
     *
     * @return rock / paper / scissors - (String)
     */
    public static String computerChoice() {
        int randomNumber = (int) (Math.random() * 3); // range: 0 - 2
        return switch (randomNumber) {
            case 0 -> "rock";
            case 1 -> "paper";
            case 2 -> "scissors";
            default -> ""; // shouldn't run
        };
    }


    /**
     * Gets the result of the rock paper scissors fight and returns it.
     *
     * @param yourChoice     the choice you made - (String)
     * @param computerChoice the computer choice - (String)
     * @return the result                        - (String)
     */
    public static String result(String yourChoice, String computerChoice) {
        String result = "";

        if (!(yourChoice.equals("rock") || yourChoice.equals("scissors") || yourChoice.equals("paper"))) {
            System.out.println("INVALID CHOICE");
            System.exit(0);
        } else if (
            (yourChoice.equals("rock") && computerChoice.equals("scissors"))
            || (yourChoice.equals("paper") && computerChoice.equals("rock"))
            || (yourChoice.equals("scissors") && computerChoice.equals("paper"))) {
            result = "You win!";
        } else if (yourChoice.equals(computerChoice)) {
            result = "Tie!";
        } else {
            result = "You lose!";
        }
        return result;
    }


    /**
     * Prints result of match.
     *
     * @param yourChoice     the choice you made - (String)
     * @param computerChoice the computer choice - (String)
     * @param result         the result          - (String)
     */
    public static void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("\nYou chose:        " + yourChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result(yourChoice, computerChoice));
    }
}
