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
    public List<Integer> rightSideView(TreeNode root) {
        //199. Binary Tree Right Side View
        List<Integer> rightSideView=new ArrayList<>();
        if(root==null){
            return rightSideView;
        }
        rightSideView(root,rightSideView);
        return rightSideView;
    }
    public void rightSideView(TreeNode root,List<Integer> rightSideView){
        rightSideView.add(root.val);
        if(root.right!=null){
            rightSideView(root.right,rightSideView);
        }else if (root.left!=null){
            rightSideView(root.left,rightSideView);
        }
    }
}


// Betetr solution


public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}

// Another way to do
class Solution {
    int maxLevel=0;
    List<Integer>list=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return list;
        }
        method(root,1);
        return list; 
    }
    void method(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(maxLevel<level){
            list.add(root.val);
                maxLevel=level;
        }
        method(root.right,level+1);
        method(root.left,level+1);
    }
}