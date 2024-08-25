class Solution {
    public int uniquePaths(int m, int n) {
        //62. Unique Paths
        // This approach is not great for run time
        // Instead try dynamic prgramming as discussed
       int[][] directions=new int[][]{{1,0},{0,1}};
       return uniquePaths(m, n, 0,0,directions);
    }
    
    public int uniquePaths(int m, int n, int row,int col, int[][] directions) {
        if(row==m-1 && col==n-1){
            return 1;
        }

        // Not needed as if loop checks m and n
        // if(row==m || col==n){
        //     return 0;
        // }

        int count=0;
        for(int[] direction: directions){
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];
            if(nextRow<m && nextCol<n){
                count+=uniquePaths(m, n, nextRow,nextCol,directions);
            }
        }
        return count;
    }



    
}