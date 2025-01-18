// Time complexity: O(2n+26) and Space Complexity: O(2*26)
class Solution {
    public boolean isAnagram(String s, String t) {
        //242. Valid Anagram
        int frequencyOfS[]= new int[26];
        int frequencyOfT[]=new int[26];
        for(int i=0;i<s.length();i++){
            frequencyOfS[s.charAt(i)-97]++;
        }
        for(int i=0;i<t.length();i++){
            frequencyOfT[t.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            if(frequencyOfS[i]!=frequencyOfT[i]){
                return false;
            }
        }
        return true;
    }
}

// Great solution
// Time complexity: O(2n+26) and Space Complexity: O(26)
// Is time O(n) or O(2n)
class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }
}

// Similar as above but Map here
// Time complexity: O(2n+n) and Space Complexity: O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}


// Is sorting necessary
// Time complexity: O(2* n logn + n) and Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}


class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        
        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}

