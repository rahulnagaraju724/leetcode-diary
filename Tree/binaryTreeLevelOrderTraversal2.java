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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //107. Binary Tree Level Order Traversal II
        int height=getHeight(root);
        List<List<Integer>> results=new ArrayList<>();
        for(int i=height;i>=1;i--){
            List<Integer> result=new ArrayList<>();
            traverseInLevel(root,i,result);
            results.add(result);
        }
        return results;
    }

    public void traverseInLevel(TreeNode root, int level, List<Integer> result){
        if(root==null){
            return;
        }
        if(level==1){
            //System.out.println(root.val);
            result.add(root.val);
        }
        traverseInLevel(root.left,level-1,result);
        traverseInLevel(root.right,level-1,result);
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}