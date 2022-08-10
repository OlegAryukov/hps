import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    private int count;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        Class<?> returnType = v1.getClass();
        if (returnType == String.class) {
            return ((String) v1).compareTo((String) v2);
        } else if (returnType == Short.class) {
            return ((Short) v1).compareTo((Short) v2);
        } else if (returnType == Integer.class) {
            return ((Integer) v1).compareTo((Integer) v2);
        } else if (returnType == Long.class) {
            return ((Long) v1).compareTo((Long) v2);
        } else if (returnType == Float.class) {
            return ((Float) v1).compareTo((Float) v2);
        } else if (returnType == Double.class) {
            return ((Double) v1).compareTo((Double) v2);
        }
        return 0;
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
    }

    public void add(T value) {
        Node<T> insertNode = new Node<>(value);
        if (this.head == null) {
            this.head = insertNode;
            this.head.next = null;
            this.head.prev = null;
            this.tail = insertNode;
        } else if (this.tail == null) {
            if (_ascending && compare(value, this.head.value) == -1) {
                addInHead(this.head, insertNode);
                this.tail = this.head.next;
                this.tail.prev = this.head;
            }
            if (_ascending && (compare(value, this.head.value) == 1 || compare(value, this.head.value) == 0)) {
                this.tail = insertNode;
                this.head.next = this.tail;
                insertNode.prev = this.head;
            }
            if (!_ascending && (compare(value, this.head.value) == 1 || compare(value, this.head.value) == 0)) {
                addInHead(this.head, insertNode);
                this.tail = this.head.next;
                this.tail.prev = this.head;
            }
            if (!_ascending && compare(value, this.head.value) == 1) {
                this.tail = insertNode;
                this.head.next = this.tail;
                insertNode.prev = this.head;
            }
        } else {
            int compareHead = compare(value, this.head.value);
            int compareTail = compare(value, tail.value);
            if (_ascending) {
                if (compareHead == -1 || compareHead == 0) {
                    addInHead(this.head, insertNode);
                } else {
                    if (compareTail == 1 || compareTail == 0) {
                        addInTail(tail, insertNode);
                    } else {
                        Node node = this.head;
                        while (node.next != null) {
                            final int compareRes = compare(value, (T) node.next.value);
                            if (compareRes == -1 || compareRes == 0) {
                                insertNode.next = node.next;
                                node.next.prev = insertNode;
                                insertNode.prev = node;
                                node.next = insertNode;
                                break;
                            }
                            node = node.next;
                        }
                    }
                }
            } else {
                if (compareHead == 1 || compareHead == 0) {
                    addInHead(this.head, insertNode);
                } else {
                    if (compareTail == -1 || compareTail == 0) {
                        addInTail(tail, insertNode);
                    } else {
                        Node node = this.head;
                        while (node.next != null) {
                            final int compareRes = compare(value, (T) node.next.value);
                            if (compareRes == 1 || compareRes == 0) {
                                insertNode.prev = node;
                                node.next.prev = insertNode;
                                insertNode.next = node.next;
                                node.next = insertNode;
                                break;
                            }
                            node = node.next;
                        }
                    }
                }
            }
        }

        count++;
        // автоматическая вставка value
        // в нужную позицию
    }

    public Node<T> find(T val) {
        Node node = this.head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return null; // здесь будет ваш код
    }

    public void delete(T val) {
        Node node = this.head;
        int countOfDec = 0;
        if (node != null) {
            if (node.value == val) {
                if (node.next != null) {
                    node.next.prev = null;
                    this.head = node.next;
                    countOfDec++;
                } else {
                    clear(this._ascending);
                    countOfDec++;
                }
            } else {
                node = node.next;
                while (node != null) {
                    if (node.value == val) {
                        if (node.next != null) {
                            node.prev.next = node.next;
                            node.next.prev = node.prev;
                            countOfDec++;
                        } else {
                            this.tail = node.prev;
                            node.prev.next = null;
                            countOfDec++;
                        }
                        break;
                    }
                    node = node.next;
                }
            }
            count -= countOfDec;
        }
        // здесь будет ваш код
    }

    public void clear(boolean asc) {
        this.head = null;
        this.tail = null;
        _ascending = asc;
        // здесь будет ваш код
    }

    public int count() {
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    private void addInHead(Node<T> head, Node<T> _item) {
        head.prev = _item;
        _item.next = head;
        this.head = _item;
    }

    private void addInTail(Node<T> tail, Node<T> _item) {
        _item.prev = tail;
        tail.next = _item;
        this.tail = _item;
    }
}
