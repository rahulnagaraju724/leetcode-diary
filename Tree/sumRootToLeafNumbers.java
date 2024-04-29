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

 // Not approach
class Solution {
    public int sumNumbers(TreeNode root) {
        //129. Sum Root to Leaf Numbers
        return dfs(root,0,"");
    }

    public int dfs(TreeNode root, int sum, String str){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            str+=Integer.toString(root.val);
            System.out.println("At leaf: "+root.val+ " STr;"+str);
            int value=Integer.parseInt(str);
            str=str.substring(0,str.length()-1);
            return value;
        }
        System.out.println("At root: "+root.val+ " Str;"+str);
        str+=Integer.toString(root.val);
        System.out.println("Sum1: "+sum);
        sum+=dfs(root.left,sum,str);
        System.out.println("Sum2: "+sum);
        sum+=dfs(root.right,sum,str);
        System.out.println("Sum3: "+sum);
        return sum;
    }
}

// Correct Approach
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        // Calculate the current sum
        sum = sum * 10 + root.val;
        // If it's a leaf node, return the sum
        if(root.left == null && root.right == null){
            return sum;
        }
        // Otherwise, continue DFS traversal
        int leftSum = dfs(root.left, sum);
        int rightSum = dfs(root.right, sum);
        // Sum up the results from left and right subtrees
        return leftSum + rightSum;
    }
}
