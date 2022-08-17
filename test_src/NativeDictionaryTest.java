import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NativeDictionaryTest {

    @Test
    public void putTest(){
        NativeDictionary<Integer> testHash = new NativeDictionary<>(16,Integer.class);
        testHash.put("test", 1);
        assertEquals(Integer.valueOf(1), testHash.get("test"));
    }


    @Test
    public void putTestWithReplace(){
        NativeDictionary<Integer> testHash = new NativeDictionary<>(16,Integer.class);
        testHash.put("test", 1);
        assertEquals(Integer.valueOf(1), testHash.get("test"));
        testHash.put("test", 3);
        assertEquals(Integer.valueOf(3), testHash.get("test"));
    }

    @Test
    public void putTestTwice(){
        NativeDictionary<Integer> testHash = new NativeDictionary<>(16,Integer.class);
        int[] slots = new int[16];
        for (int i = 0; i < 16; i++) {
            slots[i] = i;
            testHash.put("test" + i, i);
        }
        for (int i = 0; i < 16; i++) {
            assertEquals(java.util.Optional.of(slots[i]).get(), testHash.get("test"+i));
        }
    }

    @Test
    public void putTestFullMap(){
        HashTable testHash = new HashTable(17,3);
        int[] slot = new int[18];
        for (int i = 0; i < 18; i++) {
            slot[i] = testHash.put("test" + i);
        }
        for (int i = 0; i < 18; i++) {
            assertTrue(slot[i] < testHash.size);
        }
        assertEquals(slot[0], testHash.find("test0"));
        assertEquals(slot[17], -1);
    }

    @Test
    public void findNotExistElement(){
        HashTable testHash = new HashTable(17,3);
        int[] slot = new int[5];
        for (int i = 0; i < 5; i++) {
            slot[i] = testHash.put("test" + i);
        }
        assertEquals(-1, testHash.find("test5"));
    }
}
