package SinglyLinkedList;

public class SegregateTheElementsBasedOnTailVal {
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
        Node head = new Node(15);
        Node n1 = new Node(11);
        Node n2 = new Node(7);
        Node n3 = new Node(8);
        Node n4 = new Node(13);
        Node n5 = new Node(5);
        Node n6 = new Node(9);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node tail = getTail(head);
        Node larger = new Node(-1);
        Node preL = larger;
        Node smaller = new Node(-1);
        Node preS = smaller;
        Node curr = head;
        while (curr != null) {
            if (curr.val <= tail.val) {
                preS.next = curr;
                preS = preS.next;
            } else {
                preL.next = curr;
                preL = preL.next;
            }
            curr = curr.next;
        }
        preS.next = larger.next;
        preL.next = null;
        printLL(smaller.next);


    }

    public static Node getTail(Node node) {
        Node curr = node;
        while (curr.next != null)
            curr = curr.next;
        return curr;
    }

    public static void printLL(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
