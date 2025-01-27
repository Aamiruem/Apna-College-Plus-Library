// #include <bits/stdc++.h>
// using namespace std;

// // Function to calculate the sum of an array
// int sum(int n)
// {
//     return n * (n + 1) / 2;
// }

// int main()
// {
//     int n = 5;
//     cout << sum(n) << endl;
//     return 0;
// }




#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n = 5;
    int ans = (int)(sqrt(2 * n + 0.25) - 0.5);// Calculate the square root of 2n + 0.25 and subtract 0.5

    cout << ans << endl;
  
}
