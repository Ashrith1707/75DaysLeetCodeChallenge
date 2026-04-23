class Solution {
    static int fibb(int n) {
        if(n<=1){
            return n;
        }
        return fibb(n-1)+fibb(n-2);
    }
    public int fib(int n) {
    int dp[]=new int[n];
    int k=fibb(n);
    return k;
    }
}