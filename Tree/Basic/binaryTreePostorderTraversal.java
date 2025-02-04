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

//https://leetcode.com/problems/binary-tree-postorder-traversal/solutions/5686247/5-different-methods-to-solve-postorder-traversal/?envType=daily-question&envId=2024-08-25

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //145. Binary Tree Postorder Traversal
        List<Integer> postorder=new ArrayList<>();
        postorderTraversal(root,postorder);
        return postorder;
    }
    // Recursive
    public void postorderTraversal(TreeNode root, List<Integer> postorder){
        if(root==null){
            return;
        }
        postorderTraversal(root.left,postorder);
        postorderTraversal(root.right,postorder);
        postorder.add(root.val);
    }
}