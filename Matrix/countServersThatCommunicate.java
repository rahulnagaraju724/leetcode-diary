class Solution {
    public int countServers(int[][] grid) {
        //1267. Count Servers that Communicate
        int m=grid.length;
        int n=grid[0].length;
        int[] rowServerCount=new int[m];
        int[] colServerCount=new int[n];
        int counter=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rowServerCount[i]++;
                    colServerCount[j]++;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(rowServerCount[i]>1 || colServerCount[j]>1){
                        counter++;
                    }
                }
            }
        }

        return counter;
    }
}
