// #include <iostream>
// using namespace std;

// double maxPieceArea(double length, double width)
// {
//     // Calculate the maximum area of a piece after horizontal and vertical cuts
//     return (length * width) / 4.0;
// }

// int main()
// {
//     double length = 10.0; // Length of the cake
//     double width = 5.0;   // Width of the cake

//     double maxArea = maxPieceArea(length, width);
//     cout << "Maximum area of a piece of cake: " << maxArea << endl;

//     return 0;
// }





#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

class Solution
{
public:
    int maxArea(int h, int w, vector<int> &hc, vector<int> &vc)
    {
        // Sort the horizontal and vertical cuts
        sort(hc.begin(), hc.end());
        sort(vc.begin(), vc.end());

        // Calculate the largest vertical gap
        vector<int> vd;
        vd.push_back(vc[0]); // Gap from the left side to the first vertical cut
        for (int i = 0; i < vc.size() - 1; i++)
        {
            vd.push_back(vc[i + 1] - vc[i]);
        }
        vd.push_back(w - vc[vc.size() - 1]); // Gap from the last vertical cut to the right side

        // Calculate the largest horizontal gap
        vector<int> hd;
        hd.push_back(hc[0]); // Gap from the bottom side to the first horizontal cut
        for (int i = 0; i < hc.size() - 1; i++)
        {
            hd.push_back(hc[i + 1] - hc[i]);
        }
        hd.push_back(h - hc[hc.size() - 1]); // Gap from the last horizontal cut to the top side

        // Find the maximum gap in both directions
        int max_vd = *max_element(vd.begin(), vd.end());
        int max_hd = *max_element(hd.begin(), hd.end());

        // Calculate the maximum area (max vertical gap * max horizontal gap)
        long long mod = 1e9 + 7;
        long long maxArea = (1LL * max_vd * max_hd) % mod;

        return (int)maxArea;
    }
};

int main()
{
    Solution solution;
    int h = 4;               // Height of the cake
    int w = 5;               // Width of the cake
    vector<int> hc = {1, 2}; // Horizontal cuts at y = 1 and y = 2
    vector<int> vc = {1, 3}; // Vertical cuts at x = 1 and x = 3

    int maxArea = solution.maxArea(h, w, hc, vc);
    cout << "Maximum Area: " << maxArea << endl;

    return 0;
}











#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

class Solution
{
public:
    int maxArea(int h, int w, vector<int> &hc, vector<int> &vc)
    {
        sort(hc.begin(), hc.end());
        sort(vc.begin(), vc.end());

        vector<int> vd;
        vector<int> hd;
        vd.push_back(0);
        hd.push_back(0);

        for (int i = 0; i < vc.size() - 1; i++)
        {
            vd.push_back(vc[i + 1] - vc[i]);
        }
        for (int i = 0; i < hc.size() - 1; i++)
        {
            hd.push_back(hc[i + 1] - hc[i]);
        }

        vd.push_back(w - vc[vc.size() - 1]);
        hd.push_back(h - hc[hc.size() - 1]);

        int m = pow(10, 9) + 7;
        long long l = *max_element(vd.begin(), vd.end());
        long long b = *max_element(hd.begin(), hd.end());
        int ans = (l * b) % m;

        return ans;
    }
};

int main()
{
    Solution solution;
    int h = 4;               // Height of the cake
    int w = 5;               // Width of the cake
    vector<int> hc = {1, 2}; // Horizontal cuts at y = 1 and y = 2
    vector<int> vc = {1, 3}; // Vertical cuts at x = 1 and x = 3

    int maxArea = solution.maxArea(h, w, hc, vc);
    cout << "Maximum Area: " << maxArea << endl;

    return 0;
}
