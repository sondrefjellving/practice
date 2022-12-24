import java.util.Scanner;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe\n");

        char[][] playboard = createBoard();
        printBoard(playboard);

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                populateBoard('X', playboard);
                printBoard(playboard);
            } else {
                populateBoard('O', playboard);
                printBoard(playboard);
            }

            if (checkWin(playboard) == 3) {
                System.out.print("WIN!");
            }
        }
        scan.close();
    }

    public static char[][] createBoard() {
        return new char[][]{{'_', '_', '_'},
                              {'_', '_', '_'},
                              {'_', '_', '_'}};
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n\n");
        }
    }


    public static void populateBoard(char player, char[][] board) {
        System.out.println("Turn: " + player);
        int[] position = askUser(board);
        board[position[0]][position[1]] = player;
    }

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





    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */

    public static int checkWin(char[][] board) {
        if (checkHorizontal(board) == 3 || checkHorizontal(board) == -3) {
            return checkHorizontal(board);
        } else if (checkVertical(board) == 3 || checkVertical(board) == -3) {
            return checkVertical(board);
        }
        return 0;
    }





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
}
