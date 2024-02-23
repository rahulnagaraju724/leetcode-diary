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

// Java monotonic stack solution
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stk = new Stack<>();
        
        // Since first element of a preorder will always be a root
        TreeNode root = new TreeNode(preorder[0]); 
        stk.push(root);
        
        // Iterating through the elements after the root
        for(int i=1;i<preorder.length;i++){
            TreeNode node = new TreeNode(preorder[i]);
            
            // If a given element is smaller than the top of the stack, it will always be its left child
            if(node.val < stk.peek().val){
                stk.peek().left = node;
                stk.push(node);
            }else{
                // Popping elements until the first lowest element after current node's greatest element is found
                TreeNode temp = null;
                while(stk.size() != 0 && stk.peek().val < node.val){
                    temp = stk.pop();
                }
                
                // Joining current node to it's first lowest element from the root
                temp.right = node;
                stk.push(node);
            }
        }
        
        return root;
    }
}