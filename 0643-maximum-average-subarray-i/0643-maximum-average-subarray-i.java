class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: initial window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        int maxSum = windowSum;
        
        // Step 2: slide window
        for (int i = k; i < n; i++) {
            windowSum += nums[i];
            windowSum -= nums[i - k];
            
            maxSum = Math.max(maxSum, windowSum);
        }
        
        // Step 3: compute average
        return (double) maxSum / k;
    }
}