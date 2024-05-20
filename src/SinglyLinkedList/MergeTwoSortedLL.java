package SinglyLinkedList;

public class MergeTwoSortedLL {
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

        Node head2 = new Node(3);
        Node m1 = new Node(8);
        Node m2 = new Node(12);
        Node m3 = new Node(17);
        Node m4 = new Node(20);

        head2.next = m1;
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;


        Node newHead = mergeTwoLL(head, head2);
        printLL(newHead);


    }

    private static Node mergeTwoLL(Node head, Node head2) {
        if (head == null || head2 == null) {
            if (head == null)
                return head2;
            else
                return head;
        }
        Node dummy = new Node(-1);
        Node c1 = head;
        Node c2 = head2;

        Node prev = dummy;


        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;

            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        if (c1 == null) {
            prev.next = c2;
        }

        if (c2 == null)
            prev.next = c1;

        return dummy;
    }

    public static void printLL(Node head) {
        Node c = head;
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }
    }
}
