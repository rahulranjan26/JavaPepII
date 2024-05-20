package SinglyLinkedList;

public class PalindromeLL {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Palindrome  linked list");
        Node head = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        Node n6 = new Node(0);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node mid = midNode(head);
        Node nHead = mid.next;
        mid.next = null;
        nHead = reverseLL(nHead);

        Node c1 = head;
        Node c2 = nHead;
        boolean flag = true;
        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) {
                flag = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        nHead = reverseLL(nHead);
        mid.next = nHead;
        if (flag)
            System.out.println("palindrome");
        else
            System.out.println("Not a palindrome");
        printList(head);


    }

    public static Node reverseLL(Node head) {
        Node curr = head;
        Node prev = null;
        Node forward;

        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }

    public static Node midNode(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
