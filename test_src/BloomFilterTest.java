import org.junit.Assert;
import org.junit.Test;

public class BloomFilterTest {

    @Test
    public void addString(){
        BloomFilter bl = new BloomFilter(32);
        bl.add("0123456789");
        bl.add("1234567890");
        bl.add("2345678901");
        bl.add("3456789012");
        bl.add("4567890123");
        bl.add("5678901234");
        bl.add("6789012345");
        bl.add("7890123456");
        bl.add("8901234567");
        bl.add("9012345678");
        Assert.assertTrue(bl.isValue("0123456789"));
        Assert.assertTrue(bl.isValue("1234567890"));
        Assert.assertTrue(bl.isValue("2345678901"));
        Assert.assertTrue(bl.isValue("3456789012"));
        Assert.assertTrue(bl.isValue("4567890123"));
        Assert.assertTrue(bl.isValue("5678901234"));
        Assert.assertTrue(bl.isValue("6789012345"));
        Assert.assertTrue(bl.isValue("7890123456"));
        Assert.assertTrue(bl.isValue("8901234567"));
    }
}
