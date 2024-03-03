class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        
        int[][] directions=new int[4][2]; // URDL

        directions[0]=new int[]{-1,0};
        directions[1]=new int[]{0,1};
        directions[2]=new int[]{1,0};
        directions[3]=new int[]{0,-1};

        int[][] newMatrix=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                if(mat[i][j]==1){
                    newMatrix[i][j] = updateMatrix(mat,m,n,directions,i,j);
                }
            }

        }
        return newMatrix;
    }

    public int updateMatrix(int[][] mat,int m,int n,int[][] directions, int row, int col) {
        if(mat[row][col]==0){
            return 0;
        }
        int prev=Integer.MAX_VALUE;
        for(int[] direction: directions){
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];
            if(nextRow<m && nextRow>=0 && nextCol<n && nextCol>=0){
                // if(mat[nextRow][nextCol]=0){
                //     return 1;
                // }
                prev = Math.min(prev,1+updateMatrix(mat,m,n,directions,nextRow,nextCol));
                if(prev==1){
                    return prev;
                }
            }
        }
        return prev;
    }
}