package SinglyLinkedList;

public class ReverseNodeInKSize {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static Node oh = null;
    static Node ot = null;

    public static void main(String[] args) {
        System.out.println("Merge  linked list");
        Node head = new Node(1);
        Node n1 = new Node(7);
        Node n2 = new Node(9);
        Node n3 = new Node(10);
        Node n4 = new Node(14);
        Node n5 = new Node(18);
        Node n6 = new Node(25);
        Node n7 = new Node(44);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        int len = lengthOfLL(head);
        Node curr = head;
        while (len >= 3) {
            int count = 0;
            Node tempH = curr;
            Node prev = null;
            while (count < 3) {
                count++;
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            reverseLL(tempH);
            len = len - 3;
        }
        if (curr != null)
            reverseLL(curr);
        printLL(oh);

    }


    public static int lengthOfLL(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }


    public static void reverseLL(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        if (oh == null && ot == null) {
            oh = prev;
            ot = node;
        } else {
            ot.next = prev;
            ot = node;
        }
    }

    public static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

}
