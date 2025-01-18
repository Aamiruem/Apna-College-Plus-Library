// ReverseLinkedList.java
public class ReverseLinkedList {

    // Node class for the linked list
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    private Node head;

    // Add a new node to the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Reverse the linked list iteratively
    public void reverseIterative() {
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;  // Store the next node
            current.next = previous;  // Reverse the current node's pointer
            previous = current;  // Move previous to the current node
            current = next;  // Move to the next node
        }

        head = previous;  // Update the head to the new first node
    }

    // Reverse the linked list recursively
    public void reverseRecursive() {
        head = reverseRecursiveHelper(head);
    }

    private Node reverseRecursiveHelper(Node current) {
        if (current == null || current.next == null) {
            return current;  // Base case: end of the list
        }

        Node newHead = reverseRecursiveHelper(current.next);  // Reverse the rest of the list
        current.next.next = current;  // Make the next node point to the current node
        current.next = null;  // Break the original link

        return newHead;
    }

    // Main method to test the program
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original List:");
        list.printList();

        System.out.println("\nReversed List (Iterative):");
        list.reverseIterative();
        list.printList();

        System.out.println("\nReversed List (Recursive):");
        list.reverseRecursive();
        list.printList();
    }
}
