/**
 * Simple program that converts an array of celsius temperatures to
 * fahrenheit temperatures.
 * This task is from The Complete Java Development Bootcamp course on Udemy (link in README).
 *
 * @author sondrefjellvingandersen
 */
public class Weather {
    public static void main(String[] args) {
        double[] celsius = {12.5, 14.5, 17.0, 21.0, 23.0, 18.5, 20.0};
        double[] fahrenheit = celsiusToFahrenheit(celsius);

        printTemperatures(celsius, "Celsius");
        printTemperatures(fahrenheit, "Fahrenheit");
    }

    /**
     * Converts an array of celsius temperatures to an array of
     * fahrenheit temperatures and returns it.
     *
     * @param celsius the celsius temperatures - (double)
     * @return the fahrenheit temperatures     - (double)
     */
    public static double[] celsiusToFahrenheit(double[] celsius) {
        double[] fahrenheit = new double[celsius.length];
        for (int i = 0; i < fahrenheit.length; i++) {
            fahrenheit[i] = (celsius[i] * 9/5) + 32;
        }
        return fahrenheit;
    }


    /**
     * Prints the temperatures.
     *
     * @param temp the list of temperatures - (double[])
     * @param tempType the temperature type - (String)
     */
    public static void printTemperatures(double[] temp, String tempType) {
        System.out.print(tempType + ": ");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.print("\n");
    }
}
