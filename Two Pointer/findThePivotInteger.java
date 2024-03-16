class Solution {
    public int pivotInteger(int n) {
        //2485. Find the Pivot Integer
        if(n==1){
            return 1;
        }
       int left=1;
       int right=n;
       int leftSum=0;
       int rightSum=0;

       while(left<=right){
       
        //System.out.println(left+" "+right+" "+leftSum+" "+rightSum);
        
        if(leftSum==rightSum && leftSum!=0 && left==right){
            return left;
        }else if(leftSum<rightSum){   
            leftSum+=left;    
            left++;
            
        }else{ 
            rightSum+=right;   
            right--;
        }
       }
       return -1;
    }
}