class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //1423. Maximum Points You Can Obtain from Cards
        int n=cardPoints.length;

        int i=0;
        int j=0;
        int minSum=Integer.MAX_VALUE;
        int sum=0;

        int totalSum=0;
        for(int points:cardPoints){
            totalSum+=points;
        }
        
        // This is window
        while(j<n-k){
            //totalSum+=cardPoints[j]; Thought of decreasing runtime but no luck
            sum+=cardPoints[j];
            j++;
        }
        minSum=Math.min(minSum,sum); 

        while(j<n){
            //totalSum+=cardPoints[j]; Thought of decreasing runtime but no luck
            sum-=cardPoints[i++];
            sum+=cardPoints[j++];
            minSum=Math.min(minSum,sum); 
        }

        return totalSum-minSum;
    }
}

public int maxScore(int[] cardPoints, int k) {
	int n = cardPoints.length, totalSum = 0, minSubarray = 0;

	for (int i=0, currSum=0; i<n; i++) {
		totalSum += cardPoints[i];
		currSum += cardPoints[i];
		if (i < n-k) minSubarray += cardPoints[i];
		else {
			currSum -= cardPoints[i-(n-k)];
			minSubarray = Math.min(minSubarray, currSum);
		}
	}

	return totalSum - minSubarray;
}

// Nice solution
class Solution {
    public int maxScore(int[] C, int K) {
        int total = 0;
        for (int i = 0; i < K; i++) total += C[i];
        int best = total;
        for (int i = K - 1, j = C.length - 1; i >= 0; i--, j--) {
            total += C[j] - C[i];
            best = Math.max(best, total);
        }
        return best;
    }
}