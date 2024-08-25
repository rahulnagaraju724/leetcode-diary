/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //235. Lowest Common Ancestor of a Binary Search Tree
        if(root==null){
            return root;
        }
        if(p==root || q==root){
            return root;
        }
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        // if((p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val)){
        //     return root;
        // }
        return root;
    }
}