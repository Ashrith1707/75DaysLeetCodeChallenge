class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int n=sb.length();
        int p1=0,p2=sb.length()-1;
       // char k[]=sb.toCharArray();
       while( p1<=p2){
        if(sb.charAt(p1)==sb.charAt(p2)){
            p1++;
            p2--;
        }else{
            return false;
        }
       }
       return true;
    }
}