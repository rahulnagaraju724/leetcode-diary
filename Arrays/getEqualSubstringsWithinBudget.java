class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        //1208. Get Equal Substrings Within Budget
        int n=s.length();
        int costDiff[]=new int[n];
        for(int i=0;i<n;i++){
            costDiff[i]=Math.abs(s.charAt(i)-'a' - (t.charAt(i)-'a'));
        }
        int maxSubstring=0;
        for(int i=0;i<n;i++){
            if(i>0 && costDiff[i-1]==0){
                continue;
            }
            // if(i>maxSubstring){ // can't use this
            //     break;
            // }
            int count=0;
            for(int j=i;j<n;j++){
                count+=costDiff[j];
                if(count<=maxCost){
                    maxSubstring=Math.max(maxSubstring, j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxSubstring;
    }
}

// My optmised solution
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int costDiff[]=new int[n];
        for(int i=0;i<n;i++){
            costDiff[i]=Math.abs(s.charAt(i)-'a' - (t.charAt(i)-'a'));
            // System.out.print(costDiff[i]+", ");
        }
        
        int maxSubstring=0;
        int i=0;
        int j=0;
        int cost=0;
        while(j<n){
            if(costDiff[j]+cost<=maxCost){
                cost+=costDiff[j];
                maxSubstring=Math.max(maxSubstring,j-i+1);
                j++;
            }else{
                
                if(i<j){
                    cost-=costDiff[i];
                    i++;
                }
                else{
                    i++;
                    j=i;
                }
                
            }
        }
        return maxSubstring;
    }
}


class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int start = 0;
        int currentCost = 0;
        int maxLength = 0;

        for (int end = 0; end < n; ++end) {
            currentCost += Math.abs(s.charAt(end) - t.charAt(end));

            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                ++start;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}


class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // Convert the problem into a min subarray problem
        int[] diff = new int[s.length()];
        for(int i = 0; i < s.length(); ++i) {
            int asciiS = s.charAt(i);
            int asciiT = t.charAt(i);
            diff[i] = Math.abs(asciiS - asciiT);
        }
        
        // Now find the longest subarray <= maxCost
        // all diff[i] >= 0 (non-negative)
        
        // Use sliding window?
        int maxLen = 0;
        int curCost = 0;
        int start = 0;
        
        for(int end = 0; end < diff.length; ++end) {
            curCost += diff[end];
            while(curCost > maxCost) {
                curCost -= diff[start];
                ++start;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}
