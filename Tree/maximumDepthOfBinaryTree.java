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
    public int maxDepth(TreeNode root) {
        // 104. Maximum Depth of Binary Tree
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

// NOT BETTER BUT ONE MORE APPROACH

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
    public int maxDepth(TreeNode root) {
        //104. Maximum Depth of Binary Tree
        int depth=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        while(!queue.isEmpty() && queue.peek()!=null){ // MOST IMPORTANTN - queue.peek()!=null
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){ // Wrong i<queue.size() queue starts building up down
                TreeNode current=queue.poll();
                if(current!=null){

                    if (current.left != null) { //IMP
                        queue.offer(current.left);
                    }
                    if (current.right != null) {//IMP
                        queue.offer(current.right);
                    }
                }
    
            }
            depth++;
        
        }
        return depth;
    }
}