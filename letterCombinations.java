class Solution {
    public List<String> letterCombinations(String digits) {
        // 17. Letter Combinations of a Phone Number

        if(digits.length()==0){
            return new ArrayList<>();
        }
        
        char[][] charArray = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };

        List<String> results=new ArrayList<>();
        StringBuilder str=new StringBuilder("");
        backTrack(digits,charArray,str,results,0);
        return results;
    }

    public void backTrack(String digits, char[][] charArray, StringBuilder str,List<String> results, int index){
        if(str.length()==digits.length()){
            results.add(str.toString());
            return;
        }
        if(index<digits.length()){

            int i=digits.charAt(index)-'0';
            for(char character:charArray[i-2]){
                str.append(character);
                backTrack(digits,charArray,str,results,index+1);
                str.deleteCharAt(str.length()-1);
            }

        }


    }
}