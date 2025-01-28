#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<vector<int> > edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
    int thold = 4;
    int n = 4;
    vector<vector<int> > dis(n, vector<int>(n, INT_MAX));

    for (auto it : edges)
    {
        dis[it[0]][it[1]] = it[2];
        dis[it[1]][it[0]] = it[2]; // Assuming the graph is undirected
    }

    for (int i = 0; i < n; i++)
        dis[i][i] = 0;

    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (dis[i][k] != INT_MAX && dis[k][j] != INT_MAX)
                    dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j]);

    int cityNo = -1;
    int noCity = n;
    for (int i = 0; i < n; i++)
    {
        int temp = 0;
        for (int adj = 0; adj < n; adj++)
        {
            if (dis[i][adj] <= thold)
            {
                temp++;
            }
        }
        if (temp <= noCity)
        {
            cityNo = i;
            noCity = temp;
        }
    }

    cout << cityNo << endl;

    return 0;
}
