#include <bits/stdc++.h>
using namespace std;
#define ll long long

int doit(int n , int m , int  k , vector<int> &a,vector<int>&b){
	
	set<int> s;
	for(auto i:b) s.insert(i);
	map<int,int> dp;
	int i = 0 ;
	int  j = 0;
	int c = 0 ;
	int l = -1, r = n;
	while(j<n){
		dp[a[j]]++;
		if(dp[a[j]]==1 && s.count(a[j])) c++;
		while(c>k){
			dp[a[i]]--;
			if(s.count(a[i]) && !dp[a[i]]) c--;
			i++;
		}
		while(c==k){
			dp[a[i]]--;
			if(!s.count(a[i]) || dp[a[i]]){
				i++;
			}
			else{
				if(r-l > j-i){
					l = i;
					r = j;
				}
				c--;
				i++;
			}
		}
		j++;
	}
	if(l==-1) return -1;
	return r-l+1;
}

int main(){
	int n,m,k;
	cin >> n >> m >>k;
	vector<int> a(n),b(m);
	for(auto &i:a) cin >> i;
	for(auto &i:b) cin >> i;
	cout << doit(n,m,k,a,b);
	return 0;
}