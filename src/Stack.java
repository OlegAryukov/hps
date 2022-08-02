import java.util.*;

public class Stack<T> {
    LinkedList<T> source;

    public Stack() {
        this.source = new LinkedList();
    }

    public int size() {
        return this.source.size();
    }

    public T pop() {
        if (this.source.size() > 0) {
            T first = source.getFirst();
            source.removeFirst();
            return first;
        }
        return null;  // если стек пустой
    }

    public void push(T val) {
        source.addFirst(val);
    }

    public T peek() {
        if (this.source.size() > 0) {
            return source.getFirst();
        }
        return null; // если стек пустой
    }
}
