class Solution {
    static int fibb(int n,int dp[]) {
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]= fibb(n-1,dp)+fibb(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
    int dp[]=new int[n+1];
    Arrays.fill(dp,-1);


    int k=fibb(n,dp);
    return k;
    }
}