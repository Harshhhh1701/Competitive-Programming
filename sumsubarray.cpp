//Subarray with given sum
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to find a continuous sub-array which adds up to a given number.
    vector<int> subarraySum(int arr[], int n, long long s)
    {
        // Your code here
       int ptr=0;
       int j=1;
       long long sum=arr[0];
       while(j<=n)
       {
           if(sum==s)
           {
               break;
           }
           else if(sum<s)
           {
               sum=sum+arr[j++];
           }
           if(sum>s)
           {
               sum=sum-arr[ptr];
               ptr=ptr+1;
           }   
       }
       if(sum!=s)
       {
           return {-1};
       }
       
       return {ptr+1,j};
   }
    
};

// { Driver Code Starts.

int main()
 {
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        long long s;
        cin>>n>>s;
        int arr[n];
        const int mx = 1e9;
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        vector<int>res;
        res = ob.subarraySum(arr, n, s);
        
        for(int i = 0;i<res.size();i++)
            cout<<res[i]<<" ";
        cout<<endl;
        
    }
	return 0;
}  // } Driver Code Ends