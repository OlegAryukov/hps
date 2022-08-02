import java.util.*;

public class Queue<T> {
    public LinkedList<T> source;

    public Queue() {
        this.source = new LinkedList<>();
        // инициализация внутреннего хранилища очереди
    }

    public void enqueue(T item) {
        source.addLast(item);
        // вставка в хвост
    }

    public T dequeue() {

        // выдача из головы
        if (source.size() == 0)
            return null; // null если очередь пустая

        T first = source.getFirst();
        source.removeFirst();
        return first;
    }

    public int size() {
        return source.size(); // размер очереди
    }

}
