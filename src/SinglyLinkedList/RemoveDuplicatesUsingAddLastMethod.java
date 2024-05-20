package SinglyLinkedList;

public class RemoveDuplicatesUsingAddLastMethod {
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
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(8);
        Node n6 = new Node(8);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        Node th = null;
        Node tt = th;
        Node curr = head;
        Node forward;
        while (curr != null) {
            forward = curr.next;
            curr.next = null;
            if (tt == null) {
                tt = curr;
                th = curr;
            } else {
                if (tt.val != curr.val) {
                    tt.next = curr;
                    tt = curr;
                }
            }
            curr = forward;
        }
        printLL(th);

    }

    public static void printLL(Node head) {
        Node c = head;
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }
    }
}
