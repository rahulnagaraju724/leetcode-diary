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
// class Solution {
//     public int getMinimumDifference(TreeNode root) {
//         //530. Minimum Absolute Difference in BST . 
//          // This solution is wrong
//         return getMinimumDifference(root,Integer.MAX_VALUE);
//     }

//     public int getMinimumDifference(TreeNode root, int minimum){
//         if(root==null){
//             return minimum;
//         }
//         System.out.println(root.val);
//         if(root.left==null && root.right==null){
//             return minimum;
//         }
//         int leftMin,rightMin;
//         if(root.left==null){
//             minimum=Math.min(minimum,root.right.val-root.val);
//             return getMinimumDifference(root.right,minimum);
//         }else if (root.right==null){
//             minimum=Math.min(minimum,root.val-root.left.val);
//             return getMinimumDifference(root.left,minimum);
//         }else{
//             minimum=Math.min(minimum,root.right.val-root.val);
//             minimum=Math.min(minimum,root.val-root.left.val);
//         }
//         return Math.min(getMinimumDifference(root.left,minimum), getMinimumDifference(root.right,minimum));


//     }
// }

// class Solution {
//     public int getMinimumDifference(TreeNode root) {
//         //530. Minimum Absolute Difference in BST
//         ArrayList<Integer> inorder=new ArrayList<>();
//         inorderTraversal(root,inorder);
//         int minimum=Integer.MAX_VALUE;
//         for(int i=1;i<inorder.size();i++){
//             //minimum=Math.min(minimum, (inorder.get(i)-inorder.get(i-1)) );
//             // if(minimum==1){
//             //     return minimum;
//             // }
//             int value=(inorder.get(i)-inorder.get(i-1));
//             if(value==1){
//                 return value;
//             }
//             if(value<minimum){
//                 minimum=value;
//             }

//         }
//         return minimum;
//     }

//     public void inorderTraversal(TreeNode root, ArrayList<Integer> inorder){
//         if(root==null){
//             return;
//         }
//         inorderTraversal(root.left,inorder);
//         inorder.add(root.val);
//         inorderTraversal(root.right,inorder);
//     }

// }

// Good approach
public class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
    
}