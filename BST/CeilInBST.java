public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here

        int ceil=Integer.MAX_VALUE;

        while(node!=null){
            if(node.data==x){
                ceil=x;
                return ceil;
            }
            else if(node.data>x){
                if((ceil-x) > node.data-x){
                    ceil=node.data;
                }
                node=node.left;
            }
            else{
                node=node.right;               
            }
        }
        //return ceil;
        return ceil==Integer.MAX_VALUE?-1:ceil;

    }
}