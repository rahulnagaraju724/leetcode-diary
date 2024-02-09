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

// DID WRONG WHILE PASSING SET, TRAVERSE COUNT IS NOT REQUIRED
// class Solution {
//     int count =0;
//     public int pseudoPalindromicPaths (TreeNode root) {
//    //1457. Pseudo-Palindromic Paths in a Binary Tree
//         findPath(root,new HashSet<Integer>(), 0);
//         return count;
//     }

//     public void findPath(TreeNode root, HashSet<Integer> set, int traverseCount){
//         if(root==null){
//             return;
//         }
//         System.out.println(Arrays.toString(set.toArray()));

//         if(set.contains(root.val)){
//             set.remove(root.val);
//         }
//         else{
//             set.add(root.val);
//         }

//         traverseCount++;

//         if(root.left==null && root.right==null){
//             System.out.println(Arrays.toString(set.toArray()));
//             if(traverseCount%2==1){
//                 if(set.size()==1){
//                     System.out.println("Here 1");
//                     count++;
//                 }
//             }else{
//                 if(set.size()==0){
//                     System.out.println("Here 2");
//                     count++;
//                 }
//             }
//             System.out.println("Inside here, count is"+count);
            
//             return;
//         }

//         findPath(root.left,set,traverseCount);
//         findPath(root.right,set,traverseCount);
//         //
//     }
// }


class Solution {
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        //    //1457. Pseudo-Palindromic Paths in a Binary Tree
        findPath(root, new HashSet<Integer>());
        return count;
    }

    public void findPath(TreeNode root, HashSet<Integer> set) {
        if (root == null) {
            return;
        }

        if (set.contains(root.val)) {
            set.remove(root.val);
        } else {
            set.add(root.val);
        }

        if (root.left == null && root.right == null) {
            if (set.size() <= 1) {
                count++;
            }
            return;
        }

        findPath(root.left, new HashSet<>(set));
        findPath(root.right, new HashSet<>(set));
    }
}


// Most OPTmail apporach

class Solution {
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        //    //1457. Pseudo-Palindromic Paths in a Binary Tree
        dfs(root, new int[10]);
        return count;
    }

    private void dfs(TreeNode node, int[] frequency) {
        if (node == null) {
            return;
        }

        frequency[node.val]++;

        if (node.left == null && node.right == null) {
            if (isPseudoPalindromic(frequency)) {
                count++;
            }
        }

        dfs(node.left, frequency);
        dfs(node.right, frequency);

        frequency[node.val]--;
    }

    private boolean isPseudoPalindromic(int[] frequency) {
        int oddCount = 0;

        for (int count : frequency) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }
}
