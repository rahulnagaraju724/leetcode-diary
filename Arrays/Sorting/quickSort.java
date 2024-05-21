class Solution {
    public int[] sortArray(int[] nums) {
        // int low=0;
        // int high=nums.length-1;
        // quickSort(nums,low,high);
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    // Not optimized
    public void quickSort(int[] nums, int low, int high){
        if(low<high){
            int pivot=quickSortPartition(nums,low,high);            
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }
    }

    public int quickSortPartition(int[] nums, int low, int high){
        int pivot=nums[low];
        int i=low;
        int j=high;

        //System.out.println("low: "+low+", high: "+high);

        while(i<j){

            //System.out.println("i: "+i+", j: "+j);
            
            while( i<=high-1 && pivot>=nums[i] ){ // y not start i from pivot index+1
                i++;
            }
            while( j>=low+1 && pivot<nums[j]){
                j--;
            }

            if(i<j){               
                //swap samller number found in the right side with larger number found in the left side
                // int temp=nums[i];
                // nums[i]=nums[j];
                // nums[j]=temp;
                swap(nums,i,j);
            }            
        }

        //swap j with low
        // int temp=nums[low];
        // nums[low]=nums[j];
        // nums[j]=temp;

        swap(nums,low,j);

        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
