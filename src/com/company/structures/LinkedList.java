package com.company.structures;

/**
 * Created by fertkir on 22.01.16.
 */
public class LinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.reverse();
        list.print();
    }

    private Node head = null;

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(data);
    }

    /**
     * Develop a program which reverses the one-way linked list
     */
    public void reverse() {
        if (head == null) {
            return;
        }
        Node prev = null;
        Node cur = head;
        Node next = cur.next;
        cur.next = null;
        while (next != null) {
            prev = cur;
            cur = next;
            next = next.next;
            cur.next = prev;
        }
        head = cur;
    }

    public void print() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (node != null) {
            sb.append(node.data).append(',').append(' ');
            node = node.next;
        }
        sb.append(']');
        System.out.println(sb.toString());
    }
}
