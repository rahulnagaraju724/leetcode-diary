import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result=new ArrayList<>();
        largestDivisibleSubset(nums,result,nums.length-1,new ArrayList<>());
        return result;
    }
    public void largestDivisibleSubset(int[] nums,List<Integer> result,int index,List<Integer>temp) {
        if(index==-1){
            if(temp.size()>result.size()){
                result=new ArrayList<>(temp);     
            }
            return;
        }
        if(index>=0){
            if(checkDivisible(temp,nums[index])){// can add?
                temp.add(nums[index]);
                largestDivisibleSubset(nums,result,index--,temp);
                temp.remove(temp.size()-1);
                largestDivisibleSubset(nums,result,index--,temp);
            }
            else{
                //largestDivisibleSubset(nums,result,index--,temp);
            }
            // largestDivisibleSubset(nums,result,index--,temp);
            
            // largestDivisibleSubset(nums,result,index--,temp);

        }
    }

    public boolean checkDivisible(List<Integer> list,int value){
        for(int listElement:list){
            if(listElement%value!=0 || value%listElement!=0){
                return false;
            }
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input array
        int[] nums = {1, 2, 3};
        
        List<Integer> result = solution.largestDivisibleSubset(nums);
        
        // Print the result
        System.out.println("Largest Divisible Subset: " + result);
    }
}
