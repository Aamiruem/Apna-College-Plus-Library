#include <iostream>
#include <unordered_map>
using namespace std;

int main()
{
    // Predefined array and difference k
    int arr[] = {1, 5, 3, 4, 2}; // Example array
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 2; // Example difference value

    // Store occurrences of elements in an unordered_map (HashMap in C++)
    unordered_map<int, int> m;
    for (int i = 0; i < n; i++)
    {
        m[arr[i]]++;
    }

    int ans = 0;
    for (auto &pair : m)
    {
        int x = pair.first;
        if ((k == 0 && m[x] > 1) || (k != 0 && m.count(x + k)))
        {
            ans++;
        }
    }

    cout << "Number of unique pairs with difference " << k << ": " << ans << endl;
    return 0;
}
