package recursion;

import java.util.List;

public class EvenDigitPrintTask {

    public static void printEvenDigitTask(List<Integer> numbers, int startIndex){
        if(startIndex!=numbers.size()){
            if(numbers.get(startIndex)%2==0)
                System.out.println(numbers.get(startIndex));
            printEvenDigitTask(numbers, startIndex+1);
        }
    }

    public static void printEvenIndexDigitTask(List<Integer> numbers, int startIndex){
        if(startIndex<=numbers.size()-1)
            printEvenIndexDigitTask(numbers, startIndex+1);
        if(startIndex%2==0 && startIndex<numbers.size()-1){
            System.out.println(numbers.get(startIndex));
        }
    }
}
