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

// But how can this work at each node or each level? Aren't we just checking root here? 
// Which is wrong right?
// No actually we are checking, but the thing is we are calculating height for every node
class Solution {
    public boolean isBalanced(TreeNode root) {
        //110. Balanced Binary Tree
        if(root==null){
            return true;
        }
        int num = Math.abs(getHeight(root.left)-getHeight(root.right));
        if (!(num==1 || num==0)){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
        
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}

// Solution starts here
// One more method
// This is great method here - credits to Saurabh
class Result {
    private int height;
    private boolean isBalanced;

    public Result(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }

    public int getHeight() {
        return height;
    }

    public boolean isBalanced() {
        return isBalanced;
    }
}
// This is great method here - credits to Saurabh
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        // int num = Math.abs(getHeight(root.left)-getHeight(root.right));
        // if (!(num==1 || num==0)){
        //     return false;
        // }
        // return isBalanced(root.left) && isBalanced(root.right);
        return checkBalanced(root).isBalanced();
        
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

    public Result checkBalanced(TreeNode root){
        if(root==null){
            return new Result(0,true);
        }
        Result leftResult=checkBalanced(root.left);
        Result rightResult=checkBalanced(root.right);
        boolean isBalanced=leftResult.isBalanced() && rightResult.isBalanced() && (Math.abs(leftResult.getHeight()-rightResult.getHeight())<=1);
        return new Result(1+Math.max(leftResult.getHeight() , rightResult.getHeight()) , isBalanced);
    }
}
// End solution here




// My solution - but is using global variable okay? 
class Solution {
    boolean balanced=true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1){
            balanced=false;
        }
        return 1+Math.max(left,right);
    }
}





class Solution {
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, we can say it’s balanced...
        if (root == null)  return true;
        // Height Function will return -1, when it’s an unbalanced tree...
		if (Height(root) == -1)  return false;
		return true;
	}
    // Create a function to return the “height” of a current subtree using recursion...
	public int Height(TreeNode root) {
        // Base case...
		if (root == null)  return 0;
        // Height of left subtree...
		int leftHeight = Height(root.left);
        // Height of height subtree...
		int rightHight = Height(root.right);
        // In case of left subtree or right subtree unbalanced, return -1...
		if (leftHeight == -1 || rightHight == -1)  return -1;
        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHight) > 1)  return -1;
        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
		return Math.max(leftHeight, rightHight) + 1;
    }
}