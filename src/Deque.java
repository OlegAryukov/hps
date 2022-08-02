import java.util.*;

public class Deque<T> {

    public LinkedList<T> source;

    public Deque() {
        this.source = new LinkedList<>();
        // инициализация внутреннего хранилища
    }

    public void addFront(T item) {
        source.addFirst(item);
        // добавление в голову
    }

    public void addTail(T item) {
        source.addLast(item);
        // добавление в хвост
    }

    public T removeFront() {
        if (source.size() == 0)
            return null;
        T first = source.getFirst();
        source.removeFirst();
        return first;
    }

    public T removeTail() {
        if (source.size() == 0)
            return null;
        T last = source.getLast();
        source.removeLast();
        return last;
    }

    public int size() {
        return source.size(); // размер очереди
    }
}
