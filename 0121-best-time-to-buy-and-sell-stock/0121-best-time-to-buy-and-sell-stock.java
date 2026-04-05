class Solution {
    public int maxProfit(int[] prices) {
        int minp=prices[0];
        int maxp=0;

        for(int i:prices){
            int profit=i-minp;
            minp=Math.min(minp,i);
            maxp=Math.max(maxp,profit);
        }
        return maxp;
    }
}