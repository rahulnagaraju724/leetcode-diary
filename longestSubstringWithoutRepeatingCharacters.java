class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 3. Longest Substring Without Repeating Characters
        // What happens if the question is longest subsequence ....
        HashSet<Character> charSet=new HashSet<>();
        int longest=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            while(charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(i));
            longest=Math.max(longest,i-left+1);
        }

        return longest;
    }
}