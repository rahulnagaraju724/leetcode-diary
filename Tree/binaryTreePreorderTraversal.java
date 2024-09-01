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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                preorder.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        return preorder;
    }
}