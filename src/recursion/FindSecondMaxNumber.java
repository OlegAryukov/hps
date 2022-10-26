package recursion;

import java.util.List;

public class FindSecondMaxNumber {

    public Integer findSecondMaxNumber(List<Integer> numbers) {
        if (numbers.isEmpty())
            return null;
        if (numbers.size() == 1)
            return numbers.get(0);
        if (numbers.size() == 2)
            return Math.min(numbers.get(0), numbers.get(1));
        int firstMax = Math.max(numbers.get(0), numbers.get(1));
        int secondMax = Math.min(numbers.get(0), numbers.get(1));
        return recurFindSecondNum(numbers, firstMax, secondMax, 0);
    }

    private Integer recurFindSecondNum(List<Integer> numbers, int firstMax, int secondMax, int i) {
        boolean endRecursionFlag = i == numbers.size() - 1;
        if (numbers.get(i) > secondMax && numbers.get(i) < firstMax)
            secondMax = numbers.get(i);
        if (numbers.get(i) > firstMax){
            secondMax = firstMax;
            firstMax = numbers.get(i);
        }
        return endRecursionFlag ? secondMax : recurFindSecondNum(numbers, firstMax, secondMax, i + 1);
    }
}
