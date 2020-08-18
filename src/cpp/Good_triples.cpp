class Solution {
public:
    int countGoodTriplets(vector<int>& arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    bool diffFirst = abs(arr[i] - arr[j]) <= a;
                    bool diffSecond = abs(arr[j] - arr[k]) <= b;
                    bool diffThird = abs(arr[i] - arr[k]) <= c;
                    if (diffFirst && diffSecond && diffThird) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};