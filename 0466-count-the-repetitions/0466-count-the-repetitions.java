import java.util.HashMap;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int i = 0, count1 = 0, count2 = 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        
        while (count1 < n1) {
            count1++;
            
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(i)) {
                    i++;
                    if (i == s2.length()) {
                        i = 0;
                        count2++;
                    }
                }
            }
            
            // Cycle detection
            if (map.containsKey(i)) {
                int[] prev = map.get(i);
                int prevCount1 = prev[0];
                int prevCount2 = prev[1];
                
                int cycleLen = count1 - prevCount1;
                int cycleS2 = count2 - prevCount2;
                
                int remaining = n1 - count1;
                int cycles = remaining / cycleLen;
                
                count1 += cycles * cycleLen;
                count2 += cycles * cycleS2;
            } else {
                map.put(i, new int[]{count1, count2});
            }
        }
        
        return count2 / n2;
    }
}