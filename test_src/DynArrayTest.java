import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class DynArrayTest {



    @Test
    public void exceptionTest(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testArray.getItem(17);
        });
    }

    @Test
    public void appendItemWithException(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(1);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(1));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(1, testArray.count);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testArray.insert(17, 3);
        });
    }

    @Test
    public void removeItemWithException(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            testArray.remove(0);
        });
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(0, testArray.count);
    }

    @Test
    public void removeItemFromNonEmptyWithException(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(0);
        testArray.append(1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testArray.remove(4);
        });
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(2, testArray.count);
    }
    @Test
    public void appendItem(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(1);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(1));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(1, testArray.count);
    }

    @Test
    public void insertItem(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(1);
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(1, testArray.count);
        testArray.insert(0, 0);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(0));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(1));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(2, testArray.count);
    }

    @Test
    public void insertItemFillFullBuffer(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(0);
        testArray.append(1);
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(2, testArray.count);
        for (int i = 2; i < 15; i++) {
            testArray.append(i);
        }
        testArray.insert(15, 15);
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(16, testArray.count);
    }

    @Test
    public void insertItemInEnd(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(0);
        testArray.append(1);
        testArray.append(2);
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(3, testArray.count);
        testArray.insert(3, 3);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(0));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(1));
        Assert.assertEquals(testArray.getItem(2), Integer.valueOf(2));
        Assert.assertEquals(testArray.getItem(3), Integer.valueOf(3));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(4, testArray.count);
    }

    @Test
    public void insertItemBeforeLast(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(0);
        testArray.append(1);
        testArray.insert(3, 1);
        testArray.append(2);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(0));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(3));
        Assert.assertEquals(testArray.getItem(2), Integer.valueOf(1));
        Assert.assertEquals(testArray.getItem(3), Integer.valueOf(2));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(4, testArray.count);
    }

    @Test
    public void insertItemInMiddle(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        testArray.append(0);
        testArray.append(1);
        testArray.append(2);
        testArray.append(3);
        testArray.insert(5, 2);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(0));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(1));
        Assert.assertEquals(testArray.getItem(2), Integer.valueOf(5));
        Assert.assertEquals(testArray.getItem(3), Integer.valueOf(2));
        Assert.assertEquals(testArray.getItem(4), Integer.valueOf(3));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(5, testArray.count);
    }


    @Test
    public void insertItemInMiddleWithIncreaseCapacity(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            testArray.append(i);
        }
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(16, testArray.count);
        testArray.insert(16, 8);
        Assert.assertEquals(testArray.getItem(8), Integer.valueOf(16));
        Assert.assertEquals(32, testArray.capacity);
        Assert.assertEquals(17, testArray.count);
    }

    @Test
    public void removeItem(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            testArray.append(i);
        }
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(16, testArray.count);
        testArray.remove(5);
        Assert.assertEquals(testArray.getItem(4), Integer.valueOf(4));
        Assert.assertEquals(testArray.getItem(5), Integer.valueOf(6));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(15, testArray.count);
    }

    @Test
    public void removeItemFromStart(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            testArray.append(i);
        }
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(16, testArray.count);
        testArray.remove(0);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(1));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(2));
        Assert.assertEquals(16, testArray.capacity);
        Assert.assertEquals(15, testArray.count);
    }

    @Test
    public void removeItemWithDecreaseCapacity(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 18; i++) {
            testArray.append(i);
        }
        Assert.assertEquals(32, testArray.capacity);
        Assert.assertEquals(18, testArray.count);
        for (int i = 0; i < 5; i++) {
            testArray.remove(0);
        }
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(5));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(6));
        Assert.assertEquals(21, testArray.capacity);
        Assert.assertEquals(13, testArray.count);
    }

    @Test
    public void removeItemWithDecreaseCapacityOnLowBorder(){
        DynArray<Integer> testArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 18; i++) {
            testArray.append(i);
        }
        Assert.assertEquals(32, testArray.capacity);
        Assert.assertEquals(18, testArray.count);
        for (int i = 0; i < 2; i++) {
            testArray.remove(0);
        }
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(2));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(3));
        Assert.assertEquals(16, testArray.count);
        Assert.assertEquals(32, testArray.capacity);
        testArray.remove(15);
        Assert.assertEquals(testArray.getItem(0), Integer.valueOf(2));
        Assert.assertEquals(testArray.getItem(1), Integer.valueOf(3));
        Assert.assertEquals(15, testArray.count);
        Assert.assertEquals(21, testArray.capacity);
    }
}
