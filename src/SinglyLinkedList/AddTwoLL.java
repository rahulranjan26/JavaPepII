package SinglyLinkedList;

public class AddTwoLL {
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
        Node fHead = add2LL(node1, node2);
        fHead = revers(fHead);
        printLL(fHead);


    }

    public static Node revers(Node head) {
        Node curr = head;
        Node prev = null;
        Node ford = null;

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

    public static Node add2LL(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node nHead = dummyNode;
        Node c1 = head1;
        Node c2 = head2;
        int carry = 0;
        while (c1 != null && c2 != null) {
            int sum = c1.val + c2.val + carry;
            int num = sum % 10;
            carry = sum / 10;
            nHead.next = new Node(num);
            nHead = nHead.next;
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            int sum = c1.val + carry;
            int num = sum % 10;
            carry = sum / 10;
            nHead.next = new Node(num);
            nHead = nHead.next;
            c1 = c1.next;
        }

        while (c2 != null) {
            int sum = c2.val + carry;
            int num = sum % 10;
            carry = sum / 10;
            nHead.next = new Node(num);
            nHead = nHead.next;
            c2 = c2.next;
        }
        return dummyNode.next;
    }


}
