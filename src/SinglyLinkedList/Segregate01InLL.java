package SinglyLinkedList;

public class Segregate01InLL {
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
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(0);
        Node n4 = new Node(1);
        Node n5 = new Node(0);
        Node n6 = new Node(0);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        Node dummyOne = new Node(-1);
        Node dummyZero = new Node(-1);
        Node prevOne = dummyOne;
        Node prevZero = dummyZero;
        Node curr = head;
        while (curr != null) {
            if (curr.val == 1) {
                prevOne.next = curr;
                prevOne = prevOne.next;
            } else {
                prevZero.next = curr;
                prevZero = prevZero.next;
            }
            curr = curr.next;
        }
        prevZero.next = dummyOne.next;
        prevOne.next = null;
        printLL(dummyZero.next);

    }

    private static void printLL(Node th) {
        Node curr = th;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

}
