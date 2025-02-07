#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        vector<int> ans;
        
        // Step 1: Count the number of '1's in each row and store in `ans`
        for (int i = 0; i < bank.size(); i++) {
            int c = count(bank[i].begin(), bank[i].end(), '1');
            if (c != 0) {
                ans.push_back(c); // Only store rows with at least one '1'
            }
        }

        // Step 2: Calculate the total number of beams
        int sum = 0;
        for (size_t i = 0; i + 1 < ans.size(); i++) {
            sum += ans[i] * ans[i + 1]; // Multiply consecutive counts
        }
        
        return sum;
    }
};

int main() {
    vector<string> bank = {
        "00110",
        "10110",
        "01110",
        "11110"
    };

    Solution solution;
    int result = solution.numberOfBeams(bank);
    
    cout << "Number of beams: " << result << endl;
    
    return 0;
}
