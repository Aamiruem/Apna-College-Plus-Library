#include <bits/stdc++.h>

#include <iostream>
#include <vector>

#include <unordered_set>
using namespace std;

int minAreaRect(vector<vector<int> > &points)
{
    unordered_set<string> pointSet;
    for (auto &p : points)
    {
        pointSet.insert(to_string(p[0]) + "," + to_string(p[1]));
    }

    int minArea = INT_MAX;
    int n = points.size();

    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            int x1 = points[i][0], y1 = points[i][1];
            int x2 = points[j][0], y2 = points[j][1];

            if (x1 != x2 && y1 != y2)
            { // Ensure they form a diagonal
                if (pointSet.count(to_string(x1) + "," + to_string(y2)) &&
                    pointSet.count(to_string(x2) + "," + to_string(y1)))
                {

                    int area = abs(x1 - x2) * abs(y1 - y2);
                    minArea = min(minArea, area);
                }
            }
        }
    }

    return (minArea == INT_MAX) ? 0 : minArea;
}

int main()
{
    vector<vector<int> > points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
    cout << "Minimum Area: " << minAreaRect(points) << endl;
    return 0;
}
