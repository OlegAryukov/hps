import org.junit.Test;

import static org.junit.Assert.*;

public class PowerSetTest {

    @Test
    public void putTest(){
        PowerSet testSet = new PowerSet();
        testSet.put("test");
        assertEquals(1, testSet.size());
        testSet.put("test");
        assertEquals(1, testSet.size());
    }

    @Test
    public void putTestMany(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        assertEquals(10000, testSet.size());
    }

    @Test
    public void removeTest(){
        PowerSet testSet = new PowerSet();
        testSet.put("test");
        assertEquals(1, testSet.size());
        testSet.put("test2");
        assertEquals(2, testSet.size());
        testSet.remove("test");
        assertEquals(1, testSet.size());
        assertTrue( testSet.get("test2"));
        assertFalse( testSet.get("test"));
    }

    @Test
    public void notEmptyIntersectionSetTest(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 5000; i < 15000; i++) {
            testSet2.put("test" + i);
        }
        PowerSet intersection = testSet.intersection(testSet2);
        assertTrue(intersection.size()==5000);
        for (int i = 5000; i <10000 ; i++) {
         assertTrue(intersection.get("test" + i));
        }
    }

    @Test
    public void emptyIntersectionSetTest(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 10000; i < 15000; i++) {
            testSet2.put("test" + i);
        }
        PowerSet intersection = testSet.intersection(testSet2);
        assertTrue(intersection.size()==0);
    }

    @Test
    public void notEmptyUnionSetTest(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 10000; i < 15000; i++) {
            testSet2.put("test" + i);
        }
        PowerSet union = testSet.union(testSet2);
        assertTrue(union.size()==15000);
    }

    @Test
    public void emptyUnionSetTest(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        PowerSet union = testSet.union(testSet2);
        assertTrue(union.size()==10000);
    }

    @Test
    public void notEmptyDifferenceSetTest(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 5000; i < 15000; i++) {
            testSet2.put("test" + i);
        }
        PowerSet difference = testSet.difference(testSet2);
        assertTrue(difference.size()==5000);
        for (int i = 0; i <5000 ; i++) {
            assertTrue(difference.get("test" + i));
        }
    }

    @Test
    public void emptyDifferenceSetTest(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet2.put("test" + i);
        }
        PowerSet difference = testSet.difference(testSet2);
        assertTrue(difference.size()==0);
    }

    @Test
    public void allOfSrcInParamSubset(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 3000; i < 7000; i++) {
            testSet2.put("test" + i);
        }
        assertTrue(testSet.isSubset(testSet2));
    }

    @Test
    public void allElementsInSrcSubset(){
        PowerSet testSet = new PowerSet();
        for (int i = 3000; i < 7000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet2.put("test" + i);
        }
        assertFalse(testSet.isSubset(testSet2));
    }

    @Test
    public void notAllElementsOfParamInSrcSet(){
        PowerSet testSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            testSet.put("test" + i);
        }
        PowerSet testSet2 = new PowerSet();
        for (int i = 0; i < 15000; i++) {
            testSet2.put("test" + i);
        }
        assertFalse(testSet.isSubset(testSet2));
    }
}
