class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0){
            return false;
        }


        int[][] directions=new int[4][2]; // URDL

        directions[0]=new int[]{-1,0};
        directions[1]=new int[]{0,1};
        directions[2]=new int[]{1,0};
        directions[3]=new int[]{0,-1};

        int m=board.length;
        int n=board[0].length;

        int[][] visited=new int[m][n];

        for(int row=0;row<m;row++){
           for(int col=0;col<n;col++){
               if(exist(board,word,visited,0,0,0,directions,m,n)){
                   return true;
               }
           } 
        }
        return false;

    }

    public boolean exist(char[][] board, String word, int[][] visited, int row, int col,int index, int[][] directions,int m,int n) {
        if(index==word.length()){
            System.out.println("Visited here: row, col"+row+" "+col);
            return true;
        }

        // if(row==m){
        //     return false;
        // }

        // if(col==n){
        //     row=row+1;
        //     col=0;
        //     return (exist(board,word,visited,row,col,index,directions,m,n));
        
        // }

        // if(row<m){
            // if(col<n){

                if(board[row][col]==word.charAt(index)){
                    for(int[] direction: directions){
                        int nextRow=row+direction[0];
                        int nextCol=col+direction[1];
                        if(nextRow<m && nextRow>=0 && nextCol>=0 && nextCol<n && visited[nextRow][nextCol]==0){
                            visited[row][col]=1;
                            boolean value=exist(board,word,visited,nextRow,nextCol,index+1,directions,m,n);
                            if(!value){
                                visited[row][col]=0;
                            }
    
                        }
                    }
                }//end if

                else{
                    return false;
                }

        //     }
        // }

    return false;
    
    }


}