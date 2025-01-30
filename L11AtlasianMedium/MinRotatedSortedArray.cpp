// #include <bits/stdc++.h>
// using namespace std;

// int main()
// {
//     vector<int> temp = {13, 4, 5, 1, 2};
//     int n = temp.size();
//     int s = 0;
//     int e = n - 1;

//     while (s <= e)
//     {
//         int mid = (s + e) / 2;
//         int prev = (mid - 1 + n) % n;
//         int next = (mid + 1) % n;

//         if (temp[mid] <= temp[next] && temp[mid] <= temp[prev])
//         {
//             cout << temp[mid] << endl;
//             break;
//         }
//         else if (temp[mid] <= temp[e])
//         {
//             e = mid - 1;
//         }
//         else if (temp[mid] >= temp[s])
//         {
//             s = mid + 1;
//         }
//     }

//     return 0;
// }




// MinRotatedSortedArray
#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> temp = {3, 4, 5, 1, 2};
    int n = temp.size();
    int s = 0;
    int e = n - 1;

    while (s <= e)
    {
        int mid = (s + e) / 2;
        int prev = (mid - 1 + n) % n;
        int next = (mid + 1) % n;

        if (temp[mid] <= temp[next] && temp[mid] <= temp[prev])
        {
            cout << temp[mid] << endl;
            break;
        }
        else if (temp[mid] <= temp[e])
        {
            e = mid - 1;
        }
        else if (temp[mid] >= temp[s])
        {
            s = mid + 1;
        }
    }

    return 0;
}
