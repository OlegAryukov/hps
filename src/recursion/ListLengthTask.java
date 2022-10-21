package recursion;


import java.util.Stack;

public class ListLengthTask<T> {

    public int calcListLength(Stack<T> list) {
        T element;
        if (list.size() > 0) {
            element = list.pop();
            int currLength =  1 + calcListLength(list);
            list.push(element);
            return currLength;
        }
        return 0;
    }
}
