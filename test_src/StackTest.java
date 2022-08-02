import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class StackTest {

    @Test
    public void popEmptyStackTest(){
        Stack<Integer> stackTest = new Stack<>();
        Assert.assertNull(stackTest.pop());
    }

    @Test
    public void peekEmptyStackTest(){
        Stack<Integer> stackTest = new Stack<>();
        Assert.assertNull(stackTest.peek());
    }

    @Test
    public void pushFiveElementInStackTest(){
        Stack<Integer> stackTest = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stackTest.push(i);
        }
        Assert.assertEquals(stackTest.size(), 5);
        Assert.assertEquals(stackTest.peek().intValue(), 4);
    }


}
