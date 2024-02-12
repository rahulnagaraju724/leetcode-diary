import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList < String > findSum(int[][] arr, int n) {
        // Write your code here.
        ArrayList<String> answer=new ArrayList<>();

        HashMap<Character,int[]> directions=new HashMap<>();
        directions.put('U',new int[]{-1,0});
        directions.put('R',new int[]{0,1});
        directions.put('D',new int[]{1,0});
        directions.put('L',new int[]{0,-1});

        findSum(arr, n,answer,"",0,0,directions);

        Collections.sort(answer);
        
        return answer;
    }

    public static void findSum(int[][] arr, int n, ArrayList < String > answer, String s,int row, int col,HashMap<Character,int[]> directions) {
        if(row==n-1 && col==n-1){
            answer.add(s);
            return;
        }

        for (Map.Entry<Character, int[]> entry : directions.entrySet()) {
            Character c = entry.getKey();
            int[] direction = entry.getValue();

            int nextRow=direction[0];
            int nextCol=direction[1];
            
            if(checkIfCanGo(row, col, nextRow, nextCol, n, arr)){// safe to go
                
                arr[row][col]=0;
                s+=c;
                findSum(arr, n, answer, s, row+nextRow, col+nextCol, directions);
                s = s.substring(0, s.length() - 1);
                arr[row][col]=1;
                
            }
        }
        
        
    }

    public static boolean checkIfCanGo(int row,int col,int nextRow, int nextCol,int n,int[][] arr){
        if(row+nextRow>=0 && row+nextRow<n && col+nextCol>=0 && col+nextCol<n){
            if(arr[row+nextRow][col+nextCol]==1){
                return true;
            }
        }
        return false;
    }

}