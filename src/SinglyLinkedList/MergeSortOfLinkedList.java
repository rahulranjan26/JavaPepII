package SinglyLinkedList;

public class MergeSortOfLinkedList {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Merge Sort of Linked list");
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

        Node ans = mergeSort(head);
        printLL(ans);


    }

    public static Node findMid(Node node) {
        if (node == null || node.next == null)
            return node;

        Node fast = node;
        Node slow = node;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node mergeTwoSortedList(Node n1, Node n2) {
        if (n1 == null || n2 == null)
            return n1 != null ? n2 : n1;

        Node dummy = new Node(-1);
        Node prev = dummy;
        Node c1 = n1;
        Node c2 = n2;

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

        prev.next = c1 != null ? c1 : c2;
        return dummy.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = findMid(head);
        Node nMid = mid.next;
        mid.next = null;

        Node l1 = mergeSort(head);
        Node l2 = mergeSort(nMid);

        return mergeTwoSortedList(l1, l2);
    }

    public static void printLL(Node head) {
        if (head == null)
            return;

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}