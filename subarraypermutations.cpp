//codechef
#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--){
	    int n,k;
	    cin>>n>>k;
	    if(n==1){
	        cout<<"1"<<endl;
	        
	    }
	    else if(k==1){
	        cout<<"-1"<<endl;
	    }
	    else{
	        int j;
	        for(j=k;j<=n;j++){
	            cout<<j<<" ";
	        }
	        for(j=1;j<k;j++){
	            cout<<j<<" ";
	        }
	        cout<<endl;
	    }
	}
	return 0;
}
