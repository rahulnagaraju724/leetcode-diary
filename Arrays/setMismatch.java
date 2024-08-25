class Solution {
    public int[] findErrorNums(int[] nums) {
        //645. Set Mismatch
        int[] numbers=new int[2];
        //HashSet<Integer> visitedSet=new HashSet<>();
        int[] visitedArray=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            // if(!visitedSet.add(nums[i])){
            //     numbers[0]=nums[i];
            // }
            visitedArray[nums[i]-1]++;
        }
        for(int j=0;j<visitedArray.length;j++){
            if(visitedArray[j]==0){
                numbers[1]=j+1;
            }
            else if(visitedArray[j]==2){
                numbers[0]=j+1;
            }
        }
        return numbers;
    }
}


// Worst solution

class Solution {
    public int[] findErrorNums(int[] nums) {
        //645. Set Mismatch
        int[] numbers=new int[2];
        if(nums.length==0){
            return numbers;
        }

        Arrays.sort(nums);
        int j=1;
        if(nums[0]!=j){
            numbers[1]=j;
        }
        j++;
        //2,2,3
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                numbers[0]=nums[i];
                continue;
            }
            if(nums[i]==j){
                j++;
            }else{
                if(numbers[1]==0){
                     numbers[1]=j;
                }
               
            }
        }
        if(numbers[1]==0){
            numbers[1]=j;
        }
        return numbers;
    }
}