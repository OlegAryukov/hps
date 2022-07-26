import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        if (this.head == null) {
            return nodes;
        }
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
            if (node.next != null) {
                node.next.prev = null;
                this.head = node.next;
            } else {
                clear();
            }
            return true;
        }
        node = node.next;
        while (node != null) {
            if (node.value == _value) {
                if (node.next != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                } else {
                    this.tail = node.prev;
                    node.prev.next = null;
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        if (node != null) {
            while (node.next != null) {
                if (node.value == _value) {
                    if (node.equals(this.head)) {
                        node = node.next;
                        node.prev = null;
                        this.head = node;
                        continue;
                    }
                    node.next.prev = node.prev;
                    node.prev.next = node.next;
                }
                node = node.next;
            }
            if (node.value == _value) {
                if (node.equals(this.head)) {
                    clear();
                }
                if (node.equals(tail)) {
                    node.prev.next = null;
                    this.tail = node.prev;
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
        if (_nodeAfter == null) {
            if (this.head != null) {
                _nodeToInsert.next = this.head;
                _nodeToInsert.next.prev = _nodeToInsert;
                this.head = _nodeToInsert;
            } else {
                this.head = _nodeToInsert;
                this.tail = _nodeToInsert;
            }
        }
        Node node = this.head;
        if (node != null) {
            while (node.next != null) {
                if (node.equals(_nodeAfter)) {
                    _nodeToInsert.next = node.next;
                    node.next.prev = _nodeToInsert;
                    _nodeToInsert.prev = node;
                    node.next = _nodeToInsert;
                    node=node.next;
                    break;
                }
                node = node.next;
            }
            if (node.equals(_nodeAfter)) {
                node.next = _nodeToInsert;
                _nodeToInsert.prev = node;
                this.tail = _nodeToInsert;
            }
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
