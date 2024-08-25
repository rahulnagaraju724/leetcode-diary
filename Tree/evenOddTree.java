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
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null){
            return true;
        }
        // if(root.val%2==0){
        //     return false;
        // }

        Queue<TreeNode> queue= new LinkedList<TreeNode>();

        queue.offer(root);

        int level=0;

        int prev=-1;
        int curr=0;

        while(! queue.isEmpty()){

            //ArrayList<Integer> levelOrder=new ArrayList<>();
            
            int size=queue.size();

            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                //levelOrder.add(node.val);

                //new code
                curr=node.val;
                if(findIfValid(prev,curr,level)==false){
                    System.out.println("level:"+level);
                    System.out.println("Prev:"+prev+" Curr:"+curr);
                    return false;
                }
                prev=curr;

                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }

            // if(checkLevelValue(levelOrder,level)==false){
            //     // System.out.println("level:"+level);
            //     // levelOrder.forEach(System.out::print);
            //     return false;
            // }    

            level++;   
            if(level%2==0){
                prev=-1;
                curr=0;
            }else{
                prev=Integer.MAX_VALUE-1;
                curr=0;
            }
        
        }
        return true;


    }

    public boolean checkLevelValue(ArrayList<Integer> levelOrder, int level){


        if(levelOrder.size()==1){ // This is needed when only one element is present
            int a=levelOrder.get(0);
            if(level%2==0){
                if(a%2==0){
                    return false;
                }
            }else{
                if(a%2==1){
                    return false;
                }
            }
        }


        for(int i=0;i<levelOrder.size()-1;i++){
            int a = levelOrder.get(i);
            int b=levelOrder.get(i+1);
            if(level%2==0){
                if(a%2==0 || b%2==0 || a>=b){
                    return false;
                }
            }else{
                if(a%2==1 || b%2==1 || a<=b){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findIfValid(int a, int b, int level){ // prev is a, curr is b
            if(level%2==0){
                if(a%2==0 || b%2==0 || a>=b){
                    return false;
                }
            }else{
                if(a%2==1 || b%2==1 || a<=b){
                    return false;
                }
            }
            return true;
    }
}

// Best solution
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
      var queue = new ArrayDeque<TreeNode>();
      queue.offer(root);
  
      var level = 0;
  
      while (!queue.isEmpty()) {
        var prev = level % 2 == 0 ? -1 : Integer.MAX_VALUE;
  
        for (var i = queue.size(); i > 0; i--) {
          var node = queue.poll();
  
          if (level % 2 == 0) {
            if (node.val % 2 == 0 || node.val <= prev) return false;
          } else {
            if (node.val % 2 == 1 || node.val >= prev) return false;
          }
          prev = node.val;
  
          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
        }
        level++;
      }
      return true;
    }
  }