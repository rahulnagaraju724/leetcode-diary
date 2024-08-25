// class Solution {
//     public int findMaxLength(int[] nums) {
//        //525. Contiguous Array
//        int maximum=Integer.MIN_VALUE;
//        for(int i=0;i<nums.length;i++){
//             if(nums.length-i < maximum){
//                 continue;
//             }
//             int count1s=0;
//             int count0s=0;
//             for(int j=i;j<nums.length;j++){

                
//                 if(nums[j]==1){
//                     count1s++;
//                 }else{                          
//                     count0s++;
//                 }
//                 if(count0s==count1s){
//                     maximum=Math.max(maximum,2*count0s);
//                 }
                
//                 if(Math.abs(count0s-count1s) > nums.length-j){
//                     break;
//                 }
//             }
//         }
//         return maximum==Integer.MIN_VALUE? 0: maximum; 
//     }
// }

class Solution {
    public int findMaxLength(int[] nums) {

        int maxsum = 0;
        int currsum = 0;
        Map<Integer, Integer> track = new HashMap<>();
		
        track.put(0, -1);
		
        for(int i = 0; i < nums.length; i++){
            currsum += nums[i] == 0 ? -1 : nums[i];
			
            if(track.containsKey(currsum)){
                maxsum = Math.max(maxsum, i - track.get(currsum));
            } else {
                track.put(currsum, i);
            }
			
        }
		
        return maxsum;
    }
}