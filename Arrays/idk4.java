class Solution {
    // public int firstUniqChar(String s) {

    //     // char[] sortedS = Arrays.sort(s.toCharArray());
    //     for(int i=0; i <s.length(); i++){
    //         Boolean found = false;
    //         for(int j =0; j< s.length(); j++){
    //             if(i != j && s.charAt(i) == s.charAt(j)){
    //                 found = true;
    //                 break;
    //             }
            
    //         }

    //         if(! found) return i;



    //     }

    //     return -1;
        
    // }

    public int firstUniqChar(String s) {
    int index = -1;
    for(char ch : s.toCharArray()) {
        if(s.indexOf(ch) == s.lastIndexOf(ch)) {
            return s.indexOf(ch);
        }
    }

    return index;
}
}
