vclass Solution {
    public int maxArea(int[] height) {
        //11. Container With Most Water
        int left=0;
        int right=height.length-1;
        int largestArea=0;
        while(left<right){
            if(height[left]<height[right]){
                largestArea=Math.max(largestArea,(right-left)*height[left]);
                left++;
            }
            else{
                largestArea=Math.max(largestArea,(right-left)*height[right]);
                right--;
            }
        }
        return largestArea;
    }
}
