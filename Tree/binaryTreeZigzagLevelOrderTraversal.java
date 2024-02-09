// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//           //103. Binary Tree Zigzag Level Order Traversal
//         List<List<Integer>> results=new ArrayList<>();
//         if(root==null){
//             return results;
//         }
//         Queue<TreeNode> queue=new LinkedList<>();
//         queue.offer(root);
//         int level=1;

//         while(!queue.isEmpty()){
//             List<Integer> result=new ArrayList<>();
//             int levelSize=queue.size();
//             for(int i=0;i<levelSize;i++){
//                 TreeNode current=queue.poll();
//                 if(current!=null){
//                     result.add(current.val);
//                 }
                
//                 if(current.left!=null){
//                     queue.offer(current.left);
//                 }
//                 if(current.right!=null){
//                     queue.offer(current.right);
//                 }
//             }

//             if(level%2==0){
//                 Collections.reverse(result);
//             }
//             results.add(result);
//             level++;
            
//         }

//         return results;
//     }
// }


// Most optimalå
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //103. Binary Tree Zigzag Level Order Traversal
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }

    private void traverse(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            result.get(level).add(node.val);
        } else {
            result.get(level).add(0, node.val);
        }

        traverse(node.left, result, level + 1);
        traverse(node.right, result, level + 1);
    }
}
