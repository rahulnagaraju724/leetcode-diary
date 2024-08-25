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

// Best approach
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return run(root, root, k);
    }
    // Think, like this method
    public boolean run(TreeNode root, TreeNode currentNode, int k) {
        if (currentNode == null) return false;
        if (find(root, k-currentNode.val, currentNode)) return true;
        
        return run(root, currentNode.left, k) || run(root, currentNode.right, k);
    }

    public boolean find(TreeNode root, int val, TreeNode current) {
        if (root == null) return false;
        if (val > root.val) return find(root.right, val, current);
        else if (val < root.val) return find( root.left, val, current);
        else if (val == root.val) return root != current;
        
        return false;
    }
}


// Another method
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        ArrayList<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            if(list.contains(k-list.get(i)) && (2*list.get(i)!=k)){
                return true;
            }
        }
        return false;
        
    }
	}