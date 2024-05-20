package SinglyLinkedList;

public class RemoveDuplicatesOfLL {
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
        Node head = new Node(8);
        Node n1 = new Node(8);
        Node n2 = new Node(8);
        Node n3 = new Node(8);
        Node n4 = new Node(8);
        Node n5 = new Node(8);
        Node n6 = new Node(8);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        Node dummyNode = new Node(-1);
        Node prev = dummyNode;
        Node curr = head;
        while (curr != null) {
            if (curr.val != prev.val) {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;

        }
        if (prev.next != null)
            prev.next = null;
        printLL(dummyNode.next);

    }

    public static void printLL(Node head) {
        Node c = head;
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }
    }

}
