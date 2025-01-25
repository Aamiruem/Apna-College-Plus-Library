#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int val) : val(val), next(nullptr) {}
};

class SortList
{
public:
    ListNode *sortList(ListNode *head)
    {
        if (head == nullptr || head->next == nullptr)
        {
            return head;
        }
        ListNode *mid = middleNode(head);
        ListNode *left = sortList(head);
        ListNode *right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        ListNode dummy;
        ListNode *head = &dummy;
        while (list1 != nullptr && list2 != nullptr)
        {
            if (list1->val < list2->val)
            {
                head->next = list1;
                list1 = list1->next;
            }
            else
            {
                head->next = list2;
                list2 = list2->next;
            }
            head = head->next;
        }
        head->next = (list1 != nullptr) ? list1 : list2;
        return dummy.next;
    }

    // Get middle element and divide list in two parts
    ListNode *middleNode(ListNode *head)
    {
        ListNode *midPrev = nullptr;
        while (head != nullptr && head->next != nullptr)
        {
            midPrev = (midPrev == nullptr) ? head : midPrev->next;
            head = head->next->next;
        }
        ListNode *mid = midPrev->next;
        midPrev->next = nullptr;
        return mid;
    }

    void printList(ListNode *head)
    {
        while (head != nullptr)
        {
            std::cout << head->val << " -> ";
            head = head->next;
        }
        std::cout << "null" << std::endl;
    }
};

int main()
{
    SortList sl;
    ListNode *head = new ListNode(4);
    head->next = new ListNode(2);
    head->next->next = new ListNode(1);
    head->next->next->next = new ListNode(3);
    ListNode *sorted = sl.sortList(head);
    sl.printList(sorted);

    // Test case 1
    ListNode *head1 = new ListNode(4);
    head1->next = new ListNode(2);
    head1->next->next = new ListNode(1);
    head1->next->next->next = new ListNode(3);
    std::cout << "Original List" << std::endl;
    sl.printList(head1);
    std::cout << "Sorted List" << std::endl;
    ListNode *sorted1 = sl.sortList(head1);
    sl.printList(sorted1);

    // Test case 2
    ListNode *head2 = new ListNode(5);
    head2->next = new ListNode(3);
    head2->next->next = new ListNode(2);
    head2->next->next->next = new ListNode(1);
    std::cout << "Original List" << std::endl;
    sl.printList(head2);
    std::cout << "Sorted List" << std::endl;
    ListNode *sorted2 = sl.sortList(head2);
    sl.printList(sorted2);

    // Test case 3
    ListNode *head3 = new ListNode(1);
    std::cout << "Original List" << std::endl;
    sl.printList(head3);
    std::cout << "Sorted List" << std::endl;
    ListNode *sorted3 = sl.sortList(head3);
    sl.printList(sorted3);

    return 0;
}
