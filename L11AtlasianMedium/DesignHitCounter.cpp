#include <bits/stdc++.h>
using namespace std;

class HitCounter
{
public:
    deque<pair<int, int> > dq;
    int total;

    HitCounter()
    {
        total = 0;
    }

    // Record a hit at the given timestamp
    void hit(int timestamp)
    {
        if (dq.empty() || dq.back().first != timestamp)
        {
            dq.push_back({timestamp, 1});
        }
        else
        {
            dq.back().second++;
        }
        total++;
    }

    // Return the number of hits in the past 300 seconds
    int getHits(int timestamp)
    {
        while (!dq.empty())
        {
            int first = dq.front().first;
            if (timestamp - first >= 300)
            { // Remove hits older than 300 seconds
                total -= dq.front().second;
                dq.pop_front();
            }
            else
            {
                break;
            }
        }
        return total;
    }
};

int main()
{
    HitCounter recordHit;
    recordHit.hit(1);
    recordHit.hit(2);
    recordHit.hit(3);
    recordHit.hit(4);
    cout << recordHit.getHits(300) << " " << recordHit.getHits(301) << endl;
    return 0;
}
