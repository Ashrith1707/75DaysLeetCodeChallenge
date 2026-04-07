class Solution {
    int ans;

    int solve(int ind, int[] nums) {
        if (ind == 0) {
            ans = nums[0];
            return nums[0];
        }

        int prev = solve(ind - 1, nums);
        int curr = Math.max(nums[ind], nums[ind] + prev);

        ans = Math.max(ans, curr);
        return curr;
    }

    public int maxSubArray(int[] nums) {
        ans = nums[0];
        solve(nums.length - 1, nums);
        return ans;
    }
}