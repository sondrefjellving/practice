/**
 * A program that uses loops to find the highest score in a randomized array.
 * This task is from The Complete Java Development Bootcamp course on Udemy (link in README).
 *
 * @author sondrefjellvingandersen
 */
public class HighScore {
    public static void main(String[] args) {
        int[] numbers = randomNumberList(10);

        printScores(numbers);

        int highScore = findHighscore(numbers);

        System.out.println("\n\nThe highest score is: " + highScore + ". Give that man a cookie!");
    }


    /**
     * Returns a random number in the range 0 - 49999
     *
     * @return the random number - (int)
     */
    public static int randomNumber() {
        return (int) ((Math.random() * 50000));
    }


    /**
     * Prints the scores/numbers in the list.
     *
     * @param numbers the numbers to be printed out - (int[])
     */
    public static void printScores(int[] numbers) {
        System.out.print("Here are the scores: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }


    /**
     * Creates and returns a random number list with a declared size.
     *
     * @param size the size of the array - (int)
     * @return the random number list    - (int[])
     */
    public static int[] randomNumberList(int size) {
        int[] numberList = new int[size];
        for (int i = 0; i < numberList.length; i++) {
            numberList[i] = randomNumber();
        }
        return numberList;
    }


    /**
     * Loops through a list of numbers and returns the highest number.
     *
     * @param numbers the numbers - (int[])
     * @return the highest number - (int)
     */
    public static int findHighscore(int[] numbers) {
        int highscore = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > highscore) {
                highscore = numbers[i];
            }
        }
        return highscore;
    }
}
