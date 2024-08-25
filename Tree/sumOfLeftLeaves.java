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

class Pair{
    TreeNode node;
    boolean left;
    public Pair(TreeNode node, boolean left){
        this.node=node;
        this.left=left;
    }
}
// To find sum of all first left nodes in each level
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        //404. Sum of Left Leaves
        if(root==null){
            return 0;
        }

        Queue<Pair> queue=new LinkedList<>();
        Pair pair=new Pair(root,false);
        queue.offer(pair);

        int sum=0;

        while(!queue.isEmpty()){
            
            int size=queue.size();
            for(int i=0;i<size;i++){
                pair=queue.poll();
                TreeNode node=pair.node;
                if(node.left!=null){
                    queue.offer(new Pair(node.left,true));
                }
                if(node.right!=null){
                    queue.offer(new Pair(node.right,false));
                }
                if(i==0 && pair.left){
                // if(i==0 && pair.left && node.left==null && node.right==null){
                    sum+=node.val;
                }
            }
        }
        return sum;
    }
}


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum={0};
        dfs(root,false,sum);
        return sum[0];
    }

    public void dfs(TreeNode root,boolean left,int[] sum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(left){
                sum[0]+=root.val;
            }
            
            return;
        }

        dfs(root.left,true,sum);
        dfs(root.right,false,sum);

    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    
    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) { // Leaf node
            return isLeft ? node.val : 0;
        }
        int leftSum = dfs(node.left, true);   // Traverse left child
        int rightSum = dfs(node.right, false); // Traverse right child
        return leftSum + rightSum;
    }
}


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<Pair<TreeNode, Boolean>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, false));  // (node, is_left)
        int totalSum = 0;
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Boolean> pair = queue.poll();
            TreeNode node = pair.getKey();
            boolean isLeft = pair.getValue();
            
            if (isLeft && node.left == null && node.right == null) {
                totalSum += node.val;
            }
            
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, true));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, false));
            }
        }
        
        return totalSum;
    }
}


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        
        return sum;
    }
}


