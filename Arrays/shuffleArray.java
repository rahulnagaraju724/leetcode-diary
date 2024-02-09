class Solution {
    public int[] shuffle(int[] nums, int n) {
        //1470. Shuffle the Array
        int shuffle[]=new int[n*2];
        int k=0;
        for(int i=0;i<n;i++){
            shuffle[k]=nums[i];
            shuffle[k+1]=nums[i+n];
            k+=2;
        }
        return shuffle;
    }
}

// Really liked this solution, no another pointer int

// class Solution {
//     public int[] shuffle(int[] nums, int n) {
//         int[] result = new int[2*n];
//         for (int i = 0; i < n; i++) {
//             result[2 * i] = nums[i];
//             result[2 * i + 1] = nums[n + i];
//         }
//         return result;
//     }
// }