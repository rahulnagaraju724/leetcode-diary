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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //102. Binary Tree Level Order Traversal
        int height=getHeight(root);
        List<List<Integer>> results=new ArrayList<>();
        for(int i=1;i<=height;i++){
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


// Most optimal solution

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //102. Binary Tree Level Order Traversal
        List<List<Integer>> results=new ArrayList<>();
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        while(!queue.isEmpty()){
            List<Integer> result=new ArrayList<>();
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){ // Wrong i<queue.size() queue starts building up down
                TreeNode current=queue.poll();
                if(current!=null){
                    queue.offer(current.left);
                    queue.offer(current.right);
                    result.add(current.val);
                }
    
            }
            if(!result.isEmpty()){ // Most important
                results.add(result);
            }
            
        }
        return results;
    }
    
    }