public class    LinkedList2Tests {
    public static void main(String[] args) {
        Node2 one = new Node2(1);
        Node2 two = new Node2(2);
        Node2 three = new Node2(3);
        Node2 four = new Node2(4);
        Node2 five = new Node2(5);
        Node2 six = new Node2(6);
        Node2 seven = new Node2(7);
        Node2 eight = new Node2(8);
        Node2 nine = new Node2(9);
        Node2 secondTwo = new Node2(2);
        Node2 thirdTwo = new Node2(2);
        Node2 forthTwo = new Node2(2);

        LinkedList2 l2 = new LinkedList2();
        l2.addInTail(new Node2(2));
        l2.addInTail(new Node2(2));
        l2.addInTail(new Node2(1));
        l2.addInTail(new Node2(3));
        l2.addInTail(new Node2(6));

        l2.removeAll(2);
        System.out.println(l2.remove(6));
        System.out.println(l2.remove(3));
        l2.removeAll(1);
        l2.removeAll(1);
        System.out.println(l2.count());
        System.out.println(l2.remove(6));
        l2.insertAfter(null, new Node2(8));
        l2.insertAfter(null, new Node2(9));
        System.out.println(l2.count());

        LinkedList2 ll = new LinkedList2();
        System.out.println(ll.remove(0));
        System.out.println(ll.find(1));
        ll.insertAfter(null, eight);
        System.out.println(ll.remove(1));
        System.out.println(ll.remove(8));
        System.out.println(ll.head);
        System.out.println(ll.tail);

        ll.addInTail(one);
        ll.addInTail(two);
        ll.addInTail(secondTwo);
        ll.addInTail(four);

        System.out.println(ll.count());

        ll.findAll(2).forEach(n -> System.out.print(n.value));
        ll.insertAfter(two, three);
        System.out.println("\n"+ll.find(3).value);
        ll.remove(2);
        ll.findAll(2).forEach(n -> System.out.print("\n"+n.value));
        ll.insertAfter(null, nine);
        ll.findAll(2).forEach(n -> System.out.print(n.value));
        ll.removeAll(2);
        System.out.println(ll.find(2));
        System.out.println(ll.remove(4));
        System.out.println(ll.find(3).next);


    }
}
