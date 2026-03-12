import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int b[] = new int[2];

        for(int i = 0; i < nums.length; i++){

            int z = target - nums[i];

            if(map.containsKey(z)){
                b[0] = map.get(z);
                b[1] = i;
                return b;
            }

            map.put(nums[i], i);
        }

        return b;
    }
}