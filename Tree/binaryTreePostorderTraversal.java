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

    //Iterative
}