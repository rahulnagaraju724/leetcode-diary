class Pair {
    int first;
    int second; 
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        //200. Number of Islands
        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];

        int result=0;

        int[][] directions=new int[4][2]; // URDL

        directions[0]=new int[]{-1,0};
        directions[1]=new int[]{0,1};
        directions[2]=new int[]{1,0};
        directions[3]=new int[]{0,-1};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    visited[i][j]=true;
                    result++;
                    findOthers(grid,visited,m,n,directions,i,j);
                    //bfs(i,j,visited,grid,m,n,directions);
                }
            }
        }

        return result;
    }

    // This is DFS
    public void findOthers(char[][] grid, boolean[][] visited, int m, int n, int[][] directions, int row, int col){
        for(int[] direction: directions){
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];
            if(nextRow<m && nextRow>=0 && nextCol<n && nextCol>=0){
                if(grid[nextRow][nextCol]=='1' && visited[nextRow][nextCol]==false){
                    visited[nextRow][nextCol]=true;
                    findOthers(grid,visited,m,n,directions,nextRow,nextCol);
                }

            }
        }// end for directions
        
    }//end DFS function
    
    // This is BFS
    public void bfs(int ro, int co, boolean[][] vis, char[][] grid, int m,int n,int[][] directions) {

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co)); 
        
        // until the queue becomes empty
        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            // traverse in the neighbours and mark them if its a land 
            for(int[] direction: directions){
                int nrow=row+direction[0];
                int ncol=col+direction[1];
                
                // check if neighbour row and column is valid, and is an unvisited land
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                && grid[nrow][ncol] == '1' && vis[nrow][ncol] == false) {
                    vis[nrow][ncol] = true; 
                    q.add(new Pair(nrow, ncol)); 
                }
            }
        }//end while queue
        
    }//end BFS function


}// End class solution






// My Old Code

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        int[][] visitSet = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && visitSet[i][j] == 0) {
                    bfs(grid, visitSet, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    public void bfs(char[][] grid, int[][] visitSet, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] pair = {i, j};
        queue.add(pair);
        visitSet[i][j] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] currentPair = queue.poll();
            int row = currentPair[0];
            int col = currentPair[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && visitSet[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol});
                    visitSet[newRow][newCol] = 1;
                }
            }
        }
    }
}


// Nice code

public class Solution {

    private int n;
    private int m;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }
    
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
    }