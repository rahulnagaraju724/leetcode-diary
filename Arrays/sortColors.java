class Solution {
    public void sortColors(int[] nums) {
        //75. Sort Colors
        int low=0;
        int middle=0;
        int high=nums.length-1;
        while(middle<=high){
            if(nums[middle]==0){
                swap(low,middle,nums);
                low++;
                middle++;
            }else if(nums[middle]==2){
                swap(middle,high,nums);
                high--;
            }else{
                middle++;
            }
        }
    }

    public void swap(int a, int b, int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    
}

public void sortColors(int[] nums) {
    //75. Sort Colors
    // 2-pass
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {count0++;}
        if (nums[i] == 1) {count1++;}
        if (nums[i] == 2) {count2++;}
    }
    for(int i = 0; i < nums.length; i++) {
        if (i < count0) {nums[i] = 0;}
        else if (i < count0 + count1) {nums[i] = 1;}
        else {nums[i] = 2;}
    }
}