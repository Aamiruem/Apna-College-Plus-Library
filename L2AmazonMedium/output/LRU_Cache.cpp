#include <iostream>
#include <unordered_map>
using namespace std;

class LRUCache
{
    struct Node
    {
        int key, value;
        Node *prev;
        Node *next;
        Node(int k, int v) : key(k), value(v), prev(nullptr), next(nullptr) {}
    };

    int capacity;
    unordered_map<int, Node *> cache;
    Node *head;
    Node *tail;

    void remove(Node *node)
    {
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }

    void insert(Node *node)
    {
        node->next = head->next;
        node->prev = head;
        head->next->prev = node;
        head->next = node;
    }

public:
    LRUCache(int _capacity) : capacity(_capacity)
    {
        head = new Node(0, 0); // Dummy head
        tail = new Node(0, 0); // Dummy tail
        head->next = tail;
        tail->prev = head;
    }

    int get(int key)
    {
        if (cache.find(key) != cache.end())
        {
            Node *node = cache[key];
            remove(node);
            insert(node);
            return node->value;
        }
        return -1;
    }

    void put(int key, int value)
    {
        if (cache.find(key) != cache.end())
        {
            remove(cache[key]);
        }
        if (cache.size() == capacity)
        {
            cache.erase(tail->prev->key);
            remove(tail->prev);
        }
        Node *node = new Node(key, value);
        cache[key] = node;
        insert(node);
    }

    ~LRUCache()
    {
        Node *current = head;
        while (current != nullptr)
        {
            Node *next = current->next;
            delete current;
            current = next;
        }
    }
};

int main()
{
    LRUCache obj(2);
    obj.put(1, 1);
    obj.put(2, 2);
    cout << obj.get(1) << endl; // Output: 1
    obj.put(3, 3);
    cout << obj.get(2) << endl; // Output: -1
    obj.put(4, 4);
    cout << obj.get(1) << endl; // Output: -1
    cout << obj.get(3) << endl; // Output: 3
    cout << obj.get(4) << endl; // Output: 4
    return 0;
}
