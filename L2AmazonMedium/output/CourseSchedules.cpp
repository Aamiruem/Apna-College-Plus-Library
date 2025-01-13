#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool canFinish(int n, vector<vector<int> > &prerequisites)
{
    // Create an adjacency list to represent the graph
    vector<vector<int> > adj(n);

    // Array to track the in-degree of each course
    vector<int> indegree(n, 0);

    // Build the graph and populate in-degree array
    for (const auto &x : prerequisites)
    {
        adj[x[1]].push_back(x[0]);
        indegree[x[0]]++;
    }

    // Queue to store courses with in-degree 0 (no prerequisites)
    queue<int> q;
    for (int i = 0; i < n; i++)
    {
        if (indegree[i] == 0)
        {
            q.push(i);
        }
    }

    // Process courses in topological order
    int count = 0;
    while (!q.empty())
    {
        int c = q.front();
        q.pop();
        count++;

        // Reduce the in-degree of dependent courses
        for (int j : adj[c])
        {
            if (--indegree[j] == 0)
            {
                q.push(j);
            }
        }
    }

    // If all courses are processed, return true
    return count == n;
}

int main()
{
    int n = 4;
    vector<vector<int> > prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

    cout << "Can finish all courses: " << (canFinish(n, prerequisites) ? "true" : "false") << endl;

    return 0;
}
