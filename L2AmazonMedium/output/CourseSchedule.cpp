#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool canFinish(int numCourses, vector<vector<int> > &prerequisites)
{
    // Create an adjacency list to represent the graph
    vector<vector<int> > graph(numCourses);
    // Array to track the in-degree of each course
    vector<int> inDegree(numCourses, 0);

    // Build the graph and populate in-degree array
    for (const auto &prerequisite : prerequisites)
    {
        int course = prerequisite[0];
        int pre = prerequisite[1];
        graph[pre].push_back(course);
        inDegree[course]++;
    }

    // Queue to store courses with in-degree 0 (no prerequisites)
    queue<int> q;
    for (int i = 0; i < numCourses; i++)
    {
        if (inDegree[i] == 0)
        {
            q.push(i);
        }
    }

    // Process courses in topological order
    int completedCourses = 0;
    while (!q.empty())
    {
        int current = q.front();
        q.pop();
        completedCourses++;

        // Reduce the in-degree of dependent courses
        for (int neighbor : graph[current])
        {
            inDegree[neighbor]--;
            if (inDegree[neighbor] == 0)
            {
                q.push(neighbor);
            }
        }
    }

    // If all courses are completed, return true
    return completedCourses == numCourses;
}

int main()
{
    int numCourses = 4;
    vector<vector<int> > prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

    cout << "Can finish all courses: " << (canFinish(numCourses, prerequisites) ? "true" : "false") << endl;
    return 0;
}
