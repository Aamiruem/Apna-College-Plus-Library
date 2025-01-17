#include <iostream>
using namespace std;

// Definition of a ListNode
struct ListNode
{
    int val;        // Value of the node
    ListNode *next; // Pointer to the next node

    // Constructor
    ListNode(int x) : val(x), next(nullptr) {}
};

class LinkedListCycle
{
public:
    // Method to detect if a cycle exists in the linked list
    bool hasCycle(ListNode *head)
    {
        if (!head || !head->next)
        {
            return false; // If the list is empty or has only one node, no cycle is possible
        }

        ListNode *slow = head; // Initialize the slow pointer
        ListNode *fast = head; // Initialize the fast pointer

        while (fast && fast->next)
        {
            slow = slow->next;       // Move slow pointer one step
            fast = fast->next->next; // Move fast pointer two steps

            if (slow == fast)
            {
                return true; // Cycle detected
            }
        }

        return false; // No cycle found
    }
};

int main()
{
    // Create a linked list with a cycle
    ListNode *head = new ListNode(3);
    ListNode *node2 = new ListNode(2);
    ListNode *node3 = new ListNode(0);
    ListNode *node4 = new ListNode(-4);

    head->next = node2;
    node2->next = node3;
    node3->next = node4;
    node4->next = node2; // Create a cycle by pointing node4 back to node2

    LinkedListCycle cycleDetector;
    cout << "Cycle detected: " << (cycleDetector.hasCycle(head) ? "true" : "false") << endl;

    // Create a linked list without a cycle
    ListNode *head2 = new ListNode(1);
    ListNode *node2b = new ListNode(2);
    head2->next = node2b;

    cout << "Cycle detected: " << (cycleDetector.hasCycle(head2) ? "true" : "false") << endl;

    // Cleanup memory
    delete head;
    delete node2;
    delete node3;
    delete node4;
    delete head2;
    delete node2b;

    return 0;
}
