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
    public List<Integer> preorderTraversal(TreeNode root) {
        //144. Binary Tree Preorder Traversal
        List<Integer> preorder=new ArrayList<>();
        preorderTraversal(root,preorder);
        return preorder;
    }
    //Recursive
    public void preorderTraversal(TreeNode root, List<Integer> preorder){
        if(root==null){
            return;
        }
        preorder.add(root.val);
        preorderTraversal(root.left,preorder);
        preorderTraversal(root.right,preorder);
    }

    //Iterative
}