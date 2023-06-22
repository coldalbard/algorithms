package algorithms.homework.homework3;

import java.util.ArrayList;

public class hw3 {
    static Node head;
    static Node tail;

    static class Node {
        int value;
        Node next;
        Node previos;
    }

    public void revert(){
        Node node = head;
        Node temp = head;
        head = tail;
        tail = temp;
        
        while(node.next != null){
            temp = node.next;
            node.next = node.previos;
            node.previos = temp;
            node = node.previos;
        }
    }
}
