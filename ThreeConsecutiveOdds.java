class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        //1550. Three Consecutive Odds
        int left=0;
        int right=0;
        int n=arr.length;

        while(right<n){
            if(arr[right]%2==0){//if it's even
                left=right+1;
            }else{// if it's odd
                if(right-left==2){
                    return true;
                }
            }
            right++;
        }

        return false;

    }
}


class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;  // Initialize count to keep track of consecutive odd numbers

        for (int i = 0; i < arr.length; i++) {  // Iterate through each element in the array
            if (arr[i] % 2 != 0) {  // Check if the current element is odd
                count++;  // Increment the count if it's odd
                if (count == 3) {  // If we have found three consecutive odds, return true
                    return true;
                }
            } else {  // If the element is even, reset the count to 0
                count = 0;
            }
        }

        return false;  // If we finish the loop without finding three consecutive odds, return false
    }
}

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
    int odds = 0;
    for (int i = 0; i < arr.length && odds < 3; i++) {
        odds = (arr[i] % 2 == 1) ? odds + 1 : 0;
    }
    return odds == 3;
    }   
}

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int window = 0;
        for (int i = 0; i < 3 && i < arr.length; i++) {
            window += arr[i] % 2;
        }
        if (window == 3) {
            return true;
        }
        for (int i = 3; i < arr.length; i++) {
            window += arr[i] % 2;
            window -= arr[i - 3] % 2;
            if (window == 3) {
                return true;
            }
        }
        return false;
    }
}
