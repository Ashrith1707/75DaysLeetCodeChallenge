class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];

        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<n  ){
            while(!st.empty() && nums[st.peek()]<nums[i]){
                res[st.peek()]=i-st.pop();
            }
            st.push(i);
            i++;
        }
    return res;
    }
}