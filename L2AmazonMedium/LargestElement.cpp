#include <iostream>
#include <vector>
using namespace std;

// Function to find the largest number in the array
int findLargest(const vector<int> &numbers)
{
    int largest = numbers[0];
    for (int num : numbers)
    {
        if (num > largest)
        {
            largest = num;
        }
    }
    return largest;
}

int main()
{
    int n;

    // Input the size of the array
    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> numbers(n);

    // Input the array elements
    cout << "Enter " << n << " numbers:" << endl;
    for (int i = 0; i < n; i++)
    {
        cin >> numbers[i];
    }

    // Find and display the largest number
    int largest = findLargest(numbers);
    cout << "The largest number is: " << largest << endl;

    return 0;
}
