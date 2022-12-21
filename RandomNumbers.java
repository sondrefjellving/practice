/**
 * Simple program that creates an array with random numbers in the range 0-99.
 * This task is from The Complete Java Development Bootcamp course on Udemy. (link in README)
 *
 * @author sondrefjellvingandersen
 */
public class RandomNumbers {
    public static void main(String[] args) {
        int[][] array = getRandomNumArray(100, 10);

        print2DArray(array);
    }

    /**
     * Returns a random number in the range 0 - 99
     *
     * @return the random number - (int)
     */
    public static int randomNumber() {
        return (int) (Math.random()*100);
    }


    /**
     * Creates a random number array with the amount of rows and columns declared.
     *
     * @param rows the amount of rows    - (int)
     * @param cols the amount of columns - (int)
     * @return the random number array   - (int[][])
     */
    public static int[][] getRandomNumArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomNumber();
            }
        }
        return array;
    }


    /**
     * Prints out numbers in a two-dimensional array.
     *
     * @param array - the array that gets printed
     */
    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
