package SinglyLinkedList;

public class IntersectionInTwoLL {
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


    }

    private static Node findIntersectionInLL(Node head) {
        if (head == null || head.next == null)
            return null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }
        if (slow != fast)
            return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static Node findIntersectionInTwoLL(Node head1, Node head2) {
        Node tail = head1;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head2;
        Node node = findIntersectionInLL(head1);
        tail.next = null;
        return node;
    }
}
