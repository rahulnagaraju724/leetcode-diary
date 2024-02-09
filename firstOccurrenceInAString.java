// class Solution {
//     public int strStr(String haystack, String needle) {
//         //28. Find the Index of the First Occurrence in a String
//         int k=0;
//         for(int l=0;l< haystack.length();l++){
//             int i=l; //Y simply 2 variables
//             while(k<needle.length() && i< haystack.length() && haystack.charAt(i)==needle.charAt(k)){
//                 k++;
//                 i++;
//             }
//             if(k==needle.length()){
//                 return i-needle.length();
//             }
//             k=0;
//         }
//         return -1;
//     }
// }

// Optimal Solution, doesn't work for equal length
// class Solution {
//     public int strStr(String haystack, String needle) {
//         //28. Find the Index of the First Occurrence in a String
//         for(int l=0;l< haystack.length()-needle.length();l++){
//             int k=0;
//             while(k<needle.length() && haystack.charAt(l+k)==needle.charAt(k)){
//                 k++;
//             }
//             if(k==needle.length()){
//                 return i-needle.length();
//             }
//         }
//         return -1;
//     }
// }

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