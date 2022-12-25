import java.util.Scanner;

/**
 * Tic Tac Toe the game, as it has always been played.
 * This task is from The Complete Java Development Bootcamp course on Udemy. (link in README)
 * 
 * @author sondrefjellvingandersen
 */
public class TicTacToe {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe\n");

        char[][] playboard = createBoard();
        printBoard(playboard);

        for (int i = 0; i < 9; i++) { // start game, 9 rounds
            if (i % 2 == 0) {
                populateBoard('X', playboard); // X's turn
            } else {
                populateBoard('O', playboard); // O's turn
            }

            printBoard(playboard);

            switch (checkWin(playboard)) {
                case 3 -> printWinner('X');
                case -3 -> printWinner('O');
            }
        }

        System.out.print("It's a tie!");
        scan.close();
    }


    /**
     * Creates a playboard.
     *
     * @return the playboard - (char[][])
     */
    public static char[][] createBoard() {
        return new char[][]  {{'_', '_', '_'},
                              {'_', '_', '_'},
                              {'_', '_', '_'}};
    }


    /**
     * Prints the current board.
     *
     * @param board the board that gets printed - (char[][] board)
     */
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n\n");
        }
    }


    /**
     * Prints the winner and ends the game.
     *
     * @param player the player that wins - (char)
     */
    public static void printWinner(char player) {
        System.out.print(player + " WINS!!");
        System.exit(0);
    }


    /**
     * Registers user input and updates the board.
     *
     * @param player the player that makes a move - (char)
     * @param board the playboard                 - (char[][])
     */
    public static void populateBoard(char player, char[][] board) {
        System.out.println("Turn: " + player);
        int[] position = askUser(board);
        board[position[0]][position[1]] = player;
    }


    /**
     * Asks user of position they want to place a marker in and checks
     * if position is already taken.
     *
     * @param board the playboard               - (char[][])
     * @return the position of the players move - (int[])
     */
   public static int[] askUser(char[][] board) {
       System.out.print(" · pick a row and column number: ");
       while (true) {
           int row = scan.nextInt();
           int column = scan.nextInt();
           if (board[row][column] == '_') {
               return new int[]{row, column};
           }
           System.out.print("Spot taken, try again: ");
       }
   }


    /**
     * Checks all the possible ways to win the game and returns the result.
     *
     * @param board the playboard - (char[][])
     * @return the result         - (int)
     */
    public static int checkWin(char[][] board) {
        if (checkHorizontal(board) == 3 || checkHorizontal(board) == -3) {
            return checkHorizontal(board);
        } else if (checkVertical(board) == 3 || checkVertical(board) == -3) {
            return checkVertical(board);
        } else if (checkDiagonal(board) == 3 || checkDiagonal(board) == -3) {
            return checkDiagonal(board);
        }
        return 0;
    }


    /**
     * Checks for horizontal wins.
     *
     * @param board the playboard - (char[][])
     * @return the result         - (int)
     */
    public static int checkHorizontal(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {        // new row
            for (int j = 0; j < board[i].length; j++) { // checks row
                if (board[i][j] == 'X') {               // if 'X'// , count =+ 1
                    count++;
                } else if (board[i][j] == 'O') {        // if 'O', count =- 1
                    count--;
                }
            }
            if (count == -3 || count == 3) {            // win if count is 3 or -3
                return count;
            } else {
                count = 0;
            }
        }
        return count;
    }


    /**
     * Checks for vertical wins.
     *
     * @param board the playboard - (char[][])
     * @return the result         - (int)
     */
    public static int checkVertical(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == 'X') {
                    count++;
                } else if (board[j][i] == 'O') {
                    count--;
                }
            }
            if (count == -3 || count == 3) {            // win if count is 3 or -3
                return count;
            } else {
                count = 0;
            }
        }
        return count;
    }


    /**
     * Checks for diagonal wins. Both left and right diagonal.
     *
     * @param board the playboard - (char[][])
     * @return the result         - (int)
     */
    public static int checkDiagonal(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) { // left diagonal
            if (board[i][i] == 'X') {
                count++;
            } else if (board[i][i] == 'O') {
                count--;
            }
        }

        if (count == 3 || count == -3) { // win if count is 3 or -3
            return count;
        } else {
            count = 0;
        }

        for (int i = 0; i < board.length; i++) { // right diagonal
            if (board[2-i][i] == 'X') {
                count++;
            } else if (board[2-i][i] == 'O') {
                count--;
            }
        }
        return count;
    }
}
