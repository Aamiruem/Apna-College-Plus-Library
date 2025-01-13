#include <bits/stdc++.h>
using namespace std;

int minimumSwaps(string s)
{
    int count0 = 0, count1 = 0; // Counters for '0' and '1'
    int miss0 = 0, miss1 = 0;   // Mismatches for alternating patterns

    // Count the number of '0's and '1's in the string
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] == '0')
        {
            count0++;
        }
        else
        {
            count1++;
        }
    }

    // If the difference between counts of '0' and '1' is greater than 1, return -1
    if (abs(count0 - count1) > 1)
    {
        return -1;
    }

    // Check mismatches for alternating patterns
    for (int i = 0; i < s.length(); i++)
    {
        if (i % 2 == 0)
        { // Even index
            if (s[i] != '0')
            {
                miss0++;
            }
        }
        else
        { // Odd index
            if (s[i] != '1')
            {
                miss1++;
            }
        }
    }

    // If counts of '0' and '1' are equal, return the minimum mismatches
    if (count0 == count1)
    {
        return min(miss0, miss1);
    }

    // If counts differ, choose the pattern that matches the dominant character
    return count0 > count1 ? miss0 : miss1;
}

int main()
{
    string s = "00110"; // Example input string
    cout << "Minimum number of swaps required: " << minimumSwaps(s) << endl;
    return 0;
}
