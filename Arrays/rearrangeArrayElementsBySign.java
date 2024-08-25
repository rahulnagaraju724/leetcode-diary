class Solution {
    public int[] rearrangeArray(int[] nums) {
        //2149. Rearrange Array Elements by Sign

        int positive=0;
        int negative=0;
        int i=0;
        int n=nums.length;
        int[] answer=new int[n];
        while(i<n){
            
            //System.out.println("i: "+i+" Positive: "+positive+" Negative: "+negative);
            
            if(i%2==0){
                while(positive<n && ! (nums[positive]>0)){
                    positive++;
                }
                answer[i]=nums[positive];
                positive++;
            }else{
                while(negative<n && ! (nums[negative]<0)){
                    negative++;
                }
                answer[i]=nums[negative];
                negative++;
            }
            i++;
            
            //System.out.println(Arrays.toString(answer));
            
        }

        return answer;
    }
}

// Waah Waah
class Solution {
public int[] rearrangeArray(int[] nums) {
    //2149. Rearrange Array Elements by Sign
    int n = nums.length;
    int[] res = new int[n];
    int positive=0, negative=1;
    
    for(int i=0; i<n; i++){
        if(nums[i]>0){
            res[positive]=nums[i];
            positive += 2;
        }
        else{
            res[negative]=nums[i];
            negative += 2;
        }
    }
    
    return res;
    
}
}