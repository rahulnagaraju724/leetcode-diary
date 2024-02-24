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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }

        Stack<TreeNode> stack=new Stack<>();
        boolean found=false;
        TreeNode copyRoot=root;

        while(root!=null || !stack.isEmpty()){
            //System.out.println(root.val);
            while(root!=null && !found){

                stack.push(root);
                //if(findNode(copyRoot,k-root.val,root)==true){
                //if(root.val*2!=k && findNode(copyRoot,k-root.val,root)==true){
                if(root.val*2!=k && findNode(copyRoot,k-root.val)==true){
                    found=true;
                    return found;
                }
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }


        return found;
    }


    public boolean findNode(TreeNode root, int x,TreeNode oldRoot) {
        if(root==null){
            return false;
        }
        if(root.val==x && root!=oldRoot){
            System.out.println("Found value here: "+x);
            return true;
        }
        if(root.val<x){
            return findNode(root.right,x,root);
        }
        else if(root.val>x){
            return findNode(root.left,x,root);
        }

        return false;

       
    }

    public boolean findNode(TreeNode root, int x) {
        if(root==null){
            return false;
        }
        if(root.val==x){
            System.out.println("Found value here: "+x);
            return true;
        }
        if(root.val<x){
            return findNode(root.right,x);
        }
        else if(root.val>x){
            return findNode(root.left,x);
        }

        return false;

       
    }
}