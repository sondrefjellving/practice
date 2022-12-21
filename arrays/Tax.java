import java.util.Arrays;

/**
 * A simple program that creates a list of prices after tax, by using a list of prices before tax.
 * This task is from The Complete Java Development Bootcamp course on Udemy (link in README).
 *
 * @author sondrefjellvingandersen
 */
public class Tax {
    public static void main(String[] args) {
        double[] price = {1.99, 2.99, 3.99, 4.99};

        System.out.println("The original prices are: " + Arrays.toString(price));

        double[] afterTax = calculateTax(price);

        System.out.println("The prices after tax are: " + Arrays.toString(afterTax));
    }

    /**
     * Receives an array with prices without tax and returns an array with prices after tax.
     *
     * @param beforeTax the prices before tax - (double[])
     * @return the prices after tax           - (double[])
     */
    public static double[] calculateTax(double[] beforeTax) {
        double[] afterTax = new double[beforeTax.length];

        for (int i = 0; i < beforeTax.length; i++) {
            afterTax[i] = (beforeTax[i] * 1.13);
        }

        return afterTax;
    }
}
