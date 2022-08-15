import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HashTableTest {

    @Test
    public void putTest(){
        HashTable testHash = new HashTable(17,3);
        int slot = testHash.seekSlot("test");
        assertEquals(slot, testHash.put("test"));
        assertEquals(slot, testHash.find("test"));
    }

    @Test
    public void putTestTwice(){
        HashTable testHash = new HashTable(17,3);
        int[] slot = new int[6];
        slot[5] = testHash.put("test");
        for (int i = 0; i < 5; i++) {
            slot[i] = testHash.put("test" + i);
        }
        for (int i = 0; i < 5; i++) {
            assertTrue(slot[i] < testHash.size);
        }
        assertEquals(slot[5], testHash.find("test"));
        assertEquals(slot[0], testHash.find("test0"));
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

    @Test
    public void findNotExistElementInEmpty(){
        HashTable testHash = new HashTable(17,3);
//        int[] slot = new int[5];
//        for (int i = 0; i < 5; i++) {
//            slot[i] = testHash.put("test" + i);
//        }
        assertEquals(-1, testHash.find("test5"));
    }
}
