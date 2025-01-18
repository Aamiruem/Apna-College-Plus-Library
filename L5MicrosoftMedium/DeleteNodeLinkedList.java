
public class DeleteNodeLinkedList {

    // Node class for the linked list
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head of the linked list

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

    // Delete a node by value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the head node itself holds the value to be deleted
        if (head.data == value) {
            head = head.next; // Move head to the next node
            return;
        }

        // Search for the node to be deleted
        Node current = head;
        Node previous = null;

        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        // If the value was not found
        if (current == null) {
            System.out.println("Value not found in the list.");
            return;
        }

        // Unlink the node from the linked list
        previous.next = current.next;
    }

    // Delete a node by position (0-based index)
    public void deleteByPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the head needs to be removed
        if (position == 0) {
            head = head.next; // Move head to the next node
            return;
        }

        Node current = head;
        Node previous = null;
        int index = 0;

        // Traverse to the desired position
        while (current != null && index != position) {
            previous = current;
            current = current.next;
            index++;
        }

        // If the position is out of range
        if (current == null) {
            System.out.println("Position out of range.");
            return;
        }

        // Unlink the node from the linked list
        previous.next = current.next;
    }

    // Main method to test the program
    public static void main(String[] args) {
        DeleteNodeLinkedList list = new DeleteNodeLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original List:");
        list.printList();

        System.out.println("\nDeleting node with value 3:");
        list.deleteByValue(3);
        list.printList();

        System.out.println("\nDeleting node at position 1:");
        list.deleteByPosition(1);
        list.printList();

        System.out.println("\nDeleting node with value 10 (not in list):");
        list.deleteByValue(10);
        list.printList();

        System.out.println("\nDeleting node at position 10 (out of range):");
        list.deleteByPosition(10);
        list.printList();
    }
}
