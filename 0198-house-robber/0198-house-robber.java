class Solution {
    static int robb(int ind,int n,int a[],int dp[]){
        if(ind==0) return a[0];
        if(ind<0) return 0;
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick=a[ind]+robb(ind-2,n,a,dp);
        int notPick=0+robb(ind-1,n,a,dp);
        dp[ind]=Math.max(pick,notPick);

        return dp[ind];

    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return robb(n-1,n,nums,dp);

    }
}