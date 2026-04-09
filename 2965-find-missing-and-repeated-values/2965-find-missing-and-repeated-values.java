class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        HashSet<Integer> set=new HashSet<>();
        int[] a=new int[2];
        int x=0,y=0,Asum=0,Esum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Asum+=grid[i][j];
                if(set.contains(grid[i][j])){
                    x=grid[i][j];
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        int k=n*n;
        Esum=(k* (k+1))/2;
        y=Esum-(Asum-x);
        a[0]=x;
        a[1]=y;
        return a;
    }
}