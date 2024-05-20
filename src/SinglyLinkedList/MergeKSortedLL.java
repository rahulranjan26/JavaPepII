package SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLL {

    public static class Node implements Comparable<Node> {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will merge K sorted lists..");
        List<Node> list = new ArrayList<>();
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
        list.add(head);
        list.add(head2);
        Node ans = mergeKSortedLinkedList(list);
        printLL(ans);


    }

    private static Node mergeKSortedLinkedList(List<Node> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (var node : list)
            pq.add(node);

        Node dummy = new Node(-1);
        Node prev = dummy;

        while (!pq.isEmpty()) {
            Node temp = pq.remove();
            prev.next = temp;
            prev = prev.next;

            if (temp.next != null)
                pq.add(temp.next);

        }

        return dummy.next;
    }

    public static void printLL(Node head) {

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

}
