//Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer. 
//Find out the minimum possible difference of the height of shortest and longest towers after you have modified each tower.
// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function template for C++

class Solution {
  public:
    int getMinDiff(int arr[], int n, int k) {
        // code 
        
       sort(arr,arr+n);
       int diff=arr[n-1]-arr[0];
       int smallest= arr[0]+k;
       int largest= arr[n-1]-k;
       int mi,ma;
       
       for(int i=0;i<n-1;i++){
           mi=min(smallest,arr[i+1]-k);
           ma=max(largest,arr[i]+k);
           if(mi<0) continue;
           diff=min(diff,ma-mi);
       }
       return diff;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> k;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getMinDiff(arr, n, k);
        cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends