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
        if (node == null) {
            return false;
        }
        if (node.value == _value) {
            if (node.next != null)
                this.head = node.next;
            else {
                clear();
            }
            return true;
        }
        while (node.next != null) {
            if (node.next.value == _value) {
                if (node.next.next != null)
                    node.next = node.next.next;
                else {
                    this.tail = node;
                    node.next = null;
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        Node prev = this.head;
        if (node != null) {
            while (node.next != null) {
                if (node.value == _value) {
                    if (node.equals(this.head)) {
                        node = node.next;
                        this.head = node;
                        continue;
                    }
                    prev.next = node.next;
                    node = node.next;
                    continue;
                }
                prev = node;
                node = node.next;
            }
            if (node.value == _value) {
                if (node.equals(this.head)) {
                    this.head = null;
                    this.tail = null;
                }
                if (node.equals(tail)) {
                    prev.next = null;
                    this.tail = prev;
                }
            }
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
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
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if(_nodeAfter == null){
            if(this.head!=null){
                _nodeToInsert.next = this.head;
                this.head = _nodeToInsert;
            } else {
                this.head = _nodeToInsert;
                this.tail = _nodeToInsert;
            }
        }
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
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}
