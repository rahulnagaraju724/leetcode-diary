// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         //14. Longest Common Prefix
//         String shortestString="";
//         int min=Integer.MAX_VALUE;
//         for(String str:strs){
//             if(str.length()<min){
//                 shortestString=str;
//                 min=str.length();
//             }
//         }

//         for(int i=0;i<min;i++){//flow takes f first
//             for(String str: strs){//flowers takes f, next flow f, fliught f       
//                 if((str.charAt(i)!=shortestString.charAt(i))){
//                     return shortestString.substring(0,i);
//                 }
                
//             }
//         }
//         //System.out.println(shortestString+min);
//         return shortestString;
//     }
// }

// class Solution {
//     public String longestCommonPrefix(String[] v) {
//         //14. Longest Common Prefix
//         StringBuilder ans = new StringBuilder();
//         Arrays.sort(v);
//         String first = v[0];
//         String last = v[v.length-1];
//         for (int i=0; i<Math.min(first.length(), last.length()); i++) {
//             if (first.charAt(i) != last.charAt(i)) {
//                 return ans.toString();
//             }
//             ans.append(first.charAt(i));
//         }
//         return ans.toString();
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //14. Longest Common Prefix
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}

/*
PLEASE UPVOTE IF IT HELPS YOU! THANK YOU!
Recommend to dry run along with the example.

Working:
1)Take the first(index=0) string in the array as prefix.
2)Iterate from second(index=1) string till the end.
3)Use the indexOf() function to check if the prefix is there in the strs[i] or not.
If the prefix is there the function returns 0 else -1.
4)Use the substring function to chop the last letter from prefix each time the function return -1.

eg:
strs=["flower", "flow", "flight"]
prefix=flower
index=1
    while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flower")!=0)
    Since flower as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flowe"
    Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flowe")!=0)
    Since flowe as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flow"
    Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flow")!=0)
    Since flow as a whole is in flow, it returns 0 so now prefix=flow
index=2
    while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flow")!=0)
    Since flow as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flo"
    Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flo")!=0)
    Since flo as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "fl"
    Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("fl")!=0)
    Since fl as a whole is in flight, it returns 0 so now prefix=fl
index=3, for loop terminates and we return prefix which is equal to fl
*/