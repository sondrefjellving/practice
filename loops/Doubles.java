/**
 * Simple program that "tosses" two dices until they roll a double.
 * This is a task from The Complete Java Development Bootcamp course on Udemy.
 *
 * @author sondrefjellvingandersen
 */
public class Doubles {
    public static void main(String[] args) {
        int dice1 = rollDice();
        int dice2 = rollDice();

        printResult(dice1, dice2);

        while (dice1 != dice2) {
            dice1 = rollDice();
            dice2 = rollDice();
            printResult(dice1, dice2);
        }

        System.out.println("You rolled doubles!");
    }


    /**
     * Return a random number in the range 1-6.
     *
     * @return the random number - (int)
     */
    public static int rollDice() {
        return (int) ((Math.random() * 6) +1);
    }


    /**
     * Print the result of the two dices to the console.
     *
     * @param dice1 the first dice  - (int)
     * @param dice2 the second dice - (int)
     */
    public static void printResult(int dice1, int dice2) {
        System.out.println("Dice 1: " + dice1);
        System.out.println("Dice 2: " + dice2 + "\n");
    }
}





