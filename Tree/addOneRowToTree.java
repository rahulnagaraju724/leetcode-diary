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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //623. Add One Row to Tree
        TreeNode newNode=new TreeNode(val);
        if(root==null){
            return newNode;
        }
        if(depth==1){
            return new TreeNode(val,root,null);
        }

        return dfsAddOneRow(root,val,depth,1);

    }
    public TreeNode dfsAddOneRow(TreeNode root, int val, int depth,int currentDepth) {
        if(root==null){
            return null;
        }
        if(currentDepth==depth-1){
            TreeNode newNodeLeft=new TreeNode(val);
            TreeNode newNodeRight=new TreeNode(val);
            newNodeLeft.left=root.left;
            newNodeRight.right=root.right;
            root.left=newNodeLeft;
            root.right=newNodeRight;
            return root;
        }

        root.left=dfsAddOneRow(root.left,val,depth,currentDepth+1);
        root.right=dfsAddOneRow(root.right,val,depth,currentDepth+1);

        return root;
        
    }
    
}
