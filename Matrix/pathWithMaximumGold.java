class Solution {
    public int getMaximumGold(int[][] grid) {
        // 1219. Path with Maximum Gold
        int maximumGold=0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    continue;
                }
                maximumGold=Math.max(findGold(grid,m,n,i,j,new boolean[m][n],directions),maximumGold);
            }
        }
        return maximumGold;
    }

    public int findGold(int[][] grid, int m, int n, int row, int col, boolean[][] visited, int[][] directions){
        int max=0;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol]!=0 && !visited[newRow][newCol]){
                visited[row][col]=true;
                max=Math.max( grid[row][col]+findGold(grid,m,n,newRow,newCol,visited,directions),max);

                visited[row][col]=false;
            }
            
        }

        return Math.max(max, grid[row][col]);
    }
}

