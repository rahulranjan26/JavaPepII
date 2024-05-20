package SinglyLinkedList;

public class SubtractTwoLL {
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
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node head2 = new Node(9);
        Node n7 = new Node(2);
        Node n8 = new Node(3);
        Node n9 = new Node(4);
        Node n10 = new Node(5);
//        Node n11 = new Node(6);
//        Node n12 = new Node(7);

        head2.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
//        n10.next = n11;
//        n11.next = n12;
        Node node1 = revers(head);
        Node node2 = revers(head2);
        Node fHead = sub2LL(node1, node2);
        fHead = revers(fHead);
        printLL(fHead);


    }

    private static Node sub2LL(Node node1, Node node2) {
        Node c1 = node1;
        Node c2 = node2;

        int borrow = 0;
        Node dummyNode = new Node(-1);
        Node prev = dummyNode;

//        Node1>Node2;
        while (c1 != null) {
            int sub = c1.val - (c2 != null ? c2.val : 0) + borrow;
            if (sub < 0) {
                sub += 10;
                borrow = -1;
            } else
                borrow = 0;
            Node newNode = new Node(sub);
            prev.next = newNode;
            prev = prev.next;
            c1 = c1.next;
            c2 = c2 != null ? c2.next : null;
        }
        return dummyNode.next;

    }

    public static Node revers(Node head) {
        Node curr = head;
        Node prev = null;
        Node ford;

        while (curr != null) {
            ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ford;
        }
        return prev;
    }

    public static void printLL(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }


}
