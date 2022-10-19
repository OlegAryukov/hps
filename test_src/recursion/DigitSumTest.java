package recursion;

import org.junit.Assert;
import org.junit.Test;

public class DigitSumTest {

    @Test
    public void testSum(){
        Assert.assertEquals(15, DigitSumTask.calcDigitsNumSum(12345));
    }

    @Test
    public void testSumZero(){
        Assert.assertEquals(0, DigitSumTask.calcDigitsNumSum(0));
    }

    @Test
    public void testSumOne(){
        Assert.assertEquals(1, DigitSumTask.calcDigitsNumSum(1));
    }
}
