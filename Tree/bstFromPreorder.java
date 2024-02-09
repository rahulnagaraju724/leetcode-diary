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
//     public TreeNode bstFromPreorder(int[] preorder) {
//         //1008. Construct Binary Search Tree from Preorder Traversal
//         TreeNode root=new TreeNode();
//         for(int i=0;i<preorder.length;i++){
//             addNode(root,preorder[i]);
//         }
//         return root;
//     }

//     public void addNode(TreeNode root, int value){
//         if(root==null){
//             TreeNode newNode=new TreeNode(value);
//             root=newNode;
//             return;
//         }
//         if(value<root.val){
//             addNode(root.left,value);
//         }
//         else{
//             addNode(root.right,value);
//         }
//     }
// }

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        //1008. Construct Binary Search Tree from Preorder Traversal
        TreeNode root=null;
        for(int i=0;i<preorder.length;i++){
            root=addNode(root,preorder[i]);
        }
        return root;
    }

    public TreeNode addNode(TreeNode root, int value){
        if(root==null){
            return new TreeNode(value);
        }
        if(value<root.val){
            root.left=addNode(root.left,value);
        }
        else{
            root.right=addNode(root.right,value);
        }
        return root;
    }
}