
class ListNode {

    @SuppressWarnings("unused")
    int val; // Value of the node
    ListNode next; // Pointer to the next node

    // Constructor
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode() {
    }
}

public class LinkedListCycle {

    // Method to detect if a cycle exists in the linked list
     boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // If the list is empty or has only one node, no cycle is possible
        }

        ListNode slow = head; // Initialize the slow pointer
        ListNode fast = head; // Initialize the fast pointer

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle found
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Create a cycle by pointing node4 back to node2

        LinkedListCycle cycleDetector = new LinkedListCycle();
        System.out.println("Cycle detected: " + cycleDetector.hasCycle(head)); // Output: true

        // Create a linked list without a cycle
        ListNode head2 = new ListNode(1);
        ListNode node2b = new ListNode(2);
        head2.next = node2b;

        System.out.println("Cycle detected: " + cycleDetector.hasCycle(head2)); // Output: false
    }
}
