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
class Solution {
    public int goodNodes(TreeNode root) {
        //1448. Count Good Nodes in Binary Tree
        return goodNodes(root,Long.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, Long maximum){

        if(root==null){
            return 0;
        }

        maximum=Math.max(root.val,maximum);
        int left=goodNodes(root.left,maximum);
        int right=goodNodes(root.right,maximum);

        if(!(root.val>=maximum)){
            return left+right;
        }
        // maximum=Math.max(root.val,maximum);
        // int left=goodNodes(root.left,maximum);
        // int right=goodNodes(root.right,maximum);
        return 1+left+right;

    }
    
}

class Solution {
    int good;
    public int goodNodes(TreeNode root) {
        good = 0;
        cal(root, Integer.MIN_VALUE);
        return good;
    }
    void cal(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max) good++;
        max = Math.max(max, root.val);
        cal(root.left, max);
        cal(root.right, max);
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null){ return 0; }
        int count = 1;
        
        count += dfs(root.left, root.val);
        count += dfs(root.right, root.val);
        return count;
    }
    
    public int dfs(TreeNode root, int currentMax){
        
        int amount = 0; 
        if(root == null){ return 0; }
        if(root.val >= currentMax){
            amount++; 
            currentMax = root.val;
        }
        
        amount += dfs(root.left, currentMax);
        amount += dfs(root.right, currentMax);
        return amount; 
    }
}