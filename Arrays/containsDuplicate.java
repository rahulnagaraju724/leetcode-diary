class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 217. Contains Duplicate
        // Can be done in Brute Force, Sorting and then search, hashset or hashmap
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }   
        return false;     
    }
}
// Helpful when indices are needed
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1)
                return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}