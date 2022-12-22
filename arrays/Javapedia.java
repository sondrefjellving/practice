import java.util.Scanner;

/**
 * Simple program that creates a database of historical figures. The user decides
 * how many figures are to be registered and also the information about them. Then
 * the database will be printed out to the user, and they will be able to search for
 * information on a specific figure in the database. If the figure exists in the
 * database, the information on that figure gets printed out. If the figures doesn't
 * exist in the database, they will receive a message that says so.
 * This task is from The Complete Java Development Bootcamp course on Udemy (link in README).
 * 
 * @author sondrefjellvingandersen
 */
public class Javapedia {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");
        int registerSize = scan.nextInt();
        scan.nextLine();

        String[][] historicalFigures = createDatabase(registerSize);

        print2DArray(historicalFigures);

        System.out.print("\nWho do you want information on? ");
        printFigureInfo(findFigure(historicalFigures, scan.nextLine()));

        scan.close();
    }


    /**
     * Prints the values in a 2D array in a neatly formatted way.
     *
     * @param array the array being printed - (String[][])
     */
    public static void print2DArray(String[][] array) {
        System.out.println("These are the values you stored:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    /**
     * Searches for the name given as argument in the array given as argument.
     * Returns null if there's no match, or a String array with information on
     * the match.
     *
     * @param array the database with historical figures - (String[][])
     * @param name the name of the figure to find        - (String)
     * @return the information on that figure            - (String[])
     */
    public static String[] findFigure(String[][] array, String name) {
        for (int i = 0; i < array.length; i++) {
            if (name.equalsIgnoreCase(array[i][0])) {
                return array[i];
            }
        }
        return null;
    }


    /**
     * Prints the information being sent in as an argument.
     *
     * @param figureInfo the information on the figure that gets printed - (String[])
     */
    public static void printFigureInfo(String[] figureInfo) {
        if (figureInfo == null) {
            System.out.print("\nCouldn't find that person in database.");
        } else {
            System.out.print("\n\tName: " + figureInfo[0]);
            System.out.print("\n\tDate of birth: " + figureInfo[1]);
            System.out.print("\n\tOccupation: " + figureInfo[2]);
        }
    }


    /**
     * Creates a database of historical figures. The size of the
     * registry is sent in as an argument to the method.
     *
     * @param size the number of figures in database - (int)
     * @return the database with historical figures  - (String[][])
     */
    public static String[][] createDatabase(int size) {
        String[][] database = new String[size][3];
        for (int i = 0; i < database.length; i++) {
            System.out.print("\n\tFigure " + (i+1) + "\n");
            System.out.print("\t · Name: ");
            database[i][0] = scan.nextLine();
            System.out.print("\t · Date of birth: ");
            database[i][1] = scan.nextLine();
            System.out.print("\t · Occupation: ");
            database[i][2] = scan.nextLine();
            System.out.print("\n");
        }
        return database;
    }
}
