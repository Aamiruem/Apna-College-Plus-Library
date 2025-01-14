#include <iostream>
#include <vector>
using namespace std;

vector<int> goodDaysToRobBank(vector<int> &security, int time)
{
    int size = security.size();
    vector<int> left(size, 0);  // Prefix for non-increasing sequence
    vector<int> right(size, 0); // Prefix for non-decreasing sequence

    // Compute the `left` array
    for (int i = 1; i < size; i++)
    {
        if (security[i] <= security[i - 1])
        {
            left[i] = left[i - 1] + 1;
        }
    }

    // Compute the `right` array
    for (int i = size - 2; i >= 0; i--)
    {
        if (security[i] <= security[i + 1])
        {
            right[i] = right[i + 1] + 1;
        }
    }

    // Find all good days to rob the bank
    vector<int> goodDays;
    for (int i = time; i < size - time; i++)
    {
        if (left[i] >= time && right[i] >= time)
        {
            goodDays.push_back(i);
        }
    }

    return goodDays;
}

int main()
{
    vector<int> security = {5, 3, 3, 3, 5, 6, 2};
    int time = 2;
    vector<int> goodDays = goodDaysToRobBank(security, time);

    cout << "Good days to rob the bank: ";
    for (int day : goodDays)
    {
        cout << day << " ";
    }
    cout << endl;

    return 0;
}
