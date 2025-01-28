#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int value;
    unordered_map<string, Node *> next;

    Node(int value)
    {
        this->value = value;
    }
};

class FileSystem
{
    Node *root;

public:
    FileSystem()
    {
        root = new Node(0);
    }

    bool createPath(string path, int value)
    {
        Node *cur = root;
        path.push_back('/'); // Append '/' to handle the last segment
        int pos = 1;

        while (pos < path.size())
        {
            int end = path.find_first_of('/', pos);
            string name = path.substr(pos, end - pos);

            if (end + 1 == path.size())
            { // Last segment
                if (cur->next.count(name))
                {
                    return false; // Path already exists
                }
                cur->next[name] = new Node(value);
                return true;
            }

            if (!cur->next.count(name))
            {
                return false; // Parent path does not exist
            }

            cur = cur->next[name];
            pos = end + 1;
        }

        return true;
    }

    int get(string path)
    {
        Node *cur = root;
        int pos = 1;
        path.push_back('/'); // Append '/' to handle the last segment

        while (pos < path.size())
        {
            int end = path.find_first_of('/', pos);
            string name = path.substr(pos, end - pos);

            if (!cur->next.count(name))
            {
                return -1; // Path does not exist
            }

            cur = cur->next[name];
            pos = end + 1;
        }

        return cur->value;
    }
};


int main()
{
    FileSystem obj;
    cout << obj.createPath("/leet", 1) << endl;      // Output: 1 (true)
    cout << obj.createPath("/leet/code", 2) << endl; // Output: 1 (true)
    cout << obj.get("/leet") << endl;                // Output: 1
    // cout << obj.get("/leet/code") << endl;           // Output: 2
    // cout << obj.createPath("/leet/code", 3) << endl; // Output: 0 (false)
    // cout << obj.get("/leet/code") << endl;           // Output: 2
    return 0;
}
