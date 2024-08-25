class Solution {
    public int[] searchRange(int[] nums, int target) {
        //34. Find First and Last Position of Element in Sorted Array
        int[] resultList=new int[]{-1,-1};

        resultList[0]=findFirstOccurrence(nums,0,nums.length-1,target,-1);
        if(resultList[0]==-1){
            return resultList;
        }
        resultList[1]=findLastOccurrence(nums,0,nums.length-1,target,-1);
        return resultList;
    }
    public int findFirstOccurrence(int[] nums,int left, int right, int target, int pos){
        while(left<=right){
            int middle=left+(right-left)/2;
            System.out.println("Left : "+left+" Right: "+right+" Middle:"+middle);
            if(nums[middle]==target){
                System.out.println("Here 1: middle="+middle);
                pos=middle;
                right=middle-1;
                //findFirstOccurrence(nums,left,middle-1,target,middle);//update pos
            }
            if(nums[middle]>target){
                right=middle-1;
                //findFirstOccurrence(nums,left,middle-1,target,pos);
            }else if(nums[middle]<target) { // very very important, simple mistake made left++, hence left>right, loop ends
                left=middle+1;
                //findFirstOccurrence(nums,middle+1,right,target,pos);
            }
        }
        System.out.println("Here 1: pos="+pos);
        return pos;
    }
    public int findLastOccurrence(int[] nums,int left, int right, int target, int pos){
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                System.out.println("Here 2: middle="+middle);
                pos=middle;
                left=middle+1;
                //findLastOccurrence(nums,middle+1,right,target,middle);//update pos
            }
            if(nums[middle]>target){
                right=middle-1;
                //findLastOccurrence(nums,left,middle-1,target,pos);
            }else if(nums[middle]<target){ // very very important
                left=middle+1;
                //findLastOccurrence(nums,middle+1,right,target,pos);
            }
        }
        System.out.println("Here 2: pos="+pos);
        return pos;
    }

    // public int findFirstOccurrence(int[] nums,int left, int right, int target, int pos){
    //     if(left<=right){
    //         int middle=left+(right-left)/2;
    //         if(nums[middle]==target){
    //             System.out.println("Here 1: middle="+middle);
    //             findFirstOccurrence(nums,left,middle-1,target,middle);//update pos
    //         }
    //         if(nums[middle]>target){
    //             findFirstOccurrence(nums,left,middle-1,target,pos);
    //         }else{
    //             findFirstOccurrence(nums,middle+1,right,target,pos);
    //         }
    //     }
    //     System.out.println("Here 1: pos="+pos);
    //     return pos;
    // }
    // public int findLastOccurrence(int[] nums,int left, int right, int target, int pos){
    //     if(left<=right){
    //         int middle=left+(right-left)/2;
    //         if(nums[middle]==target){
    //             System.out.println("Here 2: middle="+middle);
    //             findLastOccurrence(nums,middle+1,right,target,middle);//update pos
    //         }
    //         if(nums[middle]>target){
    //             findLastOccurrence(nums,left,middle-1,target,pos);
    //         }else{
    //             findLastOccurrence(nums,middle+1,right,target,pos);
    //         }
    //     }
    //     System.out.println("Here 2: pos="+pos);
    //     return pos;
    // }
}