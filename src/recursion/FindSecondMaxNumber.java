package recursion;

import java.util.List;

public class FindSecondMaxNumber {

    public Integer findSecondMaxNumber(List<Integer> numbers) {
        if (numbers.isEmpty())
            return null;
        if (numbers.size() == 1)
            return numbers.get(0);
        if (numbers.size()==2)
            return Math.min(numbers.get(0), numbers.get(1));
        int firstMax = Math.max(numbers.get(0), numbers.get(1));
        int secondMax = Math.min(numbers.get(0), numbers.get(1));
        return recurFindSecondNum(numbers, firstMax, secondMax, 0);
    }

    private Integer recurFindSecondNum(List<Integer> numbers, int firstMax, int secondMax, int i) {
        if (numbers.get(i) == secondMax || numbers.get(i) == firstMax)
            return (i == numbers.size() - 1) ? secondMax : recurFindSecondNum(numbers, firstMax, secondMax, i+1) ;
        if (numbers.get(i) > secondMax && numbers.get(i) < firstMax)
            return (i == numbers.size() - 1) ? numbers.get(i) : recurFindSecondNum(numbers, firstMax, numbers.get(i), i+1);
        if(numbers.get(i) > firstMax)
            return  (i == numbers.size() - 1) ? firstMax : recurFindSecondNum(numbers, numbers.get(i), firstMax, i+1);
        return (i == numbers.size() - 1) ? secondMax : recurFindSecondNum(numbers, firstMax, secondMax, i + 1);
    }
}
