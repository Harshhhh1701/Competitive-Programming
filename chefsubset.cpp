// Chef and Subset Additions Problem Code: SUBSTADDSolvedSubmit (Practice)
// Chef is asked to write a program that takes an array A of length N and two integers X,Y as input and modifies it as follows:

// Choose a random subset of elements of A (possibly empty)
// Increase all the elements of the chosen subset by X
// Increase the remaining elements in A by Y
// You are given N, X, Y, A and the array B that is returned by Chef's program. Determine whether Chef's program gave the correct output.

#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--){
	    int n,a,b;
	    cin>>n>>a>>b;
	    int m[n],p[n];
	    for(int i=0;i<n;i++){
	        cin>>m[i];
	    }
	    for(int i=0;i<n;i++){
	        cin>>p[i];
	    }
	    int count=0;
	    for(int i=0;i<n;i++){
	        int j=m[i]+a;
	        int k=m[i]+b;
	        if(p[i]==j ){
	            count++;
	        }
	        else if( p[i]==k){
	            count++;
	        }
	    }
	    if(count>=n){
	        cout<<"yes"<<endl;
	    }
	    else{
	        cout<<"no"<<endl;
	    }
	}
	return 0;
}
