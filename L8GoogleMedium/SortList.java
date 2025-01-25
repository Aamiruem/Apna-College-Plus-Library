
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        } else {
            head.next = list2;
        }
        return dummy.next;
    }

    // Get middle element and divide list in two parts
    ListNode middleNode(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode sorted = sl.sortList(head);
        printList(sorted);

        // Test case 1
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        System.out.println("Original List");
        printList(head1);
        System.out.println("Sorted List");
        ListNode sorted1 = sl.sortList(head1);
        printList(sorted1);

        // Test case 2
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);
        System.out.println("Original List");
        printList(head2);
        System.out.println("Sorted List");
        ListNode sorted2 = sl.sortList(head2);
        printList(sorted2);

        // Test case 3
        ListNode head3 = new ListNode(1);
        System.out.println("Original List");
        printList(head3);
        System.out.println("Sorted List");
        ListNode sorted3 = sl.sortList(head3);
        printList(sorted3);
    }
}
