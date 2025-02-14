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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 112. Path Sum
        if(root==null && targetSum==0){
            return false;
        }
        return checkPathSum(root,targetSum);
    }

    public boolean checkPathSum(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        targetSum-=root.val;
        if(root.left==null && root.right==null){
            if(targetSum==0){
                return true;
            }
            else{
                return false;
            }
        } 
        return checkPathSum(root.left,targetSum)||checkPathSum(root.right,targetSum);
    }
}

// Better solution
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);
        
        return leftSum || rightSum;
    }
}

// Same solution
public boolean hasPathSum(TreeNode root, int sum) {
    // recursion method
    if (root == null) return false;
    if (root.left == null && root.right == null && root.val == sum) return true;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}

// Also good solution
class Solution {
    public boolean rootToLeafPathSum(TreeNode root, int targetSum, int sum){
        if(root == null)
            return false;
        if(root.left == null && root.right == null){
            sum = sum + root.val;
            if(sum == targetSum)
                return true;   
        }
        return rootToLeafPathSum(root.left, targetSum, sum + root.val) || rootToLeafPathSum(root.right, targetSum, sum + root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return rootToLeafPathSum(root, targetSum, sum);
    }
}

// Great
public boolean hasPathSum(TreeNode root, int sum) {
    // iteration method
    if (root == null) {return false;}
    Stack<TreeNode> path = new Stack<>();
    Stack<Integer> sub = new Stack<>();
    path.push(root);
    sub.push(root.val);
    while (!path.isEmpty()) {
        TreeNode temp = path.pop();
        int tempVal = sub.pop();
        if (temp.left == null && temp.right == null) {if (tempVal == sum) return true;}
        else {
            if (temp.left != null) {
                path.push(temp.left);
                sub.push(temp.left.val + tempVal);
            }
            if (temp.right != null) {
                path.push(temp.right);
                sub.push(temp.right.val + tempVal);
            }
        }
    }
    return false;
}

// My solution here initially, Doesn't work
// as it does'nt know if we have traversed from root to leaf or directly from root to null
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null && targetSum==0){
            return false;
        }
        return checkPathSum(root,targetSum);
    }

    public boolean checkPathSum(TreeNode root, int targetSum){
        if(root==null){
            if(targetSum==0){
                return true;
            }
            else{
                return false;
            }
        }
        targetSum-=root.val;
        return checkPathSum(root.left,targetSum)||checkPathSum(root.right,targetSum);
    }
}