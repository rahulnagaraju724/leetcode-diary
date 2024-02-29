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
                    minutes = rotOthersBFS(grid,m,n,directions,i,j,minutes);
                    break;
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

    public int rotOthersBFS(int[][] grid, int m, int n, int[][] directions, int row, int col, int minutes){

        Queue<int[]> queue=new ArrayDeque<>();
        int[] pair={row,col};
        queue.add(pair);

        while(!queue.isEmpty()){
            minutes++;
            System.out.println(minutes);

            int size=queue.size();

            for(int i=0;i<size;i++){

                int[] currentPair = queue.poll();

                // if(currentPair[0]==m-1 && currentPair[1]==n-1){
                //     return minutes-1;
                // }

                for(int[] direction: directions){
                    int nextRow=currentPair[0]+direction[0];
                    int nextCol=currentPair[1]+direction[1];
                    if(nextRow<m && nextRow>=0 && nextCol<n && nextCol>=0){
                        if(grid[nextRow][nextCol]==1){
                            grid[nextRow][nextCol]=2;
                            queue.add(new int[]{nextRow,nextCol}); 
                        }
                    }

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
