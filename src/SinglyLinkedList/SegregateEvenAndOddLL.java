package SinglyLinkedList;

public class SegregateEvenAndOddLL {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will learn about the segregation of odd and even");
        Node head = new Node(1);
        Node n1 = new Node(18);
        Node n2 = new Node(9);
        Node n3 = new Node(5);
        Node n4 = new Node(14);
        Node n5 = new Node(3);
        Node n6 = new Node(25);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node ans = segregateFunction(head);
        printLL(ans);

    }

    private static void printLL(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

    }

    private static Node segregateFunction(Node node) {
        if (node == null || node.next == null)
            return node;

        Node dummyOdd = new Node(-1);
        Node dummyEven = new Node(-1);

        Node evenTail = dummyEven;
        Node oddTail = dummyOdd;
        Node curr = node;

        while (curr != null) {
            if (curr.val % 2 != 0) {
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            curr = curr.next;
        }
        evenTail.next = dummyOdd.next;
        return dummyEven.next;
    }
}
