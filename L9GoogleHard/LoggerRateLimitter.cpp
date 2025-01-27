// #include <iostream>
// #include <unordered_map>
// #include <string>
// #include <vector>
// #include <algorithm>
// #include <numeric>
// #include <functional>

// // Function to compare Pair objects based on the first element
// using namespace std;

// class Pair
// {
// public:
//     string x;
//     int y;

//     Pair(int y, string x)
//     {
//         this->x = x;
//         this->y = y;
//     }

//     int getFirst()
//     {
//         return y;
//     }

//     string getSecond()
//     {
//         return x;
//     }
// };

// int main()
// {
//     vector<Pair> logs = {
//         Pair(1, "foo"),
//         Pair(2, "bar"),
//         Pair(3, "foo"),
//         Pair(8, "fba"),
//         Pair(11, "foo")};

//     unordered_map<string, int> hash;

//     for (const auto &log : logs)
//     {
//         if (hash.find(log.getSecond()) != hash.end())
//         {
//             int oldTime = hash[log.getSecond()];
//             if (log.getFirst() - oldTime >= 10)
//             {
//                 cout << "true ";
//                 hash[log.getSecond()] = log.getFirst();
//             }
//             else
//             {
//                 cout << "false ";
//             }
//         }
//         else
//         {
//             cout << "true ";
//             hash[log.getSecond()] = log.getFirst();
//         }
//     }

//     return 0;
// }

// #include <bits/stdc++.h>
// using namespace std;

// int main()
// {
//     // Array of logs represented as pairs of <int, string>
//     pair<int, string> logs[] = {
//         logs[0] = {1, "foo"},
//         logs[1] = {2, "foo"},
//         logs[2] = {3, "bar"},
//         logs[3] = {8, "foo"},
//         logs[4] = {11, "bar"},
//         logs[5] = {20, "fed"}};

//     // Unordered map to store the last occurrence time of each string
//     unordered_map<string, int> hash;

//     for (auto log : logs)
//     {
//         if (hash.find(log.second) == hash.end())
//         {
//             // If the string is not in the hash map, print "true" and add it
//             cout << "true" << endl;
//             hash[log.second] = log.first;
//         }
//         else
//         {
//             // If the string is already in the hash map
//             int oldTime = hash[log.second];
//             if (log.first - oldTime >= 10)
//             {
//                 // If the time difference is 10 or more, print "true" and update the time
//                 cout << "true" << endl;
//                 hash[log.second] = log.first;
//             }
//             else
//             {
//                 // Otherwise, print "false"
//                 cout << "false" << endl;
//             }
//         }
//     }

//     return 0;
// }










#include <bits/stdc++.h>

using namespace std;

int main()
{
    // Array of logs represented as pairs of <int, string>
    pair<int, string> logs[] = {
        logs[0] = {1, "foo"},
        logs[1] = {2, "foo"},
        logs[2] = {3, "bar"},
        logs[3] = {8, "foo"},
        logs[4] = {11, "bar"},
        logs[5] = {20, "fed"}};

    // Unordered map to store the last occurrence time of each string
    unordered_map<string, int> hash;

    // Iterate over each log entry
    for (auto log : logs)
    {
        if (hash.find(log.second) == hash.end())
        {
            // If the string is not in the hash map, print "true" and add it
            cout << "true" << endl;
            hash[log.second] = log.first;
        }
        else
        {
            // If the string is already in the hash map
            int oldTime = hash[log.second];
            if (log.first - oldTime >= 10)
            {
                // If the time difference is 10 or more, print "true" and update the time
                cout << "true" << endl;
                hash[log.second] = log.first;
            }
            else
            {
                // Otherwise, print "false"
                cout << "false" << endl;
            }
        }
    }

    return 0;
}
