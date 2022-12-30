import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A game of Hangman. The word gets chosen randomly from the words list. The user can
 * guess wrong six times before they lose.
 * This task is from The Complete Development Bootcamp course on Udemy (link in README).
 * 
 * @author sondrefjellvingandersen 
 */
public class Hangman {
    public static Scanner scan = new Scanner(System.in);

    /**
     * The random words to be used in the game.
     */
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    /**
     * The gallows that gets updated every time the user guesses wrong.
     */
    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        startGame();
    }


    /**
     * Starts the game.
     */
    public static void startGame() {
        String[] word = randomWord();
        String[] placeholder = createPlaceholder(word);
        String misses = "";
        String guess = "";
        int wrongGuesses = 0;

        while (true) {
            printLastGuess(guess);
            printGallow(wrongGuesses);

            if (wrongGuesses == 6) {
                System.out.println("RIP!");
                break;
            } else if (checkWin(placeholder, word)) {
                System.out.print("YOU WIN!!!");
                break;
            }

            printPlaceholder(placeholder);
            printMisses(misses);
            guess = makeGuess();

            if (checkGuess(guess, word)) { // if correct
                placeholder = updatePlaceholder(placeholder, word, guess);
            } else if (misses.contains(guess)) { // if guess is wrong and already guessed
                System.out.print("You have already guessed this character\n");
            } else { // if guess is wrong
                misses = updateMisses(misses, guess);
                wrongGuesses++;
            }
        }
        System.out.println("\nThe word was: '" + wordToString(word) + "'");
    }

    /**
     * Gets a number in the range (0 - length of words array) and selects a word
     * by using indexing.
     *
     * @return the random word - (String)
     */
    public static String[] randomWord() {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex].split("");
    }


    /**
     * Prints the gallow.
     *
     * @param wrongGuesses the number of wrong guesses - (int)
     */
    public static void printGallow(int wrongGuesses) {
        System.out.print(gallows[wrongGuesses]);
    }

    /**
     * Checks for the users guess and returns it if it follows the requirements.
     *
     * @return the guess - (String)
     */
    public static String makeGuess() {
        System.out.print("\nGuess: ");
        String guess = scan.nextLine();
        while (guess.length() != 1) {
            System.out.print("You have to type in one character only: ");
            guess = scan.nextLine();
        }
        return guess;
    }


    /**
     * Checks if the guess that is sent in as argument exists in the word that it will be
     * checked against.
     *
     * @param guess the guess to be checked               - (String)
     * @param checkAgainst the word to be checked against - (String[])
     * @return
     */
    public static boolean checkGuess(String guess, String[] checkAgainst) {
        for (int i = 0; i < checkAgainst.length; i++) {
            if (checkAgainst[i].equalsIgnoreCase(guess)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Prints the last guess.
     *
     * @param guess the guess - (String)
     */
    public static void printLastGuess(String guess) {
        System.out.print("\nGuess:\t" + guess + "\n");
    }


    /**
     * Creates a placeholder that has the same length as the random word and
     * every letter is a '_' symbol.
     *
     * @param word the word used to create a placeholder - (String[])
     * @return the placeholder                           - (String[])
     */
    public static String[] createPlaceholder(String[] word) {
        String[] placeholder = new String[word.length];
        Arrays.fill(placeholder, "_");
        return placeholder;
    }


    /**
     * Updates the placeholder by adding the correct guess to the 'hidden' word.
     *
     * @param placeholder the placeholder that gets updated - (String[])
     * @param word the word to be checked against           - (String[])
     * @param guess the users guess                         - (String)
     * @return the updated placeholder                      - (String[])
     */
    public static String[] updatePlaceholder(String[] placeholder, String[] word, String guess) {
        ArrayList<Integer> characterIndex = findCharIndex(word, guess);
        for (int i = 0; i < characterIndex.size(); i++) {
            placeholder[characterIndex.get(i)] = guess;
        }
        return placeholder;
    }


    /**
     * Finds all matches of current guess and stores the indexes in an array that gets returned.
     *
     * @param word the word that contains the solution  - (String[])
     * @param guess the users guess                     - (String)
     * @return the character indexes of the right guess - (ArrayList<Integer>)
     */
    public static ArrayList<Integer> findCharIndex(String[] word, String guess) {
        ArrayList<Integer> charIndexes = new ArrayList<Integer>();
        for (int i = 0; i < word.length; i++) {
            if (word[i].equalsIgnoreCase(guess)) {
                charIndexes.add(i);
            }
        }
        return charIndexes;
    }


    /**
     * Prints the placeholder.
     *
     * @param placeholder the placeholder that gets printed - (String[])
     */
    public static void printPlaceholder(String[] placeholder) {
        System.out.print("\nWord:\t" + String.join(" ", placeholder));
    }


    /**
     * Prints the characters that were misses.
     *
     * @param misses the missed characters - (String)
     */
    public static void printMisses(String misses) {
        System.out.print("\n\nMisses:\t" + misses);
    }


    /**
     * Updates the missed characters by adding them to the previous 'misses' String.
     *
     * @param misses the previously missed characters - (String)
     * @param guess the users guess                   - (String)
     * @return the updated missed characters String   - (String)
     */
    public static String updateMisses(String misses, String guess) {
        return misses + guess;
    }


    /**
     * Checks if the user wins by comparing all the characters.
     *
     * @param placeholder the placeholder that contains the users guesses - (String[])
     * @param word the word that the user tries to guess                  - (String[])
     * @return the result                                                 - (boolean)
     */
    public static boolean checkWin(String[] placeholder, String[] word) {
        for (int i = 0; i < placeholder.length; i++) {
            if (!placeholder[i].equalsIgnoreCase(word[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Converts a String array to normal String.
     *
     * @param word the String array that gets converted - (String[])
     * @return the word in String format                - (String)
     */
    public static String wordToString(String[] word) {
        return String.join("", word);
    }
}
