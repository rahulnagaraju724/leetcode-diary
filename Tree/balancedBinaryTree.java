/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        //110. Balanced Binary Tree
        if(root==null){
            return true;
        }
        int num = Math.abs(getHeight(root.left)-getHeight(root.right));
        if (!(num==1 || num==0)){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
        
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}


// One more method
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Result {
    private int height;
    private boolean isBalanced;

    public Result(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }

    public int getHeight() {
        return height;
    }

    public boolean isBalanced() {
        return isBalanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        // int num = Math.abs(getHeight(root.left)-getHeight(root.right));
        // if (!(num==1 || num==0)){
        //     return false;
        // }
        // return isBalanced(root.left) && isBalanced(root.right);
        return checkBalanced(root).isBalanced();
        
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

    public Result checkBalanced(TreeNode root){
        if(root==null){
            return new Result(0,true);
        }
        Result leftResult=checkBalanced(root.left);
        Result rightResult=checkBalanced(root.right);
        boolean isBalanced=leftResult.isBalanced() && rightResult.isBalanced() && (Math.abs(leftResult.getHeight()-rightResult.getHeight())<=1);
        return new Result(1+Math.max(leftResult.getHeight() , rightResult.getHeight()) , isBalanced);
    }
}