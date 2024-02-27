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

// Creates but unbalanced

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 108. Convert Sorted Array to Binary Search Tree
        TreeNode root=null;
        for(int num:nums){
            root=insertIntoBST(root,num);
        }
        return root;
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //701. Insert into a Binary Search Tree
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}

// Creates but unbalanced, same thing
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=null;
        int i=nums.length/2;
        int j=i-1;
        while(i<nums.length){
            root=insertIntoBST(root,nums[i]);
            i++;
        }
        while(j>=0){
            root=insertIntoBST(root,nums[j]);
            j--;
        }        
        return root;
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //701. Insert into a Binary Search Tree
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}


// Correct approach

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) { 
        //108. Convert Sorted Array to Binary Search Tree
        TreeNode root=null;   
        return sortedArrayToBST(nums,0,nums.length-1,root);
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int left, int right,TreeNode root) {
        if(! (left<=right)){
            return root;
        }
        //System.out.println("left:"+left+" right:"+right);
        int middle=left+(right-left)/2;  
        root = insertIntoBST(root,nums[middle]);
        root = sortedArrayToBST(nums,left,middle-1,root);
        root = sortedArrayToBST(nums,middle+1,right,root);

        return root;

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //701. Insert into a Binary Search Tree
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}


// Best readable code

    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int nums[], int l, int r) {
        if (l > r) { // Base Condition or Recursion Stoping Condition
            return null;
        }
        // so basically in this question we have to convert sorted array to height
        // balanced tree
        // so if we directly create tree in given sorted order it will become linked
        // list
        // so we have to take middle element as head value such it will become height
        // balanced tree
        int mid = l + (r - l) / 2; // this is the formula to find mid value
        TreeNode root = new TreeNode(nums[mid]); // mid value or median
        root.left = CreateBST(nums, l, mid - 1); // assign the value for left of subtree that is l to mid -1 for given
                                                 // array
        root.right = CreateBST(nums, mid + 1, r); // assign the value for right go subtree that is mid+1 to r for given
                                                  // array
        return root;
    }