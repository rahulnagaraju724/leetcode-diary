class Solution {
    int minimum=Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        //931. Minimum Falling Path Sum
        List<Integer> list=new ArrayList<>();
        int[] indexes=new int[]{-1,0,1};
        for(int i=0;i<matrix[0].length;i++){
            list.add(matrix[0][i]);
            backtrack(matrix,minimum,list,indexes,1,i);
            list.remove(list.size()-1);
        }
        return minimum;
        
    }

    public void backtrack(int[][] matrix,int minimum,List<Integer> list,int[] indexes, int row, int prevCol){
        if(list.size()==matrix.length){
            //System.out.println("Here");
            int checkSum=sum(list);
            if(checkSum<this.minimum){
                //System.out.println("Inside mimimum Here");
                this.minimum=checkSum;
                //System.out.println("Minimum: "+minimum);
            }
            return;
        }
        if(row<matrix.length){
            for(int index:indexes){
                int col=prevCol+index;
                if(col>=0 && col<matrix[0].length){
                    
                    list.add(matrix[row][col]);
                    backtrack(matrix,minimum,list,indexes,row+1,col);
                    list.remove(list.size()-1);
                }
                
            }
        }

    }

    public int sum(List<Integer> list){
        int sum=0;
        for(int num:list){
            sum+=num;
        }
        //System.out.println("Sum: "+ sum);
        return sum;
    }

}





class Solution {
    int minimum=Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        //931. Minimum Falling Path Sum
        List<Integer> list=new ArrayList<>();
        int[] indexes=new int[]{-1,0,1};
        int checkSum=0;
        for(int i=0;i<matrix[0].length;i++){
            //list.add(matrix[0][i]);
            checkSum+=matrix[0][i];
            backtrack(matrix,checkSum,indexes,1,i);
            //list.remove(list.size()-1);
            checkSum-=matrix[0][i];
        }
        return minimum;
        
    }

    public void backtrack(int[][] matrix,int checkSum,int[] indexes, int row, int prevCol){
        if(row==matrix.length){
            //System.out.println("Here");
            //int checkSum=sum(list);
            if(checkSum<this.minimum){
                //System.out.println("Inside mimimum Here");
                this.minimum=checkSum;
                //System.out.println("Minimum: "+minimum);
            }
            return;
        }
        if(row<matrix.length){
            for(int index:indexes){
                int col=prevCol+index;
                if(col>=0 && col<matrix[0].length){

                    // list.add(matrix[row][col]);
                    checkSum+=matrix[row][col];
                    backtrack(matrix,checkSum,indexes,row+1,col);
                    //list.remove(list.size()-1);
                    checkSum-=matrix[row][col];
                }
                
            }
        }

    }

    public int sum(List<Integer> list){
        int sum=0;
        for(int num:list){
            sum+=num;
        }
        //System.out.println("Sum: "+ sum);
        return sum;
    }

}



class Solution {
    int minimum=Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        //931. Minimum Falling Path Sum
        List<Integer> list=new ArrayList<>();
        int[] indexes=new int[]{-1,0,1};
        int checkSum=0;
        for(int i=0;i<matrix[0].length;i++){
            //list.add(matrix[0][i]);
            checkSum+=matrix[0][i];
            backtrack(matrix,checkSum,indexes,1,i);
            //list.remove(list.size()-1);
            checkSum-=matrix[0][i];
        }
        return minimum;
        
    }
    public void backtrack(int[][] matrix,int checkSum,int[] indexes, int row, int prevCol){
        if(row==matrix.length){
            //System.out.println("Here");
            //int checkSum=sum(list);
            if(checkSum<this.minimum){
                //System.out.println("Inside mimimum Here");
                this.minimum=checkSum;
                //System.out.println("Minimum: "+minimum);
            }
            return;
        }
        if(row<matrix.length){
            for(int index:indexes){
                int col=prevCol+index;
                if(col>=0 && col<matrix[0].length){

                    // list.add(matrix[row][col]);
                    checkSum+=matrix[row][col];
                    backtrack(matrix,checkSum,indexes,row+1,col);
                    //list.remove(list.size()-1);
                    checkSum-=matrix[row][col];
                }
                
            }
        }

    }

    public int sum(List<Integer> list){
        int sum=0;
        for(int num:list){
            sum+=num;
        }
        //System.out.println("Sum: "+ sum);
        return sum;
    }

}