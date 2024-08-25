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
    public List<Integer> inorderTraversal(TreeNode root) {
        //94. Binary Tree Inorder Traversal
        List<Integer> inorder=new ArrayList<>();
        inorderTraversal(root,inorder);
        return inorder;
    }

    //Recursive solution
    public void inorderTraversal(TreeNode root,List<Integer> inorder){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,inorder);
        inorder.add(root.val);
        inorderTraversal(root.right,inorder);
    }

}

// Iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //94. Binary Tree Inorder Traversal
        List<Integer> inorder=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null || !stack.empty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            inorder.add(root.val);
            root=root.right;
        }
        return inorder;
    }

}