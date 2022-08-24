import java.util.*;

public class LinkedList2 {
    public Node2 head;
    public Node2 tail;

    public LinkedList2() {
        head = null;
        tail = null;
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
        Node2 node2 = this.head;
        if (node2 != null) {
            while (node2.next != null) {
                if (node2.value == _value) {
                    if (node2.equals(this.head)) {
                        node2 = node2.next;
                        node2.prev = null;
                        this.head = node2;
                        continue;
                    }
                    node2.next.prev = node2.prev;
                    node2.prev.next = node2.next;
                }
                node2 = node2.next;
            }
            if (node2.value == _value) {
                if (node2.equals(this.head)) {
                    clear();
                }
                if (node2.equals(tail)) {
                    node2.prev.next = null;
                    this.tail = node2.prev;
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

    public void insertAfter(Node2 _node2After, Node2 _node2ToInsert) {
        if (_node2After == null) {
            if (this.head != null) {
                _node2ToInsert.next = this.head;
                _node2ToInsert.next.prev = _node2ToInsert;
                this.head = _node2ToInsert;
            } else {
                this.head = _node2ToInsert;
                this.tail = _node2ToInsert;
            }
        }
        Node2 node2 = this.head;
        if (node2 != null) {
            while (node2.next != null) {
                if (node2.equals(_node2After)) {
                    _node2ToInsert.next = node2.next;
                    node2.next.prev = _node2ToInsert;
                    _node2ToInsert.prev = node2;
                    node2.next = _node2ToInsert;
                    node2 = node2.next;
                    break;
                }
                node2 = node2.next;
            }
            if (node2.equals(_node2After)) {
                node2.next = _node2ToInsert;
                _node2ToInsert.prev = node2;
                this.tail = _node2ToInsert;
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
