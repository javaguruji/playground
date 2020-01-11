package linkedlist;

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

    public static void main(String[] args) {
        LinkedListCustom linkedListCustom = new LinkedListCustom();
        linkedListCustom.addElement(10);
        linkedListCustom.addElement(20);
        linkedListCustom.addElement(30);
        linkedListCustom.addElementToFront(11);
        System.out.println(linkedListCustom.findKthElementFromTheLast(2));
        linkedListCustom.print();

    }
}

