package DoublyLinkedList;

public class DoublyLinkedListAndMethods {
    public static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;


    public static void main(String[] args) {
        System.out.println("Doubly LinkedList and its different methods");
        addFirst(5);
        addFirst(8);
        addFirst(2);
        addFirst(1);
        addFirst(9);
        addFirst(6);

        addLast(5);
        addLast(8);
        addLast(2);
        addLast(1);
        addLast(9);
        addLast(6);

        removeFirst();
        removeFirst();
        removedLast();
        removedLast();

        addAtAnIndex(12, 5);
        removeAtIndex(0);

        printLL(head);
    }

    public static void addFirst(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node newNode = new Node(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }


    }

    public static void printLL(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public static void addLast(int val) {
        if (tail == null) {
            tail = new Node(val);
            head = tail;
        } else {
            Node newNode = new Node(val);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void removeFirst() {
        if (head == null || head.next == null)
            head = tail = null;
        else {
            Node curr = head;
            head = head.next;
            head.prev = null;
            curr.next = null;
        }
    }

    public static void removedLast() {
        if (head == null || head.next == null)
            head = tail = null;
        else {
            Node curr = tail.prev;
            tail.prev = null;
            curr.next = null;
            tail = curr;
        }
    }

    public static int getSize() {
        int count = 0;
        if (head == null)
            return 0;
        if (head.next == null)
            return 1;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static int getFirst() {
        if (head == null)
            return -1;
        if (head.next == null)
            return head.val;
        return head.val;
    }

    public static int getLast() {
        if (head == null) {
            return -1;
        }
        if (head.next == null)
            return head.val;
        return tail.val;
    }

    public static boolean isEmpty() {
        return head == null;
    }

    public static void addAtAnIndex(int val, int idx) {
        if (idx == 0)
            addFirst(val);
        else if (idx == getSize()) {
            addLast(val);
        } else {
            int count = 1;
            Node curr = head;
            Node forward = null;
            while (count != idx && curr.next != null) {
                count++;
//                forward = curr.next;
                curr = curr.next;
            }
            forward = curr.next;

            Node x = new Node(val);
            curr.next = null;
            if (forward != null) {
                forward.prev = null;
            }
            curr.next = x;
            x.prev = curr;
            x.next = forward;
            if (forward != null) {
                forward.prev = x;
            }
        }


    }


    public static void removeAtIndex(int idx) {
        if (idx == 0) {
            removeFirst();
        } else if (idx == getSize()) {
            removedLast();
        } else {
            int count = 0;
            Node curr = head;
            Node forward;
            Node prev;
            while (idx != count) {
                count++;
                curr = curr.next;
            }
            forward = curr.next;
            prev = curr.prev;

            curr.next = null;
            forward.prev = null;
            prev.next = null;
            curr.prev = null;
            prev.next = forward;
            forward.prev = prev;
        }
    }

    public static void addAfterANode(Node v) {

    }

    public static void removeAfterANode(Node v) {
    }

    public static void addBeforeANode(Node v) {
    }

    public static void removeBeforeANode(Node v) {
    }


}
