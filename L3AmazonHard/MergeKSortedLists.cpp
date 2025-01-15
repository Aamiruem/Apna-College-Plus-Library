#include <iostream>
#include <vector>
using namespace std;

// Definition of a Node in the linked list
struct Node
{
    int val;
    Node *next;

    Node(int val)
    {
        this->val = val;
        this->next = nullptr;
    }
};

// Function to create a new node
Node *newNode(int key)
{
    return new Node(key);
}

// Function to print a linked list
void printList(Node *node)
{
    while (node != nullptr)
    {
        cout << node->val << " ";
        node = node->next;
    }
    cout << endl;
}

// Function to merge two sorted linked lists
Node *mergeTwoLists(Node *l1, Node *l2)
{
    if (l1 == nullptr)
        return l2;
    if (l2 == nullptr)
        return l1;

    if (l1->val < l2->val)
    {
        l1->next = mergeTwoLists(l1->next, l2);
        return l1;
    }
    else
    {
        l2->next = mergeTwoLists(l1, l2->next);
        return l2;
    }
}

// Function to merge k sorted linked lists
Node *mergeKLists(vector<Node *> &arr, int k)
{
    if (k == 0)
        return nullptr;

    while (k > 1)
    {
        int i, j;
        for (i = 0, j = 0; i < k - 1; i += 2, j++) // skipping every other list element in the list
        {
            arr[j] = mergeTwoLists(arr[i], arr[i + 1]);
        }
        if (i == k - 1)
        {
            arr[j++] = arr[i];
        }
        k = j;
    }
    return arr[0];
}

int main()
{
    int k = 3; // Number of linked lists
    vector<Node *> arr(k);

    // Creating 3 sorted linked lists
    arr[0] = newNode(1);
    arr[0]->next = newNode(3);
    arr[0]->next->next = newNode(5);

    arr[1] = newNode(0);
    arr[1]->next = newNode(2);
    arr[1]->next->next = newNode(4);

    arr[2] = newNode(1);
    arr[2]->next = newNode(3);
    arr[2]->next->next = newNode(7);

    // Merging all linked lists
    Node *result = mergeKLists(arr, k);

    // Printing the merged linked list
    printList(result);

    return 0;
}
