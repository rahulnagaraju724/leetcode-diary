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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 112. Path Sum
        if(root==null && targetSum==0){
            return false;
        }
        return checkPathSum(root,targetSum);
    }

    public boolean checkPathSum(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        targetSum-=root.val;
        if(root.left==null && root.right==null){
            if(targetSum==0){
                return true;
            }
            else{
                return false;
            }
        } 
        return checkPathSum(root.left,targetSum)||checkPathSum(root.right,targetSum);
    }
}

// Doesn't work, as it does'nt know if we have traversed from root to leaf or directly from root to null
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null && targetSum==0){
            return false;
        }
        return checkPathSum(root,targetSum);
    }

    public boolean checkPathSum(TreeNode root, int targetSum){
        if(root==null){
            if(targetSum==0){
                return true;
            }
            else{
                return false;
            }
        }
        targetSum-=root.val;
        return checkPathSum(root.left,targetSum)||checkPathSum(root.right,targetSum);
    }
}