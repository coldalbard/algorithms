package algorithms.seminar.seminar3;

public class ListNode {
    static Node head;
    static Node tail;

    static class Node {
        int value;
        Node next;
        Node prev;
    }

    public static void pushFront(int value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public static void popFront() {
        if (head != null && head.next != null) {
            head = head.next;
        } else {
            tail = null;
            head = null;
        }
    }

    public static void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static boolean find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if (tail == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;

    }

    public static void popBack() {
        if (tail != null && tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            tail = null;
            head = null;
        }
    }

    public static void sort() {
        boolean needSort = true;
        do {
            needSort = false;
            if (head != null) {
                Node node = head;
                while (node != null && node.next != null) {
                    if (node.value > node.next.value) {
                        Node before = node.prev;
                        Node cur = node;
                        Node next = node.next;
                        Node after = next.next;

                        cur.next = after;
                        cur.prev = next;
                        next.next = cur;
                        next.prev = before;

                        if (after != null) {
                            after.prev = cur;
                        } else {
                            tail = cur;
                        }

                        if (before != null) {
                            before.next = next;
                        } else {
                            head = next;
                        }

                        needSort = true;
                    }
                    node = node.next;
                }
            }
        } while (needSort);
    }

}
