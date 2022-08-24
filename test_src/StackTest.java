import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void popEmptyStackTest() {
        Stack<Integer> stackTest = new Stack<>();
        Assert.assertNull(stackTest.pop());
    }

    @Test
    public void peekEmptyStackTest() {
        Stack<Integer> stackTest = new Stack<>();
        Assert.assertNull(stackTest.peek());
    }

    @Test
    public void pushFiveElementInStackTest() {
        Stack<Integer> stackTest = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stackTest.push(i);
        }
        Assert.assertEquals(stackTest.size(), 5);
        Assert.assertEquals(stackTest.peek().intValue(), 4);
    }

    @Test
    public void checkBracketsBalance() {
        Assert.assertTrue(checkString("(()())"));
        Assert.assertFalse(checkString("())("));
        Assert.assertFalse(checkString("))(("));
        Assert.assertTrue(checkString("(()((())()))"));
    }

    public boolean checkString(String str) {
        char[] chars = str.toCharArray();
        if (chars.length % 2 != 0)
            return false;
        Stack<Character> left = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left.push(chars[i]);
                continue;
            }
            if (left.peek() == null)
                return false;
            left.pop();
        }
        return left.size() == 0;
    }

    @Test
    public void calculateEquation() {
        Assert.assertEquals(9, postfixCalculation("12+3*"));
        Assert.assertEquals(59, postfixCalculation("82+5*9+"));
//        Assert.assertFalse(checkString("())("));
//        Assert.assertFalse(checkString("))(("));
//        Assert.assertTrue(checkString("(()((())()))"));
    }

    public int postfixCalculation(String equation) {
        char[] chars = equation.toCharArray();
        Stack<Integer> digits = new Stack<>();
        Stack<Character> signs = new Stack<>();
        boolean isAfterSign = false;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (isAfterSign) {
                    Integer x = digits.peek();
                    Integer y = null;
                    if (digits.size() >= 2) {
                        digits.pop();
                        y = digits.pop();
                        digits.push(Character.getNumericValue(chars[i]));
                    } else {
                        y = Character.getNumericValue(chars[i]);
                    }
                    Character action = signs.pop();
                    extracted(digits, x, y, action);
                    isAfterSign = false;
                    continue;
                }
                if (!isAfterSign) {
                    digits.push(Character.getNumericValue(chars[i]));
                }
                continue;
            }
            signs.push(chars[i]);
            isAfterSign = true;
        }
        if (signs.size() > 0) {
            Integer x = digits.pop();
            Integer y = digits.pop();
            return extracted(digits, x, y, signs.pop());
        }
        return digits.pop();
    }

    private Integer extracted(Stack<Integer> digits, Integer x, Integer y, Character action) {
        switch (action) {
            case ('-'):
                digits.push(x - y);
                break;
            case ('+'):
                digits.push(x + y);
                break;
            case ('*'):
                digits.push(x * y);
                break;
            case ('/'):
                if (y != 0)
                    digits.push(x / y);
                break;
        }
        return digits.peek();
    }
}
