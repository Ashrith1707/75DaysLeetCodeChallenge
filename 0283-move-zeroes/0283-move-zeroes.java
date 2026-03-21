class Solution {
    public int[] moveZeroes(int[] nums) {
        int c=-1;
        int z=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
            c++;
                nums[c]=nums[i];
            }else{
                z++;
            }
        }
        for(int i=nums.length-z;i<nums.length;i++){
            nums[i]=0;
        }
        return nums;
    }
}