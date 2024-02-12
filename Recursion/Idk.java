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
    public int getMinimumDifference(TreeNode root) {
        //530. Minimum Absolute Difference in BST
        return getMinimumDifference(root,Integer.MAX_VALUE);
    }

    public int getMinimumDifference(TreeNode root, int minimum){
        if(root==null){
            return minimum;
        }
        System.out.println(root.val);
        if(root.left==null && root.right==null){
            return minimum;
        }
        int leftMin,rightMin;
        if(root.left==null){
            minimum=Math.min(minimum,root.right.val-root.val);
            return getMinimumDifference(root.right,minimum);
        }else if (root.right==null){
            minimum=Math.min(minimum,root.val-root.left.val);
            return getMinimumDifference(root.left,minimum);
        }else{
            minimum=Math.min(minimum,root.right.val-root.val);
            minimum=Math.min(minimum,root.val-root.left.val);
        }
        return Math.min(getMinimumDifference(root.left,minimum), getMinimumDifference(root.right,minimum));


    }
}