class Solution {
    public int orangesRotting(int[][] grid) {
        
        int minutes=0;

        int[][] directions=new int[4][2]; // URDL

        directions[0]=new int[]{-1,0};
        directions[1]=new int[]{0,1};
        directions[2]=new int[]{1,0};
        directions[3]=new int[]{0,-1};

        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                if(grid[i][j]==2){
                    minutes = rotOthers(grid,m,n,directions,i,j,0);
                }
            }

        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                if(grid[i][j]==1){
                    return -1;
                }
            }

        }

        return minutes;
    }

    // This is DFS, but can't implement this, needeed BFS
    public int rotOthers(int[][] grid, int m, int n, int[][] directions, int row, int col, int minutes){
        for(int[] direction: directions){
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];
            if(nextRow<m && nextRow>=0 && nextCol<n && nextCol>=0){
                if(grid[nextRow][nextCol]==1){
                    grid[nextRow][nextCol]=2;
                    System.out.println(minutes);
                    return rotOthers(grid,m,n,directions,nextRow,nextCol,minutes+1);

                }

            }
        }// end for directions

        return minutes;
        
    }//end DFS function
}
