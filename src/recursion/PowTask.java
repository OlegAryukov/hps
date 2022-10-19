package recursion;

public class PowTask {

    public static long calculatePositivePower(int base, int power) {
        if (base == 0)
            return 0;
        if(power > 0 )
            return base * calculatePositivePower(base, power-1);
        return 1;
    }

    public static double calculateNegativePower(int base, int power) {
        if (base == 0)
            return 0;

        return 1.0d / calculatePositivePower(base, -1 * power);
    }
}
