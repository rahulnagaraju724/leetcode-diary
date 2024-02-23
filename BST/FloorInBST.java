public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        
        int floor=Integer.MIN_VALUE;

        while(root!=null){
            if(root.data==X){
                floor=X;
                return floor;
            }
            else if(root.data<X){
                if((X-floor) > X-root.data){ // Overflow
                    floor=root.data;
                }
                root=root.right;
            }
            else{
                root=root.left;               
            }
        }
        //return ceil;
        return floor==Integer.MIN_VALUE?-1:floor;
    }
}

//Correct way
public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        
        int floor=Integer.MIN_VALUE;

        while(root!=null){
            if(root.data==X){
                floor=X;
                return floor;
            }
            else if(root.data<X){
                if((floor) < root.data){
                    floor=root.data;
                }
                root=root.right;
            }
            else{
                root=root.left;               
            }
        }
        //return ceil;
        return floor==Integer.MIN_VALUE?-1:floor;
    }
}
