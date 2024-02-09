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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        
        if(root.left==null){
            if(!(root.right.val>root.val) ) return false;
        }
        else if(root.right==null){
            if(! (root.left.val<root.val)) return false;
        }
        else{
            if(!(root.left.val<root.val && root.val<root.right.val)){
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}

// Right approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        // if((root.left==null && root.right==null) || root==null){//This is when given values are same as max and min, but it doesn't work
        //     return true;
        // }
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, int minimumRange, int maximumRange) {
        if(root==null){
            return true;
        }
        if(!(root.val>minimumRange && root.val<maximumRange)){
            return false;
        }
        return isValidBST(root.left,minimumRange,root.val) && isValidBST(root.right,root.val,maximumRange);
    }
}
// Long so that it checks right
class Solution {
    public boolean isValidBST(TreeNode root) {
        // if((root.left==null && root.right==null) || root==null){//This is when given values are same as max and min
        //     return true;
        // }
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long minimumRange, long maximumRange) {
        if(root==null){
            return true;
        }
        if(!(root.val>minimumRange && root.val<maximumRange)){
            return false;
        }
        return isValidBST(root.left,minimumRange,root.val) && isValidBST(root.right,root.val,maximumRange);
    }
}

// Learn this solution
public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
       while (root != null) {
          stack.push(root);
          root = root.left;
       }
       root = stack.pop();
       if(pre != null && root.val <= pre.val) return false;
       pre = root;
       root = root.right;
    }
    return true;
 }