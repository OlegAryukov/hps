package recursion;

public class DigitSumTask {

    public static long calcDigitsNumSum(int digit){
        if (digit == 0)
            return 0;
        return (digit % 10 + calcDigitsNumSum(digit / 10));
    }
}
