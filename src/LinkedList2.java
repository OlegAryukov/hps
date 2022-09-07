import java.util.*;

public class LinkedList2 {
    public Node2 head;
    public Node2 tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public static LinkedList2 withHeadAndTail(Node2 head, Node2 tail) {
        LinkedList2 linkedList2 = new LinkedList2();
        head.next = tail;
        tail.prev = head;
        linkedList2.head = head;
        linkedList2.tail = tail;
        return linkedList2;
    }

    public void addInTail(Node2 _item) {
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

    public Node2 find(int _value) {
        Node2 node2 = this.head;
        while (node2 != null) {
            if (node2.value == _value) {
                return node2;
            }
            node2 = node2.next;
        }
        return null;
    }

    public ArrayList<Node2> findAll(int _value) {
        ArrayList<Node2> node2s = new ArrayList<Node2>();
        if (this.head == null) {
            return node2s;
        }
        Node2 node2 = this.head;
        while (node2 != null) {
            if (node2.value == _value) {
                node2s.add(node2);
            }
            node2 = node2.next;
        }
        return node2s;
    }

    public boolean remove(int _value) {
        Node2 node2 = this.head;
        if (node2 == null) {
            return false;
        }
        if (node2.value == _value) {
            if (node2.next != null) {
                node2.next.prev = null;
                this.head = node2.next;
            } else {
                clear();
            }
            return true;
        }
        node2 = node2.next;
        while (node2 != null) {
            if (node2.value == _value) {
                if (node2.next != null) {
                    node2.prev.next = node2.next;
                    node2.next.prev = node2.prev;
                } else {
                    this.tail = node2.prev;
                    node2.prev.next = null;
                }
                return true;
            }
            node2 = node2.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node2 node = this.head;
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
        Node2 node2 = this.head;
        int count = 1;
        while (node2.next != null) {
            count++;
            node2 = node2.next;
        }
        return count;
    }

    public void insertAfter(Node2 _nodeAfter, Node2 _nodeToInsert) {
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
        Node2 node = this.head;
        if (node != null) {
            while (node.next != null) {
                if (node.equals(_nodeAfter)) {
                    _nodeToInsert.next = node.next;
                    node.next.prev = _nodeToInsert;
                    _nodeToInsert.prev = node;
                    node.next = _nodeToInsert;
                    node = node.next;
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

class Node2 {
    public int value;
    public Node2 next;
    public Node2 prev;

    public Node2(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
