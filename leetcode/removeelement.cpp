class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n=nums.size();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == val){
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
        
    }
};