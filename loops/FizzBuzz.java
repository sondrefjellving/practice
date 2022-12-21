/**
 * The famous FizzBuzz problem.
 * Task is from The Complete Java Development Bootcamp course on Udemy (link in Readme).
 *
 * @author sondrefjellvingandersen
 */
public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 0; i <= 18; i++) {
            if (i % 3 == 0 && i % 5 == 0) { // multiple of 3 and 5
                System.out.println(i + " - FizzBuzz");
            } else if (i % 3 == 0) { // multiple of 3
                System.out.println(i + " - Fizz");
            } else if (i % 5 == 0) { // multiple of 5
                System.out.println(i + " - Buzz");
            }
        }
    }
}
