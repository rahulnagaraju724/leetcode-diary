class Solution {
    public int[][] largestLocal(int[][] grid) {
        //2373. Largest Local Values in a Matrix
       int n=grid.length;
       int[][] maxLocal=new int[n-2][n-2];
       for(int i=0;i<n-2;i++){
        for(int j=0;j<n-2;j++){
            int max=0;


            for(int k=i;k<i+3;k++){ // not k<n
                for( int l=j;l<j+3;l++){ //not l<n
                    
                    // Matters a lot

                    // if(max<grid[k][l]){
                    //     max=grid[k][l];
                    // }
                    // max=Math.max(grid[k][l],max);
                    max=Math.max(max,grid[k][l]);
                }
            }

            maxLocal[i][j]=max;

        }
       }
       return maxLocal;
    }
}