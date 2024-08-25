// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root==null){
//             return true;
//         }
//       return isSymmetric(root.left,root.right);  
//     }
//     public boolean isSymmetric(TreeNode leftPartRoot, TreeNode rightPartRoot){
//         if(leftPartRoot==null && rightPartRoot==null){
//             return true;
//         }
//         if(leftPartRoot==null || rightPartRoot==null){
//             return false;
//         }
//         if(leftPartRoot.val!=rightPartRoot.val){
//             return false;
//         }

//         return isSymmetric(leftPartRoot.left,rightPartRoot.right) && isSymmetric(leftPartRoot.right,rightPartRoot.left);
//     }
// }

// https://leetcode.com/problems/symmetric-tree/solutions/433170/ismirror-dfs-recursion-one-two-stacks-bfs-queue-solution-in-java/?envType=study-plan-v2&envId=top-100-liked

class Solution{
public boolean isSymmetric(TreeNode root) {
    if(root==null)  return true;
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode left, right;
    if(root.left!=null){
        if(root.right==null) return false;
        stack.push(root.left);
        stack.push(root.right);
    }
    else if(root.right!=null){
        return false;
    }
        
    while(!stack.empty()){
        if(stack.size()%2!=0)   return false;
        right = stack.pop();
        left = stack.pop();
        if(right.val!=left.val) return false;
        
        if(left.left!=null){
            if(right.right==null)   return false;
            stack.push(left.left);
            stack.push(right.right);
        }
        else if(right.right!=null){
            return false;
        }
            
        if(left.right!=null){
            if(right.left==null)   return false;
            stack.push(left.right);
            stack.push(right.left);
        }
        else if(right.left!=null){
            return false;
        }
    }
    
    return true;
}
}