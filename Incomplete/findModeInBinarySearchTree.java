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

// Not the approach
class Solution {
    public int[] findMode(TreeNode root) {
        boolean found=false;
        while(root!=null && !found){
            int value=findCount(root,root.val);
            if(value>1){
                found=true;
                // int[] array = new int[value]; // Create an int[] array of size n
                // Arrays.fill(array, root.val);    // Fill the array with the value X
                int[] array = new int[1];
                array[0]=root.val;
                return array;
            }
            // Good but now how to traverse left and right here without having stack
            root=root.right;
        }
        return new int[]{};
    }


    public int findCount(TreeNode root, int key){
        if(root==null){
            return 0;
        }
        else if(root.val==key){
            return 1+findCount(root.left,key)+findCount(root.right,key);
        }
        return findCount(root.left,key)+findCount(root.right,key);
    }
}


// To be continued

class Solution {
    public int[] findMode(TreeNode root) {
        if(root==null){
            return new int[]{};
        }

        int mode=2; // this is for frequency
        int[0]=2; // actual value
        return findMode(root,1,value,0);
    }

    public int[] findMode(TreeNode root, int highestFrequency, int value[], int index) {
        if(root==null){
            return new int[]{};
        }
        if(findCount(root,root.val)==highestFrequency){
            value[index++]=root.val;
        }
        if(findCount(root,root.val)>highestFrequency){
            highestFrequency=findCount(root,root.val);
            value[0]=root.val;
            index=1;
        }

        // if(findMode(root.left,highestFrequency,value,index) > findMode(root.right,highestFrequency,value,index)){

        // }
    }



    


    public int findCount(TreeNode root, int key){
        if(root==null){
            return 0;
        }
        else if(root.val==key){
            return 1+findCount(root.left,key)+findCount(root.right,key);
        }
        else if(root.val>key){ // Bcz element can be present in left
            return findCount(root.left,key);
        }        
        else if(root.val<key){ // Bcz element can be present in right
            return findCount(root.right,key);
        }
        return findCount(root.left,key)+findCount(root.right,key);
    }
}