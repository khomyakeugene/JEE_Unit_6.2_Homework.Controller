import java.util.Random;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class Util {
    private static final int DEFAULT_UPPER_BOUND = 1000;
    private static final int DECIMAL_PRECISION = 2;

    static private Random random = new Random();

    private static double round(double value, int decimalPrecision) {
        double decimalPower = Math.pow(10, decimalPrecision);

        return Math.round(value  * decimalPower) / decimalPower;
    }

    public static double getRandomDouble(int upperBoud) {
        return round(random.nextDouble() * upperBoud, DECIMAL_PRECISION);
    }

    public static double getRandomDouble() {
        return getRandomDouble(DEFAULT_UPPER_BOUND);
    }

    public static int getRandomInteger() {
        return random.nextInt(DEFAULT_UPPER_BOUND);
    }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
