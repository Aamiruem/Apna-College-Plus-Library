#include <iostream>
using namespace std;

bool reachingPoints(int sx, int sy, int tx, int ty)
{
    // Work backwards from (tx, ty) to (sx, sy)
    while (tx >= sx && ty >= sy)
    {
        if (tx == sx && ty == sy)
        {
            return true; // Reached the starting point
        }
        if (tx > ty)
        {
            // If tx is larger, subtract multiples of ty from tx
            if (ty == sy)
            {
                // If ty is already equal to sy, check if (tx - sx) is divisible by ty
                return (tx - sx) % ty == 0;
            }
            tx %= ty; // Reduce tx by ty
        }
        else
        {
            // If ty is larger, subtract multiples of tx from ty
            if (tx == sx)
            {
                // If tx is already equal to sx, check if (ty - sy) is divisible by tx
                return (ty - sy) % tx == 0;
            }
            ty %= tx; // Reduce ty by tx
        }
    }
    return false; // Cannot reach (sx, sy)
}

int main()
{
    cout << reachingPoints(1, 1, 3, 5) << endl; // Output: 1 (true)
    cout << reachingPoints(1, 1, 2, 2) << endl; // Output: 0 (false)
    return 0;
}
