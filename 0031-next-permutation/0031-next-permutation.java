class Solution {
        static int[] reverse(int a[],int i,int j){
            while(i<=j){
           int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            i++;
            j--;
        }
        return a;
        }
    public void nextPermutation(int[] nums) {
        int ind=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        } 
        if(ind!=-1){
        for(int i=nums.length-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
        }
        reverse(nums,ind+1,nums.length-1);
        }else{
            reverse(nums,0,nums.length-1);
        }
        }
}