package linkedlist;

import java.util.Stack;

/**
 * @author badrikant.soni
 * <p>
 * Time Complexity
 * Add() - O(n)
 */
public class LinkedListCustom {

    private Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // add new element at the last
    private void addElement(int data) {
        Node newNode = new Node(data);

        // base condition
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;

        // traverse the list until get null
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        // add to last
        currentNode.next = newNode;
    }

    // add element to top
    private void addElementToFront(int data) {
        Node newNode = new Node(data);

        // base condition
        if (head == null) {
            head = newNode;
            return;
        }

        // add head to newNode.next
        newNode.next = head;

        // assign newNode to head
        head = newNode;
    }

    // From the last, find Kth element
    private int findKthElementFromTheLast(int k) {
        Node fastPointer = head;
        Node slowPointer = head;
        for (int i = 0; i < k; i++) {
            fastPointer = fastPointer.next;
        }
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.data;
    }

    private void deleteLastElement() {

        // take two pointers, make previous to last node as null
        Node currentNode = head;
        Node previousNode = head;
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = null;
    }

    private void deleteFirstElement() {
        Node currentNode = head;
        Node nextNode = currentNode.next;
        currentNode.next = null;
        head = nextNode;
    }

    private void print() {
        Node currentNode = head;
        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.data + ",");
            currentNode = currentNode.next;
        }
        System.out.print("]");
    }

    private Node reverse(){
        Node node = reverseLinkedList(head);
        return node;
    }

    private void printReverse(Node head) {
        Node currentNode = head;
        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.data + ",");
            currentNode = currentNode.next;
        }
        System.out.print("]");
    }

    private Node reverseLinkedList(Node head){

        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private void reverseLinkedIterative(){

        Node currentNode = head;
        if(currentNode == null){
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        while(currentNode!= null){
            stack.push(currentNode.data);
            currentNode = currentNode.next;
        }

        head = null;
        while (!stack.isEmpty()){
            addElement(stack.pop());
        }
    }

    public static void main(String[] args) {
        LinkedListCustom linkedListCustom = new LinkedListCustom();
        linkedListCustom.addElement(10);
        linkedListCustom.addElement(20);
        linkedListCustom.addElement(30);
        linkedListCustom.addElement(40);
        linkedListCustom.addElement(50);
        linkedListCustom.print();
        //System.out.println(linkedListCustom.findKthElementFromTheLast(2));
        //Node reverse = linkedListCustom.reverse();
        //System.out.println();
        //linkedListCustom.printReverse(reverse);

        linkedListCustom.reverseLinkedIterative();
        linkedListCustom.print();

    }
}

