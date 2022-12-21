import java.util.Scanner;

/**
 * A blackjack simulation where the player plays against a computer.
 * This task is from The Complete Java Development Bootcamp course on Udemy. (link in README)
 *
 * @author sondrefjellvingandersen
 */
public class Blackjack {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int playerCard1 = drawRandomCard();
        int playerCard2 = drawRandomCard();
        int playerTotal = faceCardCheck(playerCard1) + faceCardCheck(playerCard2);

        System.out.print("\nYou get a \n" + cardString(playerCard1) + "\n and a \n" + cardString(playerCard2));
        System.out.print("\nYour total is: " + playerTotal + "\n");

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        int dealerTotal = faceCardCheck(dealerCard1) + faceCardCheck(dealerCard2);

        System.out.print("\nThe dealer shows\n" + cardString(dealerCard1) + "\nand has a card facing down\n" + faceDown());
        System.out.print("\nThe dealer's total is hidden\n");

        String move = hitOrStay();
        while (move.equals("hit")) {
            int newCard = drawRandomCard();
            playerTotal += faceCardCheck(newCard);
            System.out.print("\nYou get a\n" + cardString(newCard) + "\nYour new total is " + playerTotal + "\n");

            checkIfBusted(playerTotal, "player");

            move = hitOrStay();
        }

        System.out.print("\nDealer's turn");
        System.out.print("\nThe dealer's cards are\n" + cardString(dealerCard1)
            + "\n and a\n" + cardString(dealerCard2));

        while (dealerTotal < 17) {
            int newCard = drawRandomCard();
            dealerTotal += faceCardCheck(newCard);
            System.out.print("\nDealer gets a\n" + cardString(newCard) + "\n");
            System.out.print("Dealer's total is " + dealerTotal + "\n");

            checkIfBusted(dealerTotal, "dealer");
        }

        printWinner(playerTotal, dealerTotal);
         scan.close();

    }

    /**
     * Checks who win and prints the result.
     *
     * @param playerTotal the players total   - (int)
     * @param dealerTotal the computers total - (int)
     */
    public static void printWinner(int playerTotal, int dealerTotal) {
        if (playerTotal > dealerTotal) {
            System.out.println("\nPlayer wins!!");
        } else {
            System.out.println("\nDealer wins!!");
        }
    }


    /**
     * Checks if card is face card. Returns 10 if that is the case. If it's not
     * it will return the original value of the card.
     *
     * @param cardNumber the card number being checked - (int)
     * @return the value of the card                   - (int)
     */
    public static int faceCardCheck(int cardNumber) {
        return Math.min(cardNumber, 10);
    }


    /**
     * Gets a random number in the range 1-13 and returns it.
     *
     * @return the number - (int)
     */
    public static int drawRandomCard() {
        return (int) ((Math.random() * 13) + 1);
    }


    /**
     * Returns a String drawing of the card.
     *
     * @param cardNumber - the card number - (int)
     * @return String drawing of the card  - (String)
     */
    public static String cardString(int cardNumber) {
        return switch (cardNumber) {
            case 1 -> "   _____\n" +
                      "  |A _  |\n" +
                      "  | ( ) |\n" +
                      "  |(_'_)|\n" +
                      "  |  |  |\n" +
                      "  |____V|\n";
            case 2 -> "   _____\n" +
                      "  |2    |\n" +
                      "  |  o  |\n" +
                      "  |     |\n" +
                      "  |  o  |\n" +
                      "  |____Z|\n";
            case 3 -> "   _____\n" +
                      "  |3    |\n" +
                      "  | o o |\n" +
                      "  |     |\n" +
                      "  |  o  |\n" +
                      "  |____E|\n";
            case 4 -> "   _____\n" +
                      "  |4    |\n" +
                      "  | o o |\n" +
                      "  |     |\n" +
                      "  | o o |\n" +
                      "  |____h|\n";
            case 5 -> "   _____ \n" +
                      "  |5    |\n" +
                      "  | o o |\n" +
                      "  |  o  |\n" +
                      "  | o o |\n" +
                      "  |____S|\n";
            case 6 -> "   _____ \n" +
                      "  |6    |\n" +
                      "  | o o |\n" +
                      "  | o o |\n" +
                      "  | o o |\n" +
                      "  |____6|\n";
            case 7 -> "   _____ \n" +
                      "  |7    |\n" +
                      "  | o o |\n" +
                      "  |o o o|\n" +
                      "  | o o |\n" +
                      "  |____7|\n";
            case 8 -> "   _____ \n" +
                      "  |8    |\n" +
                      "  |o o o|\n" +
                      "  | o o |\n" +
                      "  |o o o|\n" +
                      "  |____8|\n";
            case 9 -> "   _____ \n" +
                      "  |9    |\n" +
                      "  |o o o|\n" +
                      "  |o o o|\n" +
                      "  |o o o|\n" +
                      "  |____9|\n";
            case 10 -> "   _____ \n" +
                       "  |10  o|\n" +
                       "  |o o o|\n" +
                       "  |o o o|\n" +
                       "  |o o o|\n" +
                       "  |___10|\n";
            case 11 -> "   _____\n" +
                       "  |J  ww|\n" +
                       "  | o {)|\n" +
                       "  |o o% |\n" +
                       "  | | % |\n" +
                       "  |__%%[|\n";
            case 12 -> "   _____\n" +
                       "  |Q  ww|\n" +
                       "  | o {(|\n" +
                       "  |o o%%|\n" +
                       "  | |%%%|\n" +
                       "  |_%%%O|\n";
            case 13 -> "   _____\n" +
                       "  |K  WW|\n" +
                       "  | o {)|\n" +
                       "  |o o%%|\n" +
                       "  | |%%%|\n" +
                       "  |_%%%>|\n";
            default -> "";
        };
    }


    /**
     * Returns a card facing down.
     *
     * @return the card facing down - (String)
     */
    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */
    public static String hitOrStay() {
        System.out.println("\nWould you like to hit or stay?");
        String move = scan.nextLine();
        while (!(move.equals("hit") || move.equals("stay"))) {
            System.out.println("Please write 'hit' or 'stay'");
            move = scan.nextLine();
        }
        return move;
    }


    /**
     * Checks if score is above 21. If so, print message, then end game.
     *
     * @param playerTotal the player's total - (int)
     * @param player the player              - (String)
     */
    public static void checkIfBusted(int playerTotal, String player) {
        if (playerTotal > 21) {
            System.out.print("\nBust! " + player + " loses.");
            System.exit(0);
        }
    }

}
