package SinglyLinkedList;

public class ReverseALLUsingAddFirst {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Merge  linked list");
        Node head = new Node(1);
        Node n1 = new Node(7);
        Node n2 = new Node(9);
        Node n3 = new Node(10);
        Node n4 = new Node(14);
        Node n5 = new Node(18);
        Node n6 = new Node(25);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            prev.next = null;
            AddFirst(prev);
        }
        printLL(oh);

    }

    public static Node oh = null;
    public static Node ot = null;

    public static void AddFirst(Node node) {

        if (oh == null) {
            oh = node;
            ot = oh;
        } else {
            node.next = oh;
            oh = node;
        }
    }

    static void printLL(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
