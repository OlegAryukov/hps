package recursion;

import org.junit.Assert;
import org.junit.Test;

public class PowerTaskTest {

    @Test
    public void testPowerPlus(){
        Assert.assertEquals(PowTask.calculatePositivePower(2, 10), 1024);
    }

    @Test
    public void testPowerMinus(){
        Assert.assertEquals(0.0009765625, PowTask.calculateNegativePower(2, -10), 0.00000005);
    }

    @Test
    public void testNull(){
        Assert.assertEquals(0, PowTask.calculatePositivePower(0, 10));
        Assert.assertEquals(0, PowTask.calculateNegativePower(0, 10), 0.5);
    }
}
