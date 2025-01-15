// 1,2,3,4,5,6,7
// 5,6,7,1,2,3,4

// First swap at rotate point
// 4,3,2,1,7,6,5
// then swap all
// 5,6,7,1,2,3,4

class Solution {
    public void rotate(int[] nums, int k) {
        //189. Rotate Array
        // First reverese entire array, and then reverse partitions
        // Time complexity: O(n+n-k+k)=O(2n) and Space Complexity: O(n)
        reverse(nums,0,nums.length-1);
        k=k%nums.length;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int []nums,int left,int right){
        while(left<=right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}

// But extra space
class Solution {
    public void rotate(int[] nums, int k) {
        //189. Rotate Array
        k=k%nums.length;
        k=nums.length-k;//position from reverse

        int i=0;
        int[] rotatedArray=new int[nums.length];

        while(k<nums.length){
            rotatedArray[i++]=nums[k++];
        }
        k=0;
        while(i<nums.length){
            rotatedArray[i++]=nums[k++];
        }
        //System.out.println(Arrays.toString(rotatedArray));
        for(i=0;i<nums.length;i++){
            nums[i]=rotatedArray[i];
        }
    }
}

// One more approach
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;
        
        //gcd path to finish movie
        for(int i = 0; i < gcd; i++){
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for(int j = 0; j < count; j++){
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }
    
    public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }
    
}


// Bad solution
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n<2){
            return;
        }
        k=k%n;
        reverse(nums,0,k);
        reverse(nums,k,n);
        reverse(nums,0,n);
    }

    // Somewhere logic wrong
    public void reverse(int[] nums, int i, int n){
        // int middle=(i+n)/2; // INcorrect for n exclusive
        int middle = i + (n - i) / 2;
        int j=n-1;
        for(;i<middle;i++,j--){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
        }
    }
}