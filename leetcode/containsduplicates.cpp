// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.


// class Solution first{
// public:
//     bool containsDuplicate(vector<int>& nums) {
//         unordered_set<int> nums_set(nums.begin(), nums.end());
//         return nums_set.size() != nums.size();
//     }
// };

// class Solution2 {
// public:
//     bool containsDuplicate(vector<int>& nums) {
//         sort(nums.begin(), nums.end());
//         return unique(nums.begin(), nums.end()) != nums.end();
//     }
// };
