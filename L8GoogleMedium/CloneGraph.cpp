// #include <iostream>
// #include <vector>
// #include <unordered_map>
// #include <queue>

// using namespace std;

// class Node
// {
// public:
//     int val;
//     vector<Node *> neighbors;

//     Node() : val(0), neighbors(vector<Node *>()) {}
//     Node(int _val) : val(_val), neighbors(vector<Node *>()) {}
//     Node(int _val, vector<Node *> _neighbors) : val(_val), neighbors(_neighbors) {}
// };

// class CloneGraph
// {
// public:
//     Node *cloneGraph(Node *node)
//     {
//         if (node == nullptr)
//             return nullptr;

//         unordered_map<int, Node *> map;
//         queue<Node *> q;
//         Node *head = new Node(node->val);
//         map[node->val] = head;
//         q.push(node);

//         while (!q.empty())
//         {
//             Node *curr = q.front();
//             q.pop();
//             Node *clonedNode = map[curr->val];

//             for (Node *neighbor : curr->neighbors)
//             {
//                 if (map.find(neighbor->val) == map.end())
//                 {
//                     Node *newNeighbor = new Node(neighbor->val);
//                     map[neighbor->val] = newNeighbor;
//                     q.push(neighbor);
//                 }
//                 clonedNode->neighbors.push_back(map[neighbor->val]);
//             }
//         }
//         return head;
//     }
// };

// int main()
// {
//     CloneGraph s;

//     // Creating the graph
//     Node *node1 = new Node(1);
//     Node *node2 = new Node(2);
//     Node *node3 = new Node(3);
//     Node *node4 = new Node(4);

//     node1->neighbors.push_back(node2);
//     node1->neighbors.push_back(node4);
//     node2->neighbors.push_back(node1);
//     node2->neighbors.push_back(node3);
//     node3->neighbors.push_back(node2);
//     node3->neighbors.push_back(node4);
//     node4->neighbors.push_back(node1);
//     node4->neighbors.push_back(node3);

//     // Cloning the graph
//     Node *cloned = s.cloneGraph(node1);

//     // Printing the cloned graph's details
//     cout << "Cloned Node Value: " << cloned->val << endl;
//     cout << "Cloned Node Neighbors:" << endl;
//     for (Node *neighbor : cloned->neighbors)
//     {
//         cout << neighbor->val << endl;
//     }

//     return 0;
// }

#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

class Node
{
public:
    int val;
    vector<Node *> neighbors;

    Node() : val(0), neighbors(vector<Node *>()) {}
    Node(int _val) : val(_val), neighbors(vector<Node *>()) {}
    Node(int _val, vector<Node *> _neighbors) : val(_val), neighbors(_neighbors) {}
};

class CloneGraph
{
public:
    Node *cloneGraph(Node *node)
    {
        if (node == nullptr)
            return nullptr;

        unordered_map<int, Node *> map;
        queue<Node *> q;
        Node *head = new Node(node->val);
        map[node->val] = head;
        q.push(node);

        while (!q.empty())
        {
            Node *curr = q.front();
            q.pop();
            Node *clonedNode = map[curr->val];

            for (Node *neighbor : curr->neighbors)
            {
                if (map.find(neighbor->val) == map.end())
                {
                    Node *newNeighbor = new Node(neighbor->val);
                    map[neighbor->val] = newNeighbor;
                    q.push(neighbor);
                }
                clonedNode->neighbors.push_back(map[neighbor->val]);
            }
        }
        return head;
    }
};

// Function to print the graph
void printGraph(Node *node, unordered_map<int, bool> &visited)
{
    if (node == nullptr || visited[node->val])
        return;

    visited[node->val] = true;
    cout << "Node " << node->val << " neighbors: ";
    for (Node *neighbor : node->neighbors)
    {
        cout << neighbor->val << " ";
    }
    cout << endl;

    for (Node *neighbor : node->neighbors)
    {
        printGraph(neighbor, visited);
    }
}

int main()
{
    CloneGraph s;

    // Creating the graph
    Node *node1 = new Node(1);
    Node *node2 = new Node(2);
    Node *node3 = new Node(3);
    Node *node4 = new Node(4);

    node1->neighbors.push_back(node2);
    node1->neighbors.push_back(node4);
    node2->neighbors.push_back(node1);
    node2->neighbors.push_back(node3);
    node3->neighbors.push_back(node2);
    node3->neighbors.push_back(node4);
    node4->neighbors.push_back(node1);
    node4->neighbors.push_back(node3);

    // Cloning the graph
    Node *cloned = s.cloneGraph(node1);

    // Printing the cloned graph's details
    unordered_map<int, bool> visited;
    cout << "Cloned Graph:" << endl;
    printGraph(cloned, visited);

    return 0;
}
