public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        
        int floor=Integer.MIN_VALUE;

        while(root!=null){
            if(root.data==X){
                floor=X;
                return floor;
            }
            else if(root.data<X){
                if((X-floor) > X-root.data){ // Overflow
                    floor=root.data;
                }
                root=root.right;
            }
            else{
                root=root.left;               
            }
        }
        //return ceil;
        return floor==Integer.MIN_VALUE?-1:floor;
    }
}

//Correct way
public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        
        int floor=Integer.MIN_VALUE;

        while(root!=null){
            if(root.data==X){
                floor=X;
                return floor;
            }
            else if(root.data<X){
                if((floor) < root.data){
                    floor=root.data;
                }
                root=root.right;
            }
            else{
                root=root.left;               
            }
        }
        //return ceil;
        return floor==Integer.MIN_VALUE?-1:floor;
    }
}

// Copied from Leetcode construct BST from Preorderc
public static int floorInBST(TreeNode root, int X) {
        
    int floor=Integer.MIN_VALUE;
    System.out.println(floor);

    while(root!=null){
        System.out.println("Root=:"+root.val);
        if(root.val==X){
            floor=X;
            return floor;
        }
        else if(root.val<X){
            System.out.println("Diff"+(X-floor));
            if((X-floor) > X-root.val){
                floor=root.val;
            }
            root=root.right;
        }
        else{
            root=root.left;               
        }
    }
    //return ceil;
    return floor==Integer.MIN_VALUE?-1:floor;
}