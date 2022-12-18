import java.util.Scanner;

/**
 * Simpler version of poker where the goal is to get as many card matches as possible.
 * Rules can be found in the printRules method.
 * This task is from The Complete Java Development Bootcamp course on Udemy. (link in README)
 *
 * @author sondrefjellvingandersen
 */
public class Pokerito {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int yourMatches = 0;
        int computerMatches =0;

        printRules();

        String yourCard = randomCard();
        String computerCard = randomCard();

        printSetupCards(yourCard, computerCard);

        System.out.print("Now, the dealer will draw five cards. Press enter to continue. ");
        scan.nextLine();

        for (int i = 1; i <= 5; i++) {
            String riverCard = randomCard();

            System.out.print( // prints out the random card
                "Card " + i + "\n"
                    + riverCard
            );

            yourMatches += checkMatch(riverCard, yourCard);
            computerMatches += checkMatch(riverCard, computerCard);

            scan.nextLine();
        }

        printResult(yourMatches, computerMatches);
        scan.close();
    }


    /**
     * Prints the rules to the player.
     */
    public static void printRules() {
        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        scan.nextLine();
        System.out.print(
              "It's like Poker, but a lot simpler.\n"
            + " • There are two players, you and the computer.\n"
            + " • The dealer will give each player one card.\n"
            + " • Then, the dealer will draw five cards (the river).\n"
            + " • The player with the most river matches wins!\n"
            + " • If the matches are equal, everyone's a winner!\n"
        );
        System.out.println("\nReady? Type anything if you are. ");
        scan.nextLine();
    }


    /**
     * Prints the setup cards to the screen. First step in game.
     *
     * @param playerCard the players card     - (String)
     * @param computerCard the computers card - (String)
     */
    public static void printSetupCards(String playerCard, String computerCard) {
        System.out.println("Here's your card:");
        System.out.println(playerCard);
        System.out.println("Here's the computer's card:");
        System.out.println(computerCard);
    }


    /**
     * Prints number of matches for each player and prints the result.
     *
     * @param playerMatches the player's matches     - (int)
     * @param computerMatches the computer's matches - (int)
     */
    public static void printResult(int playerMatches, int computerMatches) {
        System.out.println("Your number of matches: " + playerMatches);
        System.out.println("Computer number of matches: " + computerMatches);

        if (playerMatches < computerMatches) {
            System.out.println("\nThe computer wins!");
        } else if (computerMatches < playerMatches) {
            System.out.println("\nYou win!");
        } else {
            System.out.println("\nTie!");
        }
    }
    
    
    /**
     * Checks if the river card matches with the player's card. Returns 1 if it matches,
     * and 0 if it doesn't that will be added to number of matches.
     *
     * @param riverCard - the rivercard                                      - (String)
     * @param playerCard - the player's card                                 - (String)
     * @return - the number that will be added to number of matches variable - (int)
     */
    public static int checkMatch(String riverCard, String playerCard) {
        return (riverCard.equals(playerCard)) ? 1 : 0;
    }


    /**
     * Gets a random number in the range 1 - 13, and returns a card
     * that matches the random number.
     *
     * @return the card - (String)
     */
    public static String randomCard() {
        int randomCardNumber = (int) ((Math.random() * 13) + 1);
        return getCard(randomCardNumber);
    }


    /**
     * Gets a card in String format that represents the card number given as an argument.
     *
     * @param cardNumber the card number - (int)
     * @return the card in String format - (String)
     */
    public static String getCard(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return  "   _____\n"+
                        "  |A _  |\n"+
                        "  | ( ) |\n"+
                        "  |(_'_)|\n"+
                        "  |  |  |\n"+
                        "  |____V|\n";

            case 2:
                return  "   _____\n"+
                        "  |2    |\n"+
                        "  |  o  |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____Z|\n";

            case 3:
                 return "   _____\n" +
                        "  |3    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____E|\n";

            case 4:
                return  "   _____\n" +
                        "  |4    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  | o o |\n"+
                        "  |____h|\n";

            case 5:
                return  "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return  "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return  "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";

            case 8:
                return  "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";

            case 9:
                return  "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return  "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";

            case 11:
                return  "   _____\n" +
                        "  |J  ww|\n"+
                        "  | o {)|\n"+
                        "  |o o% |\n"+
                        "  | | % |\n"+
                        "  |__%%[|\n";

            case 12:
                return  "   _____\n" +
                        "  |Q  ww|\n"+
                        "  | o {(|\n"+
                        "  |o o%%|\n"+
                        "  | |%%%|\n"+
                        "  |_%%%O|\n";

            case 13:
                return  "   _____\n" +
                        "  |K  WW|\n"+
                        "  | o {)|\n"+
                        "  |o o%%|\n"+
                        "  | |%%%|\n"+
                        "  |_%%%>|\n";
            default: return "";
        }
    }
}

