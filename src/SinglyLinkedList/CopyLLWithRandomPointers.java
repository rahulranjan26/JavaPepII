package SinglyLinkedList;

import java.util.HashMap;

public class CopyLLWithRandomPointers {
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("This copying of LL with random Pointer is using space. There is another method that uses no" + "space");
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

        Node nHead = copyOfLLWithRandomPointers(head);

    }

    private static Node copyOfLLWithRandomPointers(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node dummyNode = new Node(-1);
        Node prev = dummyNode;
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            prev.next = newNode;
            prev = prev.next;
            curr = curr.next;
        }

        Node nHead = dummyNode.next;
        Node c1 = head;
        Node c2 = nHead;

        while (c1 != null && c2 != null) {
            c2.random = map.get(c2.random);
            c1 = c1.next;
            c2 = c2.next;
        }
        return nHead;

    }
}
