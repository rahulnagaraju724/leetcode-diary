class Solution {
    public void solveSudoku(char[][] board) {
        boolean value=solveSudoku(board,0,0);
    }

    public boolean solveSudoku(char[][] board,int row,int col){
        //37. Sudoku Solver
        if(row>=9){
            return true;
        }
        if(col>=9){
            return solveSudoku(board,row+1,0);
        }
        // for(int row=0;row<9;row++){
        //     for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(int i=1;i<=9;i++){
                        //check if these digits are okay to add
                        if(canAdd(board,(char) ('0'+i),row,col)){
                            board[row][col]=(char) ('0'+i);
                            boolean value = solveSudoku(board,row,col+1);
                            if(!value){
                                board[row][col]='.';
                            }
                        }
                    }
                    if(board[row][col]=='.'){
                        return false;
                    }
                }
                else{
                    return solveSudoku(board,row,col+1);
                }
        //     }
        // }
        return true;
    }

    public boolean canAdd(char[][] board, char num,int row,int col){
        //check row, iterate all cols
        for(int i=0;i<9;i++){
            if(board[row][i]==num){
                return false;
            }
        }

        //check col, iterate all rows
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }

        row=(row/3)*3;
        col=(col/3)*3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j]==num){
                    return false;
                 }
                
            }
        }
        return true;
    }
}