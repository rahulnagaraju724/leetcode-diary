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
    public TreeNode deleteNode(TreeNode root, int key) {
        //450. Delete Node in a BST
        //But this approach does not maintain balance in the BST
        if(root==null){
            return root;
        }
        if(root.val==key){
            if(root.right==null){// if right null or both null
                return root.left;
            }else if(root.left==null){
                return root.right;
            }else{ // if both not null
                // We will put left to left most child of right
                TreeNode copyRoot=root;
                root=root.right;
                while(root.left!=null){ // find bottom left child of right
                    root=root.left;
                }
                root.left=copyRoot.left;
                return copyRoot.right;
            }

        }

        root.left=deleteNode(root.left,key);
        root.right=deleteNode(root.right,key);
        return root;
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //450. Delete Node in a BST
        //This maintains the balance in the BST
        if(root==null){
            return root;
        }
        if(root.val==key){
            if(root.right==null){// if right null or both null
                return root.left;
            }else if(root.left==null){
                return root.right;
            }else{ // if both not null LOGIC CHANGE ONLY HERE FRM ABOVE QSTN
                // Replace delete value with minimum value in right tree
                TreeNode copyRoot=root;
                root=root.right;
                while(root.left!=null){ // find bottom left child of right
                    root=root.left;
                }

                copyRoot.val=root.val;
                copyRoot.right=deleteNode(copyRoot.right,copyRoot.val);
                return copyRoot;
            }

        }

        root.left=deleteNode(root.left,key);
        root.right=deleteNode(root.right,key);
        return root;
    }
}