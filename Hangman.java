import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

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
            } else if(misses.contains(guess)) { // if guess is wrong and already guessed
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

    public static String makeGuess() {
        System.out.print("\nGuess: ");
        String guess = scan.nextLine();
        while (guess.length() != 1) {
            System.out.print("You have to type in one character only: ");
            guess = scan.nextLine();
        }
        return guess;
    }

    public static boolean checkGuess(String guess, String[] checkAgainst) {
        for (int i = 0; i < checkAgainst.length; i++) {
            if (checkAgainst[i].equalsIgnoreCase(guess)) {
                return true;
            }
        }
        return false;
    }

    public static void printLastGuess(String guess) {
        System.out.print("\nGuess:\t" + guess + "\n");
    }


    public static String[] createPlaceholder(String[] word) {
        String[] placeholder = new String[word.length];
        Arrays.fill(placeholder, "_");
        return placeholder;
    }


    public static String[] updatePlaceholder(String[] placeholder, String[] word, String guess) {
        int characterIndex = findCharIndex(word, guess);
        placeholder[characterIndex] = guess;
        return placeholder;
    }

    // find all matches???
    public static int findCharIndex(String[] word, String guess) {
        for (int i = 0; i < word.length; i++) {
            if (word[i].equalsIgnoreCase(guess)) {
                return i;
            }
        }
        return 0;
    }

    public static void printPlaceholder(String[] placeholder) {
        System.out.print("\nWord:\t" + String.join(" ", placeholder));
    }


    public static void printMisses(String misses) {
        System.out.print("\n\nMisses:\t" + misses);
    }

    public static String updateMisses(String misses, String guess) {
        return misses + guess;
    }

    public static boolean checkWin(String[] placeholder, String[] word) {
        for (int i = 0; i < placeholder.length; i++) {
            if (!placeholder[i].equalsIgnoreCase(word[i])) {
                return false;
            }
        }
        return true;
    }


    public static String wordToString(String[] word) {
        return String.join("", word);
    }
}
