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
    int count=0;
    public int countNodes(TreeNode root) {
        //222. Count Complete Tree Nodes
        if(root!=null){
            count++;
            countNodes(root.left);
            countNodes(root.right);
        }
        return count;
    }
}

// Betetr approach

// class Solution {
//     public int countNodes(TreeNode root) {
//         return root == null? 0 : 1 + countNodes(root.left) + countNodes(root.right);
//     }
// }