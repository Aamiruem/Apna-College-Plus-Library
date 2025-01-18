#include <iostream>
using namespace std;

// Node class for the linked list
class Node
{
public:
    int data;
    Node *next;

    Node(int value)
    {
        data = value;
        next = nullptr;
    }
};

// LinkedList class
class LinkedList
{
private:
    Node *head;

public:
    LinkedList() : head(nullptr) {}

    // Add a new node to the end of the linked list
    void add(int value)
    {
        Node *newNode = new Node(value);
        if (head == nullptr)
        {
            head = newNode;
        }
        else
        {
            Node *current = head;
            while (current->next != nullptr)
            {
                current = current->next;
            }
            current->next = newNode;
        }
    }

    // Print the linked list
    void printList()
    {
        Node *current = head;
        while (current != nullptr)
        {
            cout << current->data << " -> ";
            current = current->next;
        }
        cout << "null" << endl;
    }

    // Reverse the linked list iteratively
    void reverseIterative()
    {
        Node *previous = nullptr;
        Node *current = head;
        Node *next = nullptr;

        while (current != nullptr)
        {
            next = current->next;     // Store the next node
            current->next = previous; // Reverse the current node's pointer
            previous = current;       // Move previous to the current node
            current = next;           // Move to the next node
        }

        head = previous; // Update the head to the new first node
    }
};

// Main function to test the program
int main()
{
    LinkedList list;
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    cout << "Original List:" << endl;
    list.printList();

    cout << "\nReversed List (Iterative):" << endl;
    list.reverseIterative();
    list.printList();

    return 0;
}
