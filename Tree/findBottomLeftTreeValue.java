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

// BFS
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        //513. Find Bottom Left Tree Value
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int element=root.val;

        while(! queue.isEmpty()){

            int size=queue.size();

            boolean added=false;

            for(int i=0;i<size;i++){

                TreeNode node= queue.poll(); 
                if(node.left!=null){
                    queue.offer(node.left);
                    if(added==false){
                        element=node.left.val;
                        added=true;
                    }
                }
                if(node.right!=null){
                    queue.offer(node.right);  
                    if(added==false){
                        element=node.right.val;
                        added=true;
                    }
                }
                
                
            }


        }

        return element;
    }
}

//DFS

 class NodeVal {
    private int val;
    private int level;

    public NodeVal(int val, int lvl) {
        this.val = val;
        this.level = lvl;
    }
    public int getVal(){
        return this.val;
    }

    public int getLvl(){
        return this.level;
    }

    public int setVal(int val){
        return this.val = val;
    }
    public int setLvl(int lvl){
        return this.level = lvl;
    }

}
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        //513. Find Bottom Left Tree Value
        if(root == null) {
            return 0;
        }
         
        NodeVal nv = dfs(root, 0); 
        return nv.getVal();
    }

    public NodeVal dfs(TreeNode node, int level) {
        if(node.left == null && node.right == null) {
            return new NodeVal(node.val, level);
        }
        NodeVal nodeValleft = null;
        NodeVal nodeValright = null;
        if(node.right != null)
            nodeValright = dfs(node.right, level + 1);
        if(node.left != null)
            nodeValleft = dfs(node.left, level + 1);
        if(node.left == null && node.right != null)
            return nodeValright;
        if(node.right == null && node.left != null)
            return nodeValleft;
        
        if(nodeValright.getLvl() > nodeValleft.getLvl()) {
            return nodeValright;
        } else 
            return nodeValleft;


    } 
}