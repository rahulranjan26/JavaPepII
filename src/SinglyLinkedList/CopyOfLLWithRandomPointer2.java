package SinglyLinkedList;

public class CopyOfLLWithRandomPointer2 {
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

        Node nHead = copyLLWithRandomPointer2(head);

    }

    private static Node copyLLWithRandomPointer2(Node head) {
        copyOfLL(head);
        copyOfRandomPointers(head);
        return extractCopiedLL(head);

    }

    private static Node extractCopiedLL(Node head) {
        Node dummyNode = new Node(-1);
        Node prev = dummyNode;
        Node curr = head;
        while (curr != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        return dummyNode.next;

    }

    private static void copyOfRandomPointers(Node head) {
        Node curr = head;
        while (curr != null) {
            Node random = curr.random;
            if (random != null) curr.next.random = random.next;
            curr = curr.next;
        }
    }

    private static void copyOfLL(Node head) {
        Node forward;
        Node curr = head;

        while (curr != null) {
            forward = curr.next;
            Node node = new Node(curr.val);
            curr.next = node;
            node.next = forward;
            curr = forward;
        }
    }
}
