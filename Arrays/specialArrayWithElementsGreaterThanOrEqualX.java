// My solution
class Solution {
    public int specialArray(int[] nums) {
        //1608. Special Array With X Elements Greater Than or Equal X
        for(int i=0;i<=nums.length;i++){
            int count=0;
            for(int num:nums){
                if(num>=i){
                    count++;
                }
                if(count>i){
                    break;
                }
            }
            if(count==i){
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int specialArray(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x+1];
        
        for(int elem : nums)
            if(elem >= x)
                counts[x]++;
            else
                counts[elem]++;
        
        int res = 0;
        for(int i = counts.length-1; i > 0; i--) {
            res += counts[i];
            if(res == i)
                return i;
        }
        
        return -1;
    }
}

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        if (nums[0] >= n) return n;
        
        for (int i = 1; i <= n; i++) {
            if (nums[n - i] >= i && (n - i - 1 < 0 || nums[n - i - 1] < i)) {
                return i;
            }
        }
        
        return -1;
    }
}

class Solution {
    public int specialArray(int[] nums) {
        int[] bucket = new int[1001];
        for (int num : nums) {
            bucket[num]++;
        }
        int total = nums.length;
        for (int i = 0; i < 1001; i++) {
            if (i == total) {
                return i;
            }
            total -= bucket[i];
        }
        return -1;
    }
}

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int candidateNumber = 1; candidateNumber <= n; ++candidateNumber) {
            if (candidateNumber == findNumberOfNums(nums, n, candidateNumber)) {
                return candidateNumber;
            }
        }

        return -1;
    }

    private int findNumberOfNums(int[] nums, int n, int curNum) {
        int left = 0, right = n - 1;
        int firstIndex = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= curNum) {
                firstIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return n - firstIndex;
    }
}

class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n + 1];

        for (int num : nums) {
            frequency[Math.min(n, num)]++;
        }

        int num_greater_equal = 0;
        for (int candidate_number = n; candidate_number > 0; --candidate_number) {
            num_greater_equal += frequency[candidate_number];
            if (candidate_number == num_greater_equal) {
                return candidate_number;
            }
        }

        return -1;
    }
}