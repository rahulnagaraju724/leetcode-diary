class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //733. Flood Fill
        // Nice, but do by copying your image to copyImage and without using visited 2 d array
        int m=image.length;
        int n=image[0].length;
        
        int[][] directions=new int[4][2]; // URDL

        boolean[][] visited=new boolean[m][n];

        directions[0]=new int[]{-1,0};
        directions[1]=new int[]{0,1};
        directions[2]=new int[]{1,0};
        directions[3]=new int[]{0,-1};
        
        floodFill(image,sr,sc,color,visited,directions,m,n,image[sr][sc]);

        return image; 
    }
    
    //This is DFS
    public void floodFill(int[][] image, int sr, int sc, int color,boolean[][] visited, int[][] directions,int m,int n,int originalColor) {

        if(sr<m && sr>=0 && sc<n && sc>=0){
            if(visited[sr][sc]==false && image[sr][sc]!=color && image[sr][sc]==originalColor){
                image[sr][sc]=color;
                visited[sr][sc]=true;
                for(int[] direction:directions){
                    floodFill(image,sr+direction[0],sc+direction[1],color,visited,directions,m,n,originalColor);
                }
            }
        }
       
       
    }
}


// Nice solution DFS
class Solution{
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int target = image[sr][sc];
    if(target == newColor){
        return image;
    }
    dfs(sr,sc,target,newColor,image);
    return image;
}
private void dfs(int row,int col,int target,int newColor,int[][] image){
    if(row < image.length && row >= 0 && col < image[0].length && col >= 0 && image[row][col] == target) {
        image[row][col] = newColor;
        dfs(row - 1, col, target, newColor, image);
        dfs(row, col - 1, target, newColor, image);
        dfs(row + 1, col, target, newColor, image);
        dfs(row, col + 1, target, newColor, image);
    }
}
}

// Nice solution BFS
class Solution{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];image[sr][sc] = newColor;
        if(target == newColor){
            return image;
        }

        final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
//        Queue<int[]> visited = new LinkedList<>();
        queue.add(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
//            visited.add(cur);
            for(int[] dir : directions){
                int row = cur[0] + dir[1];
                int col = cur[1] + dir[0];
//                if(isVaild(row,col,image,target) && !visited.contains(new int[]{row,col})){
                if(isVaild(row,col,image,target)){// target must != newColor,so if isVaild(row,col,image,target) is false, means this point is visited.
                    image[row][col] = newColor;
                    queue.add(new int[]{row,col});
                }
            }
        }
        return image;
    }

    private boolean isVaild(int row,int col,int[][] image,int target){
        if(row >= image.length || row < 0 || col >= image[0].length || col < 0 || image[row][col] != target){
            return false;
        }
        return true;
    }
}

// One more BFS

class Solution {
    int[][] dirs = {{1,0}, {0,1},{-1,0},{0,-1}};
    class Point{
      int x;
      int y;
      public Point(int x, int y){
        this.x = x;
        this.y = y;
      }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int old = image[sr][sc];
        if (old == newColor) return image;
            
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sr, sc));
        
        while (!q.isEmpty()){
            Point p = q.poll();
            image[p.x][p.y] = newColor;
            for(int[] d: dirs){
                int x = p.x + d[0];
                int y = p.y + d[1];
                if (isValid(image, x, y, m,n, old)) q.offer(new Point(x,y));              
            }
        }
        return image;    
    }
    
    public boolean isValid(int[][] image, int i, int j, int m, int n, int color){
        return i >=0 && i < m && j >= 0 && j < n && image[i][j] == color;
    }
}