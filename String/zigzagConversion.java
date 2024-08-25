class Solution {
    public String convert(String s, int numRows) {
        // /6. Zigzag Conversion
        if (numRows == 1 || numRows >= s.length()) { // Wow nice
            return s;
        }
        StringBuilder result=new StringBuilder("");
        int increment=(numRows-1)*2;
        for(int k=0;k<numRows;k++){
            for(int i=k;i<s.length();i+=increment){
                result.append(s.charAt(i));
                if(k>0 && k<numRows-1 && i+increment-2*k < s.length()){
                    result.append(s.charAt(i+increment-2*k));
                }
            }
        }

        return result.toString();
    }
}

// Better solution

// class Solution {
//     public String convert(String s, int numRows) {
//         if(numRows==1 || numRows>=s.length()) return s;
//         StringBuilder sb = new StringBuilder();
//         for(int i=0;i<numRows;i++){
//             int idx= i;
//             int south = 2*(numRows- 1-i);
//             int north = 2*i;
//             boolean goingSouth = true;
//             while(idx<s.length()){
//                 sb.append(s.charAt(idx));
//                 if(i==0){
//                     idx+=south;
//                 }else if(i==numRows-1){
//                     idx+=north;
//                 }else{
//                     if(goingSouth){
//                         idx+=south;
//                     }else{
//                         idx+=north;
//                     }
//                     goingSouth=!goingSouth;
//                 }
//             }
//         }
//         return sb.toString();
//     }
// }