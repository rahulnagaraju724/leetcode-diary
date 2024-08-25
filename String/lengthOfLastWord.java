// class Solution {
//     public int lengthOfLastWord(String s) {
//         String[] sArray = s.split(" ");
//         return sArray[sArray.length-1].length();
//     }
// }

// My solution
// class Solution {
//     public int lengthOfLastWord(String s) {
//         //58. Length of Last Word
//         int index=0;
//         for(int i=0;i<s.length();i++){

//             if(s.charAt(i)==' '){
//                 index=i;
//             }
//         }
//         return s.length()-index-1; //Good but what if extra spaces, and time consuming from start
//     }
// }

// My solution

// class Solution {
//     public int lengthOfLastWord(String s) {
//         //58. Length of Last Word
//         int indexChar=s.length(); // for last character index
//         // int indexSpace=0;
//         for(int i=s.length()-1;i>=0;i--){

//             if(s.charAt(i)!=' '){
//                 indexChar=i;
//                 i=i-1;
//                 while( i>=0 && s.charAt(i)!=' '){
//                     i--;
//                 }
//                 return i>=0? indexChar-i: indexChar+1 ; // if -1, then full string is word(s.length() not bcz sapce at end)

//             }

//         }
//         return s.length();
        
//     }
// }

// Best solution
class Solution {
    public int lengthOfLastWord(String s) {
        //58. Length of Last Word
        s = s.trim();
        
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            else{ //else if (length > 0) { // Not needed
                break;
            }
        }
        
        return length;
    }
}

// Same as above
// class Solution {
//     public int lengthOfLastWord(String s) {
//         int size = 0;
//         for(int i = s.length() - 1; i >= 0 ; i--){
//             if(s.charAt(i) == ' '){
//                 if(size > 0){
//                     break;
//                 }
//             }else{
//                 size++;
//             }
//         }
//         return size;
//     }
// }