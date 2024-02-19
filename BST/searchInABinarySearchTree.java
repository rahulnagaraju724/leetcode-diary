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

//Recursive
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        //700. Search in a Binary Search Tree
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        if(val<root.val){
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }
}

//Iterative
class Solution {
	public TreeNode searchBST(TreeNode root, int val) {
        //700. Search in a Binary Search Tree
		while (root != null)
		{
			if ( val < root.val ) root = root.left;
			else if ( val > root.val ) root = root.right;
			else return root;
		}
		return root;
	}
}