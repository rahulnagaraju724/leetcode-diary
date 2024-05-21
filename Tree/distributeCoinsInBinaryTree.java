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
    
    int result=0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    // array={size, coins} in that specific node

    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }

        if(root.left==null && root.right==null){
            result+=Math.abs(root.val-1);
            return new int[]{1,root.val}; //
        }

        int[] left=dfs(root.left);
        int[] right=dfs(root.right);

        int size=left[0]+right[0]+1;
        int coins=left[1]+right[1]+root.val;

        result+=Math.abs(size-coins);

        return new int[]{size, coins};
    }
}


// Wrong solution
class Solution {
    public int distributeCoins(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] arr=new int[2]; // arr[0]=moves, arr[1]=extraCoins
        dfs(root,arr);
        return arr[0];
    }

    public boolean dfs(TreeNode root, int[] arr){
        // int extraCoinsBefore=arr[1];
        if(root==null){
            return true;
        }

        // System.out.println("At node: "+root.val);
        // System.out.println("Array elements: moves: "+arr[0]+ " and extraCoins: "+arr[1]);


        if(arr[1]!=0){
            arr[0]+=arr[1];
        }

        // System.out.println("Node value: "+root.val);
        // System.out.println("after updating moves: Array elements: moves: "+arr[0]+ " and extraCoins: "+arr[1]);

        if(root.val==0){
            if(arr[1]!=0){
                root.val=1;
                arr[1]-=1;
            }
        }

        if(root.val>1){
            int temp=root.val-1;
            arr[1]=temp;
            root.val=1;
        }

        // System.out.println("Node value: "+root.val);
        // System.out.println("after updating coins: Array elements: moves: "+arr[0]+ " and extraCoins: "+arr[1]);

        if(root.left==null && root.right==null){
            if(root.val==1){
                // if(extraCoinsBefore>arr[1]){
                //     arr[0]=arr[0] - extraCoinsBefore+arr[1];
                // }
                return true;
            }
        }
        
        int extraCoinsBefore=arr[1];

        boolean rootLeft=dfs(root.left,arr);

        // System.out.println("Node value: "+root.val);
        // System.out.println("before updating myself: Array elements: moves: "+arr[0]+ " and extraCoins: "+arr[1]);

        if(root.val==0){
            if(extraCoinsBefore<arr[1]){
                System.out.println("Inside here");
                arr[0]=arr[0]+arr[1]-extraCoinsBefore;
            }
            root.val=1;
            arr[1]-=1;
            
        }else{
            if(extraCoinsBefore>arr[1]){
                arr[0]= arr[0]- ( extraCoinsBefore-arr[1]);
            }
        }
        // System.out.println("Node value: "+root.val);
        // System.out.println("after updating myself: Array elements: moves: "+arr[0]+ " and extraCoins: "+arr[1]);

        boolean rootRight=dfs(root.right,arr);

        if(rootLeft && rootRight){
            return true;
        }
        return false;
    }
}
