// int helper(int i,int j, vector<int>& nums)
// {
//     if(i==j) return nums[i];
//     int left_cross=INT_MIN, right_cross=INT_MIN;
//     int mid= (i+j)/2;
//     int cur=0;
//     for(int k=mid+1;k<=j;k++)
//     {
//         cur+= nums[k];
//         right_cross= max(right_cross,cur);
//     }
//     cur=0;
//     for(int k=mid;k>=i;k--)
//     {
//         cur+= nums[k];
//         left_cross= max(left_cross,cur);
//     }
//     int cross_sum = left_cross + right_cross;
//     int left_sum  = helper(i,mid,nums);
//     int right_sum = helper(mid+1,j,nums);
//     return max( cross_sum , max(left_sum , right_sum) );
// }
// int maxSubArray(vector<int>& nums) {
//     return helper(0,nums.size()-1,nums);
// }

