#include <bits/stdc++.h>

// #include<stdio.h>
// #include<iostream>
// #include<vector>
// #include<unordered_map>
// #include<algorithm>
// #include<queue>
using namespace std;

int main(){
    vector<int> nums = {2, 1, 2, 1, 4};
    // unordered_map<int, int> count;
    int n = 5;
    int ans = 0;
    for(int i = 0; i < n; i++){
      ans = ans^nums[i];
    }
    cout << ans << endl;

}
