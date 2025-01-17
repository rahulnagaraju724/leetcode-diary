// Time complexity: O(2n) and Space Complexity: O(n)
class Solution {
    public int missingNumber(int[] nums) {
        boolean[] numbersFound=new boolean[nums.length+1];

        for(int num: nums){
            numbersFound[num]=true;
        }

        for(int i=0;i<numbersFound.length;i++){
            if(numbersFound[i]==false){
                return i;
            }
        }

        return 0;
    }
}

// Time complexity: O(n) and Space Complexity: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int n=nums.length;

        return ((n*(n+1))/2) - sum;
    }
}


// Time complexity: O(n) and Space Complexity: O(1)
class Solution{
public int missingNumber(int[] nums) { //xor
    //268. Missing Number
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
    }
    return res;
}
}

// Time complexity: O(n) and Space Complexity: O(1)
public int missingNumber(int[] nums) { //sum
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
        sum-=nums[i];
    return sum;
}

// Time complexity: O(nlogn + logn)) and Space Complexity: O(1)
public int missingNumber(int[] nums) { //binary search
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}