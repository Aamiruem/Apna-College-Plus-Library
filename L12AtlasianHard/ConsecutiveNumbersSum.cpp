// #include <bits/stdc++.h>
// using namespace std;

// int main()
// {
//     int n = 9; // Example value, change as needed
//     int k = sqrt(2 * n + 0.25) - 0.5;
//     int count = 0;

//     for (int i = 1; i <= k; i++)
//     {
//         if ((n - i * (i + 1) / 2) % i == 0)
//         {
//             count++;
//         }
//     }

//     cout << count << endl;
//     return 0;
// }






#include <bits/stdc++.h>
using namespace std;

int consecutiveNumbersSum(int n)
{
    int count = 0;
    for (int k = 1; k * (k - 1) / 2 < n; k++)
    {
        if ((n - k * (k - 1) / 2) % k == 0)
        {
            count++;
        }
    }
    return count;
}

int main()
{
    int n = 9; // Example input
    cout << "Ways to express " << n << " as a sum of consecutive numbers: " << consecutiveNumbersSum(n) << endl;
    return 0;
}
