#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class MedianFinder
{
private:
    priority_queue<int> maxHeap;                             // Stores the smaller half
    priority_queue<int, vector<int>, greater<int> > minHeap; // Stores the larger half

public:
    MedianFinder() {}

    void addNum(int num)
    {
        maxHeap.push(num);           // Add to maxHeap first
        minHeap.push(maxHeap.top()); // Balance by moving the largest from maxHeap to minHeap
        maxHeap.pop();

        if (minHeap.size() > maxHeap.size())
        {
            maxHeap.push(minHeap.top()); // Ensure maxHeap has at least as many elements as minHeap
            minHeap.pop();
        }
    }

    double findMedian()
    {
        if (maxHeap.size() > minHeap.size())
        {
            return maxHeap.top(); // If maxHeap has more elements, it's the median
        }
        return (maxHeap.top() + minHeap.top()) / 2.0; // Average of the two middle values
    }
};

int main()
{
    MedianFinder obj;
    obj.addNum(1);
    obj.addNum(2);
    cout << obj.findMedian() << endl; // Output: 1.5
    obj.addNum(3);
    cout << obj.findMedian() << endl; // Output: 2.0
    return 0;
}
