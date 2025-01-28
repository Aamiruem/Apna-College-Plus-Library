// #include <bits/stdc++.h>
// using namespace std;

// class CustomStack
// {
// public:
//     stack<int> s1;
//     stack<int> s2;
//     int currSize;
//     int maxSize;

//     CustomStack(int maxSize)
//     {
//         currSize = 0;
//         this->maxSize = maxSize;
//     }

//     void push(int x)
//     {
//         if (currSize < maxSize)
//         {
//             s1.push(x);
//             currSize++;
//         }
//     }

//     int pop()
//     {
//         if (currSize == 0)
//         {
//             return -1;
//         }
//         int top = s1.top();
//         s1.pop();
//         currSize--;
//         return top;
//     }

//     void increment(int k, int val)
//     {
//         while (!s1.empty())
//         {
//             s2.push(s1.top());
//             s1.pop();
//         }
//         while (!s2.empty() && k--)
//         {
//             s1.push(s2.top() + val);
//             s2.pop();
//         }
//         while (!s2.empty())
//         {
//             s1.push(s2.top());
//             s2.pop();
//         }
//     }
// };

// int main()
// {
//     CustomStack cstack(3);
//     cstack.push(1);
//     cstack.push(2);
//     cstack.push(3);

//     cstack.increment(2, 100);
//     cout << cstack.pop() << " " << cstack.pop() << endl;

//     return 0;
// }









#include <bits/stdc++.h>
using namespace std;

class CustomStack
{
public:
    stack<int> s1;
    stack<int> s2;
    int currSize;
    int maxSize;

    CustomStack(int maxSize)
    {
        currSize = 0;
        this->maxSize = maxSize;
    }

    void push(int x)
    {
        if (currSize < maxSize)
        {
            s1.push(x);
            currSize++;
        }
    }

    int pop()
    {
        if (currSize == 0)
        {
            return -1;
        }
        int top = s1.top();
        s1.pop();
        currSize--;
        return top;
    }
    void increment(int k, int val)
    {
        while (s1.size())
        {
            s2.push(s1.top());
            s1.pop();
        }
        while (s2.size() and k--)
        {
            s1.push(s2.top() + val);
            s2.pop();
        }
        while (s2.size())
        {
            s1.push(s2.top());
            s2.pop();
        }
    }
};
int main()
{
    CustomStack cstack(3);
    cstack.push(1);
    cstack.push(2);
    cstack.push(3);

    cstack.increment(2, 100);
    cout << cstack.pop() << " " << cstack.pop() << endl;
};
