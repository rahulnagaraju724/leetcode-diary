class Solution {
    public int strStr(String haystack, String needle) {
        //28. Find the Index of the First Occurrence in a String
        int k=0;
        for(int l=0;l< haystack.length();l++){
            int i=l; 
            while(k<needle.length() && i< haystack.length() && haystack.charAt(i)==needle.charAt(k)){
                k++;
                i++;
            }
            if(k==needle.length()){
                return i-needle.length();
            }
            k=0;
        }
        return -1;
    }
}

// Optimal Solution
class Solution {
    public int strStr(String haystack, String needle) {
        //28. Find the Index of the First Occurrence in a String
        for(int l=0;l< haystack.length();l++){
            int k=0;
            while(k<needle.length() && l+k < haystack.length() && haystack.charAt(l+k)==needle.charAt(k)){
                k++;
            }
            if(k==needle.length()){
                return l;
            }
        }
        return -1;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int nIndex = 0;
        for(int i=0; i<hLen; i++){
            // as long as the characters are equal, increment needleIndex
            if(haystack.charAt(i)==needle.charAt(nIndex)){
                nIndex++;
            }
            else{
                // start from the next index of previous start index
                i=i-nIndex;
                // needle should start from index 0
                nIndex=0;
            }
            // check if needleIndex reached needle length
            if(nIndex==nLen){
                // return the first index
                return i-nLen+1;
            }
        }
        return -1;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}