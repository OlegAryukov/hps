import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;
        if (node.value == _value) {
            if (node.next != null)
                this.head = node.next;
            else
                this.head = null;
            return true;
        }
        while (node.next != null) {
            if (node.next.value == _value) {
                if (node.next.next != null)
                    node.next = node.next.next;
                else
                    node.next = null;
                return true;
            }
            node = node.next;
        }
        if (node.value == _value) {
            this.tail = null;
            return true;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        if (node != null) {
            if (node.value == _value) {
                if (node.next != null)
                    this.head = node.next;
                else
                    this.head = null;
            }
        }
        while (node.next != null) {
            if (node.next.value == _value) {
                if (node.next.next != null)
                    node.next = node.next.next;
                else
                    node.next = null;
            }
            node = node.next;
        }
        if (node.value == _value)
            this.tail = null;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        // здесь будет ваш код очистки всего списка
    }

    public int count() {
        if (this.head == null)
            return 0;
        Node node = this.head;
        int count = 1;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null)
            this.head = _nodeToInsert;
        Node node = this.head;
        while (node.next != null) {
            if (node.equals(_nodeAfter)) {
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
                node = node.next;
                break;
            }
            node = node.next;
        }
        if (node.equals(_nodeAfter)) {
            node.next = _nodeToInsert;
            _nodeToInsert.next = null;
        }
    }
    // здесь будет ваш код вставки узла после заданного

    // если _nodeAfter = null ,
    // добавьте новый элемент первым в списке

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}
