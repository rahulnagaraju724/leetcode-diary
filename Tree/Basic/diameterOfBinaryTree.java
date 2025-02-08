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

class Result{
    int diameter;
    int height;

    public Result(){

    }
    public Result(int height,int diameter){
        this.height=height;
        this.diameter=diameter;
    }
}

class Solution {
    // 543. Diameter of Binary Tree
    public int diameterOfBinaryTree(TreeNode root) {
        Result result=maxDepth(root);
        return result.diameter;
    }

    public Result maxDepth(TreeNode root) {
        // 104. Maximum Depth of Binary Tree
        if(root==null){
            return new Result(0,0);
        }

        Result leftResult=maxDepth(root.left);
        Result rightResult=maxDepth(root.right);
        int height= 1+Math.max(leftResult.height,rightResult.height);
        int diameter=leftResult.height+rightResult.height;

        diameter=Math.max(diameter,leftResult.diameter);
        diameter=Math.max(diameter,rightResult.diameter);

        return new Result(height,diameter);
    }
}



public class Solution {
    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}


