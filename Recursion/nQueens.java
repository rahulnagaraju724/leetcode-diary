class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 51. N-Queens
        List<List<String>> results=new ArrayList<>();
        List<String> chessBoard=new ArrayList<>();

        String s="";
        for(int i=0;i<n;i++){
            s+=".";
        }
        for(int i=0;i<n;i++){
            chessBoard.add(s);
        }

        int [] leftRow=new int[n];
        int [] upperDiagonal=new int[2*n-1];
        int [] lowerDiagonal=new int[2*n-1]; 
        solveNQueens(n,results,chessBoard,0,leftRow,lowerDiagonal,upperDiagonal);
        //solveNQueens(n,results,chessBoard,0);
        return results;
    }

    public void solveNQueens(int n, List<List<String>> results,List<String> chessBoard,int col,int[] leftRow,int[] lowerDiagonal, int[] upperDiagonal){
        if(col==n){
            //add to results;
            results.add(new ArrayList<>(chessBoard));
            return;
        }

        for(int row=0;row<n;row++){
            //if(checkIfSafe(n,row,col,chessBoard)){// check if Q can go there row, col
            if(leftRow[row]==0 && upperDiagonal[row+col]==0 && lowerDiagonal[(col-row)+ (n-1)]==0){
                char[] rowChars = chessBoard.get(row).toCharArray();
                rowChars[col] = 'Q';
                chessBoard.set(row, new String(rowChars));

                leftRow[row]=1;
                upperDiagonal[(col-row)+ (n-1)]=1;
                lowerDiagonal[row+col]=1;

                solveNQueens(n, results, chessBoard, col + 1);

                leftRow[row]=0;
                upperDiagonal[(col-row)+ (n-1)]=0;
                lowerDiagonal[row+col]=0;

                rowChars[col] = '.';
                chessBoard.set(row, new String(rowChars));
            } 
            

        }
    }

    public void solveNQueens(int n, List<List<String>> results,List<String> chessBoard,int col){
        if(col==n){
            //add to results;
            results.add(new ArrayList<>(chessBoard));
            return;
        }

        for(int row=0;row<n;row++){
            if(checkIfSafe(n,row,col,chessBoard)){// check if Q can go there row, col
                char[] rowChars = chessBoard.get(row).toCharArray();
                rowChars[col] = 'Q';
                chessBoard.set(row, new String(rowChars));
                solveNQueens(n, results, chessBoard, col + 1);
                rowChars[col] = '.';
                chessBoard.set(row, new String(rowChars));
            } 
            

        }
    }

    public boolean checkIfSafe(int n,int row, int col,List<String> chessBoard){
        int dupRow=row;
        int dupCol=col;

        col--;
        while(col>=0){
            if(chessBoard.get(row).charAt(col)=='Q'){
                return false;
            }
            col--;
        }
        //Not need to do -1 or +1 as Queen is not there initially
        col=dupCol-1;
        row=dupRow-1;
        while(col>=0 && row>=0){
             if(chessBoard.get(row).charAt(col)=='Q'){
                return false;
             }
             row--;
             col--;
        }
        //Not need to do -1 or +1 as Queen is not there initially
        row=dupRow+1;
        col=dupCol-1;
        while(col>=0 && row<n){
             if(chessBoard.get(row).charAt(col)=='Q'){
                return false;
             }
             row++;
             col--;
        }
        return true;

    }
}