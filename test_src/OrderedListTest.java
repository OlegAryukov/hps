import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

public class OrderedListTest {

    @Test
    public void appendNode(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(1, orderedList.count());
        Assert.assertEquals(orderedList.tail, orderedList.find(1));
    }

    @Test
    public void appendNodeInAsdOrder(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(5, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{0,1,2,3,4});
    }

    @Test
    public void appendNodeInDescOrder(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(5, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{4,3,2,1,0});
    }

    @Test
    public void appendNodeInAsdOrderInMiddle(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        orderedList.add(3);
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(6, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{0,1,2,3,3,4});
    }

    @Test
    public void appendNodeInDescOrderInMiddle(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        orderedList.add(3);
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(6, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{4,3,3,2,1,0});
    }

    @Test
    public void appendNodeInAsdOrderInHead(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        orderedList.add(-1);
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(6, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{-1,0,1,2,3,4});
        orderedList.add(-1);
        Assert.assertEquals(7, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{-1,-1,0,1,2,3,4});
    }

    @Test
    public void appendNodeInDescOrderInHead(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        orderedList.add(5);
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(6, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{5,4,3,2,1,0});
    }

    @Test
    public void removeItem(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        orderedList.delete(3);
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(4, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{4,2,1,0});
    }

    @Test
    public void removeItemLast(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        for (int i = 0; i < 5; i++) {
            orderedList.add(i);
        }
        orderedList.delete(0);
        Assert.assertEquals(orderedList.find(1).value, Integer.valueOf(1));
        Assert.assertEquals(4, orderedList.count());
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), new Object[]{4,3,2,1});
    }
    @Test
    public void removeItemLastFromTwoElements(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        for (int i = 0; i < 1; i++) {
            orderedList.add(i);
        }
        orderedList.delete(0);
        Assert.assertEquals(0, orderedList.count());
    }

    @Test
    public void removeSingleItem(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
            orderedList.add(1);
        orderedList.delete(1);
        Assert.assertEquals(null, orderedList.find(1));
        Assert.assertEquals(0, orderedList.count());
    }

    @Test
    public void removeDoubleItemDesc(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.delete(2);
        Assert.assertEquals(null, orderedList.find(2));
        Assert.assertEquals(1, orderedList.count());
    }

    @Test
    public void removeDoubleItemAsc(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.delete(2);
        Assert.assertEquals(null, orderedList.find(2));
        Assert.assertEquals(1, orderedList.count());
    }

    @Test
    public void removeAllItemAsc(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(0);
        orderedList.add(2);
        orderedList.add(1);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(1);
        orderedList.add(0);
        orderedList.delete(1);
        Object[] res = {0, 0, 1, 1, 2, 2};
        OrderNode node = orderedList.head;
        for (int i = 0; i < res.length; i++) {
            Assert.assertEquals(res[i], node.value);
            node = node.next;
        }
        Assert.assertArrayEquals(orderedList.getAll().stream().map(value -> value.value).collect(Collectors.toList()).toArray(), res);
    }

    @Test
    public void clearList(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(0);
        orderedList.add(2);
        orderedList.add(1);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(1);
        orderedList.add(0);
        orderedList.clear(true);
        Assert.assertTrue(orderedList.head==null);
        Assert.assertTrue(orderedList.tail==null);
        Assert.assertTrue(orderedList.count()==0);

    }
}
