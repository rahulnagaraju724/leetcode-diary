import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution 
{
	public static int distinctIsland(int [][] grid, int m, int n) 
	{
		//write your code here
		
        // int m=grid.length;
        // int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];

        int result=0;

        int[][] directions=new int[4][2]; // URDL

        directions[0]=new int[]{-1,0};
        directions[1]=new int[]{0,1};
        directions[2]=new int[]{1,0};
        directions[3]=new int[]{0,-1};

		Set<ArrayList<ArrayList<Integer>>> set=new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    ArrayList<ArrayList<Integer>> pattern=new ArrayList<>();
                    visited[i][j]=true;
                    result++;

                    ArrayList<Integer> innerList = new ArrayList<>();
                    innerList.add(i - i);
                    innerList.add(j - j);

                    pattern.add(innerList);

                    findOthers(grid,visited,m,n,directions,i,j, i,j,pattern);
                    set.add(pattern);
                    //bfs(i,j,visited,grid,m,n,directions);
                }
            }
        }

        return set.size();
	}

	// This is DFS
    public static void findOthers(int[][] grid, boolean[][] visited, int m, int n, int[][] directions, int row, int col, int originalRow, int originalCol,ArrayList<ArrayList<Integer>> pattern){
        for(int[] direction: directions){
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];
            if(nextRow<m && nextRow>=0 && nextCol<n && nextCol>=0){
                if(grid[nextRow][nextCol]==1 && visited[nextRow][nextCol]==false){
                    
                    ArrayList<Integer> innerList = new ArrayList<>();
                    innerList.add(nextRow-originalRow);
                    innerList.add(nextCol-originalCol);

                    pattern.add(innerList);

                    visited[nextRow][nextCol]=true;
                    findOthers(grid,visited,m,n,directions,nextRow,nextCol,originalRow,originalCol,pattern);
                }

            }
        }// end for directions
        
    }//end DFS function
}
